package kodlamaio.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="candidate_users")
@PrimaryKeyJoinColumn(name = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Candidate extends User {
	
	@NotBlank(message="Ad Alanı Boş Geçilemez")
	@Size(min = 2, message = "En Az 2 Karakter ve Üzeri Yazılır.") 
	@Column(name="name")
	private String name;
	
		
	@NotBlank(message="Soyisim Alanı Boş olamaz")
	@Column(name="surname")
	private String surname;
	
	@NotBlank(message="TC Kimlik Numarası Alanı Boş Geçilemez") 
	@Size(min = 11, max=11, message = "TCKimlik No 11 hane olmalıdır")
	@Column(name="national_identity")
	private String nationalIdentity;
	
	@NotBlank(message="Doğum Yılı Tarihi Alanı Boş Geçilemez.")
	@Column(name="birth_year")
	private String birth_year;
	
	

}