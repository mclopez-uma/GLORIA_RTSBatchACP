package eu.gloria.rt.db.repository;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Repository database table.
 * 
 */
@Entity
@Table(name = "Repository")
public class Repository implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private String id;

	private int active;

	private int cod;

	private String connUrl;

	private String description;
 
	private String name;

	private String publicUrl;

    public Repository() {
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getActive() {
		return this.active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getCod() {
		return this.cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getConnUrl() {
		return this.connUrl;
	}

	public void setConnUrl(String connUrl) {
		this.connUrl = connUrl;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublicUrl() {
		return this.publicUrl;
	}

	public void setPublicUrl(String publicUrl) {
		this.publicUrl = publicUrl;
	}

}