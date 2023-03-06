/**
 * 
 */
package africa.soimpaf.api_v1_303.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import africa.soimpaf.api_v1_303.models.Slider;
import africa.soimpaf.api_v1_303.repository.SliderRepository;

/**
 * @author digitalci
 *
 */
@RestController
@RequestMapping("/api/slider")
public class SliderController {
	
	@Autowired
	private SliderRepository sliderRepository;

	@GetMapping()
	public List<Slider> findAll() {
		return (List<Slider>) sliderRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Slider> findById(@PathVariable(value = "id") long id) {
		Optional<Slider> slider = sliderRepository.findById(id);
		if (slider.isPresent()) {
			return ResponseEntity.ok().body(slider.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping()
	public ResponseEntity<Slider> save(@Validated @RequestBody Slider slider) {
		return new ResponseEntity<>(sliderRepository.save(slider), HttpStatus.CREATED);
	}

	@DeleteMapping()
	public ResponseEntity<Slider> update(@Validated @RequestBody Slider slider) {
		return new ResponseEntity<>(sliderRepository.save(slider), HttpStatus.CREATED);
	}

	@PutMapping()
	public void delete(@Validated @RequestBody Slider slider) {
		sliderRepository.deleteById(slider.getId());
	}

}
