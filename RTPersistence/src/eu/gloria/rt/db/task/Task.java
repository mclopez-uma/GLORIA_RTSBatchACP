package eu.gloria.rt.db.task;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the Task database table.
 * 
 */
@Entity
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private String id;

	private int enable;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="last_exec")
	private Date lastExec;

	private String name;

	private String provider;

    @Temporal( TemporalType.TIMESTAMP)
	private Date start;

    @Temporal( TemporalType.TIMESTAMP)
	private Date stop;
    
    private int sleepTime;

	//bi-directional many-to-one association to TaskProperty
	@OneToMany(fetch=FetchType.EAGER, mappedBy="task")
	private List<TaskProperty> taskProperties;

    public Task() {
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getEnable() {
		return this.enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	public Date getLastExec() {
		return this.lastExec;
	}

	public void setLastExec(Date lastExec) {
		this.lastExec = lastExec;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvider() {
		return this.provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public Date getStart() {
		return this.start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getStop() {
		return this.stop;
	}

	public void setStop(Date stop) {
		this.stop = stop;
	}

	public List<TaskProperty> getTaskProperties() {
		return this.taskProperties;
	}

	public void setTaskProperties(List<TaskProperty> taskProperties) {
		this.taskProperties = taskProperties;
	}

	public int getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(int sleepTime) {
		this.sleepTime = sleepTime;
	}
	
}