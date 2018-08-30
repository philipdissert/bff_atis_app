package edu.kit.cm.BffAtisApp.Workspace.Infrastructure;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController("/opening-hours")
public class OpeningHourController {

	private RestTemplate restTemplate = new RestTemplate();
	private String url = "https://workspace.cm.tm.kit.edu/opening-hours";

	@GetMapping
	public ResponseEntity<String> get() {
		return restTemplate.getForEntity(url, String.class);
	}

	@PutMapping
	public void put(@RequestBody String input) {
		restTemplate.put(url,input);
	}

	@DeleteMapping
	public void delete() {
		restTemplate.delete(url);
	}

}
