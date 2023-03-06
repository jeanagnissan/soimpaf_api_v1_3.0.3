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

import africa.soimpaf.api_v1_303.models.Rating;
import africa.soimpaf.api_v1_303.repository.RatingRepository;

/**
 * @author digitalci
 *
 */
@RestController
@RequestMapping("/api/rating")
public class RatingController {
	
	@Autowired
	private RatingRepository ratingRepository;

	@GetMapping()
	public List<Rating> findAll() {
		return (List<Rating>) ratingRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Rating> findById(@PathVariable(value = "id") long id) {
		Optional<Rating> rating = ratingRepository.findById(id);
		if (rating.isPresent()) {
			return ResponseEntity.ok().body(rating.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping()
	public ResponseEntity<Rating> save(@Validated @RequestBody Rating rating) {
		return new ResponseEntity<>(ratingRepository.save(rating), HttpStatus.CREATED);
	}

	@DeleteMapping()
	public ResponseEntity<Rating> update(@Validated @RequestBody Rating rating) {
		return new ResponseEntity<>(ratingRepository.save(rating), HttpStatus.CREATED);
	}

	@PutMapping()
	public void delete(@Validated @RequestBody Rating rating) {
		ratingRepository.deleteById(rating.getId());
	}

}
