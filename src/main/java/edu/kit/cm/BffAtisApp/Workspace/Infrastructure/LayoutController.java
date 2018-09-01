package edu.kit.cm.BffAtisApp.Workspace.Infrastructure;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
public class LayoutController {

	private RestTemplate restTemplate = new RestTemplate();
	private String url = "https://workspace.cm.tm.kit.edu";

	@GetMapping("/layouts/layout")
	public ResponseEntity<String> getLayout() {
		return restTemplate.getForEntity(url+"/layout",String.class);
	}

	@GetMapping("/layouts/{id}")
	public ResponseEntity<String> getWorkspaceById(@PathVariable("id") int id) {
		return restTemplate.getForEntity(url+"/layout/id/"+id,String.class);
	}

	@GetMapping("/layouts/")
	public ResponseEntity<String> getLayoutList() {
		return restTemplate.getForEntity(url+"/layout-list",String.class);
	}

	@GetMapping("/layouts/layout/id")
	public ResponseEntity<Integer> getLayoutId() {
		return restTemplate.getForEntity(url+"/get-layout-id",Integer.class);
	}

	@GetMapping("/layouts/layout/poolElements")
	public ResponseEntity<String> getPoolElements() {
		return restTemplate.getForEntity(url+"/layout/poolElements",String.class);
	}

	@GetMapping("/layouts/layout/poolElementsJSONArray")
	public ResponseEntity<String> getPoolElementsJSONArray() {
		return restTemplate.getForEntity(url+"/layout/poolElementsJSONArray",String.class);
	}


	@GetMapping("/layouts/layout/rooms")
	public ResponseEntity<String> getRooms() {
		return restTemplate.getForEntity(url+"/layout/rooms",String.class);
	}

	@PutMapping("/layouts/{id}")
	public ResponseEntity<String> changeLayout(@PathVariable int id){
		return restTemplate.getForEntity(url+"/change-layout/id/"+id,String.class);
	}

	@PostMapping("/layouts/{id}")
	public void addLayout(@RequestBody String input,@PathVariable int id) {
		restTemplate.postForEntity(url+"/add-layout/id/"+id,input,String.class);
	}
}
