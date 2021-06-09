package kodlamaio.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_postings")
public class JobPosting {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity = JobTitle.class ,fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "job_position_id", referencedColumnName =  "id" ,nullable = false)
	private JobTitle jobTitle;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne(targetEntity = City.class ,fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "city_id", referencedColumnName =  "id" ,nullable = false)
	private City city;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="closed_date")
	private Date closedDate;
	
	@Column(name="is_active")
	private boolean isActive=false;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="open_position_number")
	private int openPositionNumber;
	
	@ManyToOne(targetEntity = Employer.class ,fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "employer_id", referencedColumnName =  "user_id" ,nullable = false)
	private Employer employer;
}
