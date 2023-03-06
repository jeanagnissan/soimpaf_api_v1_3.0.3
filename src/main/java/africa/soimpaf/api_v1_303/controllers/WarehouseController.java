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

import africa.soimpaf.api_v1_303.models.Warehouse;
import africa.soimpaf.api_v1_303.repository.WarehouseRepository;

/**
 * @author digitalci
 *
 */
@RestController
@RequestMapping("/api/warehouse")
public class WarehouseController {
	
	@Autowired
	private WarehouseRepository warehouseRepository;

	@GetMapping()
	public List<Warehouse> findAll() {
		return (List<Warehouse>) warehouseRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Warehouse> findById(@PathVariable(value = "id") long id) {
		Optional<Warehouse> warehouse = warehouseRepository.findById(id);
		if (warehouse.isPresent()) {
			return ResponseEntity.ok().body(warehouse.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping()
	public ResponseEntity<Warehouse> save(@Validated @RequestBody Warehouse warehouse) {
		return new ResponseEntity<>(warehouseRepository.save(warehouse), HttpStatus.CREATED);
	}

	@DeleteMapping()
	public ResponseEntity<Warehouse> update(@Validated @RequestBody Warehouse warehouse) {
		return new ResponseEntity<>(warehouseRepository.save(warehouse), HttpStatus.CREATED);
	}

	@PutMapping()
	public void delete(@Validated @RequestBody Warehouse warehouse) {
		warehouseRepository.deleteById(warehouse.getId());
	}

}
