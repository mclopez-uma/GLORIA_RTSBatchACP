package eu.gloria.rt.db.repository;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the RepFile database table.
 * 
 */
@Entity
@Table(name = "RepFile")
public class RepFile implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private String id;

	@Enumerated( EnumType.ORDINAL)
	private RepFileContentType contentType;

	@Temporal( TemporalType.TIMESTAMP)
	private Date date;

	private String uuid;
	
	@Enumerated( EnumType.ORDINAL)
	private RepFileType type;

	//bi-directional many-to-one association to RepObservingPlan
    @ManyToOne
	@JoinColumn(name="opId")
	private RepObservingPlan repObservingPlan;
    
   //bi-directional many-to-one association to RepFile
  	//@OneToMany(fetch=FetchType.EAGER, mappedBy="repFile")
    @OneToMany(mappedBy="repFile")
  	@LazyCollection(LazyCollectionOption.FALSE)
  	private List<RepFileFormat> repFormats;

    public RepFile() {
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RepFileContentType getContentType() {
		return this.contentType;
	}

	public void setContentType(RepFileContentType contentType) {
		this.contentType = contentType;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public RepObservingPlan getRepObservingPlan() {
		return this.repObservingPlan;
	}

	public void setRepObservingPlan(RepObservingPlan repObservingPlan) {
		this.repObservingPlan = repObservingPlan;
	}

	public List<RepFileFormat> getRepFormats() {
		return repFormats;
	}

	public void setRepFormats(List<RepFileFormat> repFormats) {
		this.repFormats = repFormats;
	}

	public RepFileType getType() {
		return type;
	}

	public void setType(RepFileType type) {
		this.type = type;
	}
	
}