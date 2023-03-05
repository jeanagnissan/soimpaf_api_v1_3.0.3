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
import lombok.Getter;
import lombok.Setter;

/**
 * @author digitalci
 *
 */
@Getter
@Setter
@Entity
@Table(name = "order_history")
public class OrderHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false, updatable = false)
	private Double mass;

	@Column(nullable = false, updatable = false)
	private String coded;

	private short order_status;

	@Column(nullable = false, updatable = false)
	private Float commission;

	@Column(nullable = false, updatable = false)
	private Float tax;

	@Column(nullable = false, updatable = false)
	private String slug;

	@Column(nullable = false, updatable = false)
	private Integer order_id;

	@Column(nullable = false, updatable = false)
	private Integer buyer_id;

	@Column(nullable = false, updatable = false)
	private Integer famer_id;

	private Date created_at;
	private Date updated_at;

}
