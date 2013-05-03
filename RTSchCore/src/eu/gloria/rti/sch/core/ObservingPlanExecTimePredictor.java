package eu.gloria.rti.sch.core;

import java.util.List;

import eu.gloria.rt.entity.scheduler.plan.CameraSettings;
import eu.gloria.rt.entity.scheduler.plan.Expose;
import eu.gloria.rt.entity.scheduler.plan.Loop;
import eu.gloria.rt.entity.scheduler.plan.Target;
import eu.gloria.rt.exception.RTSchException;
import eu.gloria.rti.sch.core.ObservingPlan;
import eu.gloria.rti.sch.core.plan.instruction.Instruction;


/**
 * Predictor of OP Execution time.
 * 
 * @author jcabello
 *
 */
public class ObservingPlanExecTimePredictor {
	
	private long millisecondsMountMove = 10000;
	private long millisecondsFilterMove = 3000;
	private long millisecondsLooseness = 5000;
	private long millisecondsCameraSettings = 500;
	
	public long getPredictExecTime(ObservingPlan op) throws RTSchException {
		
		long result = millisecondsLooseness;
		
		result = result + getPredictExecTime(op.getInstructions());
		
		return result;
		
	}
	
	
	private long getPredictExecTime(Object item) throws RTSchException {
		
		long result = 0;
		
		if (item instanceof List){
			
			List<Instruction> list = (List<Instruction>) item;
		
			for (int x = 0; x < list.size(); x++){
			
				Object obj = list.get(x);
				
				result = result + getPredictExecTime(obj);
			}
			
		} else if (item instanceof Target){
			
			result = result + millisecondsMountMove;
			
		} else if (item instanceof CameraSettings){
			
			result = result + millisecondsCameraSettings;
			
		}else if (item instanceof Loop){
			
			Loop tmpItemSource = (Loop) item;
			
			if (tmpItemSource.getRepeatCount() != null){
				
				result = result + (getPredictExecTime(tmpItemSource.getTargetOrCameraSettingsOrLoop()) * tmpItemSource.getRepeatCount().intValue());
				
			} else if (tmpItemSource.getRepeatDuration() != null){
				
				result = result + (new Double(tmpItemSource.getRepeatDuration()*1000)).longValue();
			}
			
		}else if (item instanceof Expose){
			
			Expose tmpItemSource = (Expose) item;
			
			if (tmpItemSource.getFilter() != null){
				result = result + millisecondsFilterMove;
			}
			
			result = result + (new Double(tmpItemSource.getExpositionTime()*1000)).longValue();
			
		}
		
		return result;
	}

}
