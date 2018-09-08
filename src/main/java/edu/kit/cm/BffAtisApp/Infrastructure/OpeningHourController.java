package edu.kit.cm.BffAtisApp.Infrastructure;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
public class OpeningHourController {

	private RestTemplate restTemplate = new RestTemplate();
	private String url = "https://workspace.cm.tm.kit.edu/opening-hours";

	@GetMapping("/opening-hours")
	public ResponseEntity<String> get() {
		return restTemplate.getForEntity(url, String.class);
	}

	@PutMapping("/opening-hours")
	public void put(@RequestBody String input) {
		restTemplate.put(url,input);
	}

	@DeleteMapping("/opening-hours")
	public void delete() {
		restTemplate.delete(url);
	}

}
