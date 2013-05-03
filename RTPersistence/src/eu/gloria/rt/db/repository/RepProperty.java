package eu.gloria.rt.db.repository;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RepProperty database table.
 * 
 */
@Entity
@Table(name = "RepProperty")
public class RepProperty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private String id;

	private String name;

	private String value;

    public RepProperty() {
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

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}