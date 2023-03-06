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

import africa.soimpaf.api_v1_303.models.OrderHistory;
import africa.soimpaf.api_v1_303.repository.OrderHistoryRepository;

/**
 * @author digitalci
 *
 */
@RestController
@RequestMapping("/api/orderHistory")
public class OrderHistoryController {

	@Autowired
	private OrderHistoryRepository orderHistoryRepository;

	@GetMapping()
	public List<OrderHistory> findAll() {
		return (List<OrderHistory>) orderHistoryRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrderHistory> findById(@PathVariable(value = "id") long id) {
		Optional<OrderHistory> orderHistory = orderHistoryRepository.findById(id);
		if (orderHistory.isPresent()) {
			return ResponseEntity.ok().body(orderHistory.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping()
	public ResponseEntity<OrderHistory> save(@Validated @RequestBody OrderHistory orderHistory) {
		return new ResponseEntity<>(orderHistoryRepository.save(orderHistory), HttpStatus.CREATED);
	}

	@DeleteMapping()
	public ResponseEntity<OrderHistory> update(@Validated @RequestBody OrderHistory orderHistory) {
		return new ResponseEntity<>(orderHistoryRepository.save(orderHistory), HttpStatus.CREATED);
	}

	@PutMapping()
	public void delete(@Validated @RequestBody OrderHistory orderHistory) {
		orderHistoryRepository.deleteById(orderHistory.getId());
	}


}
