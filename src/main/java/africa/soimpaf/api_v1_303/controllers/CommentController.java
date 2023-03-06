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

import africa.soimpaf.api_v1_303.models.Comment;
import africa.soimpaf.api_v1_303.repository.CommentRepository;

/**
 * @author digitalci
 *
 */
@RestController
@RequestMapping("/api/comment")
public class CommentController {
	@Autowired
	private CommentRepository commentRepository;

	@GetMapping()
	public List<Comment> findAll() {
		return (List<Comment>) commentRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Comment> findById(@PathVariable(value = "id") long id) {
		Optional<Comment> comment = commentRepository.findById(id);
		if (comment.isPresent()) {
			return ResponseEntity.ok().body(comment.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping()
	public ResponseEntity<Comment> save(@Validated @RequestBody Comment comment) {
		return new ResponseEntity<>(commentRepository.save(comment), HttpStatus.CREATED);
	}

	@DeleteMapping()
	public ResponseEntity<Comment> update(@Validated @RequestBody Comment comment) {
		return new ResponseEntity<>(commentRepository.save(comment), HttpStatus.CREATED);
	}

	@PutMapping()
	public void delete(@Validated @RequestBody Comment comment) {
		commentRepository.deleteById(comment.getId());
	}


}
