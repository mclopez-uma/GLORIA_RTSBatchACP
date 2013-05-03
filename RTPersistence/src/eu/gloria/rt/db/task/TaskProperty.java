package eu.gloria.rt.db.task;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TaskProperty database table.
 * 
 */
@Entity
public class TaskProperty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private String id;

	private String name;

	@Enumerated( EnumType.ORDINAL)
	private TaskPropertyType type;

	private String value;

	//bi-directional many-to-one association to Task
    @ManyToOne
	@JoinColumn(name="idtask")
	private Task task;

    public TaskProperty() {
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TaskPropertyType getType() {
		return this.type;
	}

	public void setType(TaskPropertyType type) {
		this.type = type;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	
}