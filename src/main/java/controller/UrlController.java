package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import exceptions.ResourceNotFoundException;
import model.Url;
import service.UrlService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class UrlController {

	@Autowired
	private UrlService urlService;

	@RequestMapping("/")
	public @ResponseBody String greeting() {
		System.out.println("aHH!!!");
		return "Hello World";
	}

	@GetMapping("/urls")
	public List<Url> getAllUrls() {
		System.out.println("bateu aqui");
		return urlService.findAll();
	}

	@GetMapping("/urls/{id}")
	public ResponseEntity<Url> getUrlById(@PathVariable(value = "id") Long urlId) throws ResourceNotFoundException {
		Url url = urlService.findById(urlId)
				.orElseThrow(() -> new ResourceNotFoundException("Url not found for this id :: " + urlId));
		return ResponseEntity.ok().body(url);
	}

	@PostMapping("/urls")
	public Url createUrl(@Valid @RequestBody Url url) {

		return urlService.save(url);
	}

	@PutMapping("/urls/{id}")
	public ResponseEntity<Url> updateUrl(@PathVariable(value = "id") Long urlId, @Valid @RequestBody Url urlDetails)
			throws ResourceNotFoundException {
		Url url = urlService.findById(urlId)
				.orElseThrow(() -> new ResourceNotFoundException("Url not found for this id :: " + urlId));

		url.setAlias(urlDetails.getAlias());
		url.setUrl(urlDetails.getUrl());
		final Url updatedUrl = urlService.save(url);
		return ResponseEntity.ok(updatedUrl);
	}

	@DeleteMapping("/urls/{id}")
	public Map<String, Boolean> deleteUrl(@PathVariable(value = "id") Long urlId) throws ResourceNotFoundException {
		Url url = urlService.findById(urlId)
				.orElseThrow(() -> new ResourceNotFoundException("Url not found for this id :: " + urlId));

		urlService.delete(url);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
