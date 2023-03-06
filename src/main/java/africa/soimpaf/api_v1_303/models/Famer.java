/**
 * 
 */
package africa.soimpaf.api_v1_303.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
@Table(name = "famers")
public class Famer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull(message = "Le nom est oligatoire")
	@NotBlank(message = "Le nom ne peut pas etre vide")
	private String name;

	@NotNull(message = "Le prenoms est oligatoire")
	@NotBlank(message = "Le prenoms ne peut  pas etre vide")
	private String first_name;

	@NotNull(message = "L'adresse mail est oligatoire")
	@NotBlank(message = "L'adresse mail ne peut  pas etre vide")
	@Email(message = "Ce que vous avez entré n'est pas un mail au bon format")
	@Column(nullable = false, updatable = true, unique = true)
	private String e_mail;

	private String email_verified_at;

	@NotNull(message = "Le mot de passe est oligatoire")
	@NotBlank(message = "Le mot de passe ne peut  pas etre vide")
	private String password;

	private String password_confirm;

	@Column(nullable = false, updatable = false)
	private String slug;

	private String picture;
	private String theme;

	@NotNull(message = "Le champ sexe est oligatoire")
	@NotBlank(message = "Le champ sexe ne peut pas etre vide")
	private Enum sexe;

	@NotNull(message = "Le numero de telephone est oligatoire")
	@NotBlank(message = "Le numero de telephone  pas etre vide")
	private String number_one;

	private String number_twoo;
	private Boolean famer_status;
	private Date date_of_birth;
	private Date created_at;
	private Date updated_at;

	/*
	 * le champ famer_id se remplir automatique en prenamt l'id de l'agriculteur
	 * connecté
	 */
	@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "famer_id", referencedColumnName = "id")
	private List<Product> produts;

	@OneToMany(targetEntity = Notification.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "famer_id", referencedColumnName = "id")
	private List<Notification> notifications;

	@OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "famer_id", referencedColumnName = "id")
	private List<Order> orders;

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
