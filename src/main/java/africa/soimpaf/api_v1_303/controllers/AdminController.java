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

import africa.soimpaf.api_v1_303.models.Admin;
import africa.soimpaf.api_v1_303.repository.AdminRepository;

/**
 * @author digitalci
 *
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	private AdminRepository adminRepository;

	@GetMapping()
	public List<Admin> findAll() {
		return (List<Admin>) adminRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Admin> findById(@PathVariable(value = "id") long id) {
		Optional<Admin> admin = adminRepository.findById(id);
		if (admin.isPresent()) {
			return ResponseEntity.ok().body(admin.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping()
	public ResponseEntity<Admin> save(@Validated @RequestBody Admin admin) {
		return new ResponseEntity<>(adminRepository.save(admin), HttpStatus.CREATED);
	}

	@DeleteMapping()
	public ResponseEntity<Admin> update(@Validated @RequestBody Admin admin) {
		return new ResponseEntity<>(adminRepository.save(admin), HttpStatus.CREATED);
	}

	@PutMapping()
	public void delete(@Validated @RequestBody Admin admin) {
		adminRepository.deleteById(admin.getId());
	}

}
