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
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull(message = "Le nom est oligatoire")
	@NotBlank(message = "Le nom ne peut  pas etre vide")
	private String name;

	@NotNull(message = "La masse est oligatoire")
	@NotBlank(message = "La masse ne peut pas etre vide")
	private Double mass_avaibale;

	@NotNull(message = "L'image est oligatoire")
	@NotBlank(message = "L'image ne peut pas etre vide")
	private String picture;

	@NotNull(message = "Le prix est oligatoire")
	@NotBlank(message = "Le prix ne peut  pas etre vide")
	private Float price;

	private short product_status;

	@NotNull(message = "La description est oligatoire")
	@NotBlank(message = "La description ne peut  pas etre vide")
	private String description;

	private String slug;

	/*
	 * lorsque le champs dispatch est à false, le champ storage_area devient
	 * obligatoire lorsque le champs dispatch est à true, le champ warehouse_id
	 * devient obligatoire
	 */
	private Boolean dispatch;
	private String storage_area;

	private Date created_at;
	private Date updated_at;
	
	@OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private List<Order> orders;

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}


}
