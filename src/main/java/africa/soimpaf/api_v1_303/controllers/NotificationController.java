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

import africa.soimpaf.api_v1_303.models.Notification;
import africa.soimpaf.api_v1_303.repository.NotificationRepository;

/**
 * @author digitalci
 *
 */
@RestController
@RequestMapping("/api/notification")
public class NotificationController {
	
	@Autowired
	private NotificationRepository notificationRepository;

	@GetMapping()
	public List<Notification> findAll() {
		return (List<Notification>) notificationRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Notification> findById(@PathVariable(value = "id") long id) {
		Optional<Notification> notification = notificationRepository.findById(id);
		if (notification.isPresent()) {
			return ResponseEntity.ok().body(notification.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping()
	public ResponseEntity<Notification> save(@Validated @RequestBody Notification notification) {
		return new ResponseEntity<>(notificationRepository.save(notification), HttpStatus.CREATED);
	}

	@DeleteMapping()
	public ResponseEntity<Notification> update(@Validated @RequestBody Notification notification) {
		return new ResponseEntity<>(notificationRepository.save(notification), HttpStatus.CREATED);
	}

	@PutMapping()
	public void delete(@Validated @RequestBody Notification notification) {
		notificationRepository.deleteById(notification.getId());
	}

}
