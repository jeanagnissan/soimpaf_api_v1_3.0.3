/**
 * 
 */
package africa.soimpaf.api_v1_303.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * @author digitalci
 *
 */
@Getter
@Setter
@Entity
@Table(name = "admins")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull(message = "Le nom est oligatoire")
	@NotBlank(message = "Le nom ne peut pas etre vide")
	private String name;

	@NotNull(message = "Le prenoms est oligatoire")
	@NotBlank(message = "Le prenoms ne peut  pas etre vide")
	private String first_name;

	@Email(message = "Ce que vous avez entré n'est pas un mail au bon format")
	@Column(nullable = false, updatable = true, unique = true)
	private String e_mail;

	@NotNull(message = "Le mot de passe est oligatoire")
	@NotBlank(message = "Le mot de passe ne peut  pas etre vide")
	private String password;

	@Column(nullable = false, updatable = false)
	private String slug;

	private String picture;
	private short admin_status;
	private String theme;

	@NotNull(message = "Le numero de telephone est oligatoire")
	@NotBlank(message = "Le numero de telephone  pas etre vide")
	private String number_one;

	private Date created_at;
	private Date updated_at;
	
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
