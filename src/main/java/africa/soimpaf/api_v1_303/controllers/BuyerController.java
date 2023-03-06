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

import africa.soimpaf.api_v1_303.models.Buyer;
import africa.soimpaf.api_v1_303.repository.BuyerRepository;

/**
 * @author digitalci
 *
 */
@RestController
@RequestMapping("/api/buyer")
public class BuyerController {
	@Autowired
	private BuyerRepository buyerRepository;

	@GetMapping()
	public List<Buyer> findAll() {
		return (List<Buyer>) buyerRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Buyer> findById(@PathVariable(value = "id") long id) {
		Optional<Buyer> buyer = buyerRepository.findById(id);
		if (buyer.isPresent()) {
			return ResponseEntity.ok().body(buyer.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping()
	public ResponseEntity<Buyer> save(@Validated @RequestBody Buyer buyer) {
		return new ResponseEntity<>(buyerRepository.save(buyer), HttpStatus.CREATED);
	}

	@DeleteMapping()
	public ResponseEntity<Buyer> update(@Validated @RequestBody Buyer buyer) {
		return new ResponseEntity<>(buyerRepository.save(buyer), HttpStatus.CREATED);
	}

	@PutMapping()
	public void delete(@Validated @RequestBody Buyer buyer) {
		buyerRepository.deleteById(buyer.getId());
	}

}
