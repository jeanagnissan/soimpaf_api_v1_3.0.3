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

import africa.soimpaf.api_v1_303.models.Country;
import africa.soimpaf.api_v1_303.repository.CountryRepository;

/**
 * @author digitalci
 *
 */
@RestController
@RequestMapping("/api/country")
public class CountryController {
	
	@Autowired
	private CountryRepository countryRepository;

	@GetMapping()
	public List<Country> findAll() {
		return (List<Country>) countryRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Country> findById(@PathVariable(value = "id") long id) {
		Optional<Country> country = countryRepository.findById(id);
		if (country.isPresent()) {
			return ResponseEntity.ok().body(country.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping()
	public ResponseEntity<Country> save(@Validated @RequestBody Country country) {
		return new ResponseEntity<>(countryRepository.save(country), HttpStatus.CREATED);
	}

	@DeleteMapping()
	public ResponseEntity<Country> update(@Validated @RequestBody Country country) {
		return new ResponseEntity<>(countryRepository.save(country), HttpStatus.CREATED);
	}

	@PutMapping()
	public void delete(@Validated @RequestBody Country country) {
		countryRepository.deleteById(country.getId());
	}


}
