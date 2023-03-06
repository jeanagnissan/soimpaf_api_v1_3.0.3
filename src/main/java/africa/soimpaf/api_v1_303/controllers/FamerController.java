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

import africa.soimpaf.api_v1_303.models.Famer;
import africa.soimpaf.api_v1_303.repository.FamerRepository;

/**
 * @author digitalci
 *
 */
@RestController
@RequestMapping("/api/famer")
public class FamerController {
	@Autowired
	private FamerRepository famerRepository;

	@GetMapping()
	public List<Famer> findAll() {
		return (List<Famer>) famerRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Famer> findById(@PathVariable(value = "id") long id) {
		Optional<Famer> famer = famerRepository.findById(id);
		if (famer.isPresent()) {
			return ResponseEntity.ok().body(famer.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping()
	public ResponseEntity<Famer> save(@Validated @RequestBody Famer famer) {
		return new ResponseEntity<>(famerRepository.save(famer), HttpStatus.CREATED);
	}

	@DeleteMapping()
	public ResponseEntity<Famer> update(@Validated @RequestBody Famer famer) {
		return new ResponseEntity<>(famerRepository.save(famer), HttpStatus.CREATED);
	}

	@PutMapping()
	public void delete(@Validated @RequestBody Famer famer) {
		famerRepository.deleteById(famer.getId());
	}

}
