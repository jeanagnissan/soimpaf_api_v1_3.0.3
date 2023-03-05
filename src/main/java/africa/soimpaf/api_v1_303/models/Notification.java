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
@Table(name = "notifications")
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull(message = "Le nom est oligatoire")
	@NotBlank(message = "Le nom ne peut pas etre vide")
	private Enum transmitter_type;

	private Boolean read;

	@Column(nullable = false, updatable = false)
	private String slug;

	private Date created_at;
	private Date updated_at;

}
