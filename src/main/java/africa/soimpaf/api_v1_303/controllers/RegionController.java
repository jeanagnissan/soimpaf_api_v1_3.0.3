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

import africa.soimpaf.api_v1_303.models.Region;
import africa.soimpaf.api_v1_303.repository.RegionRepository;

/**
 * @author digitalci
 *
 */
@RestController
@RequestMapping("/api/region")
public class RegionController {
	
	@Autowired
	private RegionRepository regionRepository;

	@GetMapping()
	public List<Region> findAll() {
		return (List<Region>) regionRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Region> findById(@PathVariable(value = "id") long id) {
		Optional<Region> region = regionRepository.findById(id);
		if (region.isPresent()) {
			return ResponseEntity.ok().body(region.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping()
	public ResponseEntity<Region> save(@Validated @RequestBody Region region) {
		return new ResponseEntity<>(regionRepository.save(region), HttpStatus.CREATED);
	}

	@DeleteMapping()
	public ResponseEntity<Region> update(@Validated @RequestBody Region region) {
		return new ResponseEntity<>(regionRepository.save(region), HttpStatus.CREATED);
	}

	@PutMapping()
	public void delete(@Validated @RequestBody Region region) {
		regionRepository.deleteById(region.getId());
	}
}
