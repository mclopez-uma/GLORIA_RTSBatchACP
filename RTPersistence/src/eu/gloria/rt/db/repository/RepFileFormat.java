package eu.gloria.rt.db.repository;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RepFileFormat database table.
 * 
 */
@Entity
@Table(name = "RepFileFormat")
public class RepFileFormat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private String id;

	@Enumerated( EnumType.ORDINAL)
	private FileFormat format;
	
	//bi-directional many-to-one association to RepObservingPlan
    @ManyToOne
	@JoinColumn(name="fileId")
	private RepFile repFile;

    public RepFileFormat() {
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public FileFormat getFormat() {
		return this.format;
	}

	public void setFormat(FileFormat format) {
		this.format = format;
	}

	public RepFile getRepFile() {
		return repFile;
	}

	public void setRepFile(RepFile repFile) {
		this.repFile = repFile;
	}

}