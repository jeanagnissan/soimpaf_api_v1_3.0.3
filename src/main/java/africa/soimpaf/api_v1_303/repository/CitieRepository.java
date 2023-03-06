/**
 * 
 */
package africa.soimpaf.api_v1_303.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import africa.soimpaf.api_v1_303.models.Citie;

/**
 * @author digitalci
 *
 */
@Repository
public interface CitieRepository extends CrudRepository<Citie, Long> {

}
