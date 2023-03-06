/**
 * 
 */
package africa.soimpaf.api_v1_303.models;

import java.util.Date;

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
@Table(name = "comments")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private Boolean comment_status;

	@NotNull(message = "Le message est oligatoire")
	@NotBlank(message = "Le message ne peut pas etre vide")
	private String message;

	private String slug;

	private Date created_at;
	private Date updated_at;
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
