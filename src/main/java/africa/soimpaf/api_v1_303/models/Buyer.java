/**
 * 
 */
package africa.soimpaf.api_v1_303.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
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
@Table(name = "buyers")
public class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull(message = "Le nom est oligatoire")
	@NotBlank(message = "Le nom ne peut pas etre vide")
	private String name;

	@NotNull(message = "Le prenoms est oligatoire")
	@NotBlank(message = "Le prenoms ne peut  pas etre vide")
	private String first_name;

	@Email(message = "Ce que vous entrez n'est pas un mail au bon format")
	private String e_mail;

	private String email_verified_at;

	@NotNull(message = "Le mot de passe est oligatoire")
	@NotBlank(message = "Le mot de passe ne peut  pas etre vide")
	private String password;

	@NotNull(message = "Le numero de telephone est oligatoire")
	@NotBlank(message = "Le numero de telephone  pas etre vide")
	private String number_one;

//	@Enumerated
	private Enum sexe;

	private String slug;

	private char Buyer_status;
	private String theme;
	private String picture;

	private Date created_at;
	private Date updated_at;

	@OneToMany(targetEntity = Notification.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "buyer_id", referencedColumnName = "id")
	private List<Notification> notifications;

	@OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "buyer_id", referencedColumnName = "id")
	private List<Order> orders;

	@OneToMany(targetEntity = Rating.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "buyer_id", referencedColumnName = "id")
	private List<Rating> ratings;

	@OneToMany(targetEntity = Comment.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "buyer_id", referencedColumnName = "id")
	private List<Comment> comments;

}
