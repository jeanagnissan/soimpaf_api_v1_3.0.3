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

import africa.soimpaf.api_v1_303.models.TypeCrop;
import africa.soimpaf.api_v1_303.repository.TypeCropRepository;

/**
 * @author digitalci
 *
 */
@RestController
@RequestMapping("/api/typeCrop")
public class TypeCropController {
	@Autowired
	private TypeCropRepository typeCropRepository;

	@GetMapping()
	public List<TypeCrop> findAll() {
		return (List<TypeCrop>) typeCropRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<TypeCrop> findById(@PathVariable(value = "id") long id) {
		Optional<TypeCrop> typeCrop = typeCropRepository.findById(id);
		if (typeCrop.isPresent()) {
			return ResponseEntity.ok().body(typeCrop.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping()
	public ResponseEntity<TypeCrop> save(@Validated @RequestBody TypeCrop typeCrop) {
		return new ResponseEntity<>(typeCropRepository.save(typeCrop), HttpStatus.CREATED);
	}

	@DeleteMapping()
	public ResponseEntity<TypeCrop> update(@Validated @RequestBody TypeCrop typeCrop) {
		return new ResponseEntity<>(typeCropRepository.save(typeCrop), HttpStatus.CREATED);
	}

	@PutMapping()
	public void delete(@Validated @RequestBody TypeCrop typeCrop) {
		typeCropRepository.deleteById(typeCrop.getId());
	}

}
