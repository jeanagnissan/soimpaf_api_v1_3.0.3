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

import africa.soimpaf.api_v1_303.models.Order;
import africa.soimpaf.api_v1_303.repository.OrderRepository;

/**
 * @author digitalci
 *
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {
	

	@Autowired
	private OrderRepository orderRepository;

	@GetMapping()
	public List<Order> findAll() {
		return (List<Order>) orderRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Order> findById(@PathVariable(value = "id") long id) {
		Optional<Order> order = orderRepository.findById(id);
		if (order.isPresent()) {
			return ResponseEntity.ok().body(order.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping()
	public ResponseEntity<Order> save(@Validated @RequestBody Order order) {
		return new ResponseEntity<>(orderRepository.save(order), HttpStatus.CREATED);
	}

	@DeleteMapping()
	public ResponseEntity<Order> update(@Validated @RequestBody Order order) {
		return new ResponseEntity<>(orderRepository.save(order), HttpStatus.CREATED);
	}

	@PutMapping()
	public void delete(@Validated @RequestBody Order order) {
		orderRepository.deleteById(order.getId());
	}


}
