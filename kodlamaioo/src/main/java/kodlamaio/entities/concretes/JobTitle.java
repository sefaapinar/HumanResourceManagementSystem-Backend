package kodlamaio.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;


@Entity
@Table(name="job_titles")
@Data
public class JobTitle {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="position")
	@NotBlank(message="Pozisyon Alanı Boş Olamaz.")
	private String position;
	
	public JobTitle() {
		
	}
	
	public JobTitle(int id, String position) {
		super();
		this.id=id;
		this.position=position;
	}
}
