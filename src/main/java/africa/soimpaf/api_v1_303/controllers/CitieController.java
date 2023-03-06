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

import africa.soimpaf.api_v1_303.models.Citie;
import africa.soimpaf.api_v1_303.repository.CitieRepository;

/**
 * @author digitalci
 *
 */
@RestController
@RequestMapping("/api/citie")
public class CitieController {
	@Autowired
	private CitieRepository citieRepository;

	@GetMapping()
	public List<Citie> findAll() {
		return (List<Citie>) citieRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Citie> findById(@PathVariable(value = "id") long id) {
		Optional<Citie> citie = citieRepository.findById(id);
		if (citie.isPresent()) {
			return ResponseEntity.ok().body(citie.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping()
	public ResponseEntity<Citie> save(@Validated @RequestBody Citie citie) {
		return new ResponseEntity<>(citieRepository.save(citie), HttpStatus.CREATED);
	}

	@DeleteMapping()
	public ResponseEntity<Citie> update(@Validated @RequestBody Citie citie) {
		return new ResponseEntity<>(citieRepository.save(citie), HttpStatus.CREATED);
	}

	@PutMapping()
	public void delete(@Validated @RequestBody Citie citie) {
		citieRepository.deleteById(citie.getId());
	}


}
