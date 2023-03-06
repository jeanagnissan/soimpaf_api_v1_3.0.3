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

import africa.soimpaf.api_v1_303.models.Product;
import africa.soimpaf.api_v1_303.repository.ProductRepository;

/**
 * @author digitalci
 *
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	@GetMapping()
	public List<Product> findAll() {
		return (List<Product>) productRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable(value = "id") long id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			return ResponseEntity.ok().body(product.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping()
	public ResponseEntity<Product> save(@Validated @RequestBody Product product) {
		return new ResponseEntity<>(productRepository.save(product), HttpStatus.CREATED);
	}

	@DeleteMapping()
	public ResponseEntity<Product> update(@Validated @RequestBody Product product) {
		return new ResponseEntity<>(productRepository.save(product), HttpStatus.CREATED);
	}

	@PutMapping()
	public void delete(@Validated @RequestBody Product product) {
		productRepository.deleteById(product.getId());
	}
	

}
