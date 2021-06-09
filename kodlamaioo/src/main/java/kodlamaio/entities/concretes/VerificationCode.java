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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="verification_codes")
@NoArgsConstructor
@AllArgsConstructor
public class VerificationCode {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	@JsonIgnore
	private int id;
	
	@Column(name="code")
	@JsonIgnore
	private String code;
	
	@Column(name="is_verified")
	@JsonIgnore
	private boolean is_verified;
	
	@ManyToOne(targetEntity = User.class ,fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", referencedColumnName =  "id" ,nullable = false)
	@JsonIgnore
	private User user_id;
	
	@JsonIgnore
	@Column(name="created_date")
	private Date createdDate;
	
	@JsonIgnore
	@Column(name="verified_date")
	private Date verified_date;

	
}
