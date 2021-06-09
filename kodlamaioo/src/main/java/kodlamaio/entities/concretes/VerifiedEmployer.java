package kodlamaio.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="verified_employer_users")
public class VerifiedEmployer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@JsonIgnore
	private int id;

	@OneToOne(targetEntity=Employer.class)
	@JoinColumn(name="employer_id",referencedColumnName="user_id")
	private Employer employer;
	
	@Column(name="verified_staff_user")
	private int staffUser;
	
	@Column(name="verified_date")
	private Date verifiedDate;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	
}
