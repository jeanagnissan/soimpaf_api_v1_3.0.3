/**
 * 
 */
package africa.soimpaf.api_v1_303.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
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
@Table(name = "type_crops")
public class TypeCrop {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull(message = "Le nom est oligatoire")
	@NotBlank(message = "Le nom ne peut pas etre vide")
	private String name;

	private String slug;

	private Date created_at;
	private Date updated_at;

	@NotNull(message = "Le type de culture est oligatoire")
	@NotBlank(message = "Le type de culture ne peut pas etre vide")
	@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "type_crop_id", referencedColumnName = "id")
	private List<Product> products;

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
