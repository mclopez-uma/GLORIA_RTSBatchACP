package eu.gloria.rt.db.scheduler;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the ObservingPlan database table.
 * 
 */
@Entity
@Table(name = "ObservingPlan")
public class ObservingPlan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private String id;

	private String comment;

    @Temporal( TemporalType.TIMESTAMP)
	private Date execDateEnd;

    @Temporal( TemporalType.TIMESTAMP)
	private Date execDateIni;

	private String file;

	private String priority;

	private Date scheduleDateEnd;

	private Date scheduleDateIni;

	@Enumerated( EnumType.ORDINAL)
	private ObservingPlanState state;

	private String user;

	private String uuid;

    public ObservingPlan() {
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getExecDateEnd() {
		return this.execDateEnd;
	}

	public void setExecDateEnd(Date execDateEnd) {
		this.execDateEnd = execDateEnd;
	}

	public Date getExecDateIni() {
		return this.execDateIni;
	}

	public void setExecDateIni(Date execDateIni) {
		this.execDateIni = execDateIni;
	}

	public String getFile() {
		return this.file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getScheduleDateEnd() {
		return this.scheduleDateEnd;
	}

	public void setScheduleDateEnd(Date scheduleDateEnd) {
		this.scheduleDateEnd = scheduleDateEnd;
	}

	public Date getScheduleDateIni() {
		return this.scheduleDateIni;
	}

	public void setScheduleDateIni(Date scheduleDateIni) {
		this.scheduleDateIni = scheduleDateIni;
	}

	public ObservingPlanState getState() {
		return this.state;
	}

	public void setState(ObservingPlanState state) {
		this.state = state;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}