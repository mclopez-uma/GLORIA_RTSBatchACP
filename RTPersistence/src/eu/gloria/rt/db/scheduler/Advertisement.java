package eu.gloria.rt.db.scheduler;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Advertisement")
public class Advertisement implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private String id;
	
	private String uuid;
	
	private String file;
	
	private String user;
	
	private String priority;
	
    @Temporal( TemporalType.TIMESTAMP)
	private Date received;
    
	@Temporal( TemporalType.TIMESTAMP)
	private Date deadline;
	
	@Temporal( TemporalType.TIMESTAMP)
	private Date processIni;
	
	@Temporal( TemporalType.TIMESTAMP)
	private Date processEnd;
	
	@Temporal( TemporalType.TIMESTAMP)
	private Date predIntervalIni;
	
	@Temporal( TemporalType.TIMESTAMP)
	private Date predIntervalEnd;
	
	@Temporal( TemporalType.TIMESTAMP)
	private Date predAstr;
	
	@Enumerated( EnumType.ORDINAL)
	private AdvertisementState state;
	
	private String comment;
	
    public Advertisement() {
    }

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getReceived() {
		return received;
	}

	public void setReceived(Date received) {
		this.received = received;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Date getProcessIni() {
		return processIni;
	}

	public void setProcessIni(Date processIni) {
		this.processIni = processIni;
	}
	
	public Date getProcessEnd() {
		return processEnd;
	}

	public void setProcessEnd(Date processEnd) {
		this.processEnd = processEnd;
	}

	public AdvertisementState getState() {
		return state;
	}

	public void setState(AdvertisementState state) {
		this.state = state;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getPredIntervalIni() {
		return predIntervalIni;
	}

	public void setPredIntervalIni(Date predIntervalIni) {
		this.predIntervalIni = predIntervalIni;
	}

	public Date getPredIntervalEnd() {
		return predIntervalEnd;
	}

	public void setPredIntervalEnd(Date predIntervalEnd) {
		this.predIntervalEnd = predIntervalEnd;
	}

	public Date getPredAstr() {
		return predAstr;
	}

	public void setPredAstr(Date predAstr) {
		this.predAstr = predAstr;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

}
