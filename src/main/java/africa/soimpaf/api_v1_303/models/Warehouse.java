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
@Table(name = "warehouses")
public class Warehouse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull(message = "Le nom est oligatoire")
	@NotBlank(message = "Le nom ne peut  pas etre vide")
	private String name;

	private String coded;

	@Column(nullable = false, updatable = false)
	private String slug;

	@NotNull(message = "L'heure d'ouverture  est oligatoire")
	@NotBlank(message = "L'heure d'ouverture ne peut pas etre vide")
	private Date opening_time;

	@NotNull(message = "L'heure de fermeture est oligatoire")
	@NotBlank(message = "L'heure de fermeture ne peut pas etre vide")
	private Date closing_time;

	private Double localisation;

	private Boolean waherouse_status;

	private Date created_at;
	private Date updated_at;

	@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "waherouse_id", referencedColumnName = "id")
	private List<Product> produts;

}
