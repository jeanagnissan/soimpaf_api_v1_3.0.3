/**
 * 
 */
package africa.soimpaf.api_v1_303.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import africa.soimpaf.api_v1_303.models.Slider;

/**
 * @author digitalci
 *
 */
@Repository
public interface SliderRepository extends CrudRepository<Slider, Long> {

}
