/**
 * 
 */
package africa.soimpaf.api_v1_303.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import africa.soimpaf.api_v1_303.models.Product;

/**
 * @author digitalci
 *
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
