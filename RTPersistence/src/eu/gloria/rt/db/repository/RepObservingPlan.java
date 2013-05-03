package eu.gloria.rt.db.repository;

import java.io.Serializable;
import javax.persistence.*;

import eu.gloria.rt.db.task.TaskProperty;

import java.util.List;
import java.util.Set;


/**
 * The persistent class for the RepObservingPlan database table.
 * 
 */
@Entity
@Table(name = "RepObservingPlan")
public class RepObservingPlan implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private String id;

	@Enumerated( EnumType.ORDINAL)
	private RepObservingPlanOwner owner;

	@Enumerated( EnumType.ORDINAL)
	private RepObservingPlanType type;

	private String user;

	private String uuid;

	//bi-directional many-to-one association to RepFile
	@OneToMany(fetch=FetchType.EAGER, mappedBy="repObservingPlan")
	private List<RepFile> repFiles;

    public RepObservingPlan() {
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RepObservingPlanOwner getOwner() {
		return this.owner;
	}

	public void setOwner(RepObservingPlanOwner owner) {
		this.owner = owner;
	}

	public RepObservingPlanType getType() {
		return this.type;
	}

	public void setType(RepObservingPlanType type) {
		this.type = type;
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

	public List<RepFile> getRepFiles() {
		return this.repFiles;
	}

	public void setRepFiles(List<RepFile> repFiles) {
		this.repFiles = repFiles;
	}
	
}