package edu.kit.cm.BffAtisApp.Workspace.Infrastructure;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController("/utilisation")
public class UtilisationController {

	private RestTemplate restTemplate = new RestTemplate();
	private String url = "https://utilization.cm.tm.kit.edu";

	@GetMapping("/workspaceState")
	public ResponseEntity<String> getCurrentState() {
		return restTemplate.getForEntity(url+"/currentState",String.class);
	}

	@GetMapping("/current")
	public ResponseEntity<String> getCurrentUtilization() {
		return restTemplate.getForEntity(url+"/currentUtilization",String.class);
	}

	@GetMapping("/current/free")
	public ResponseEntity<Integer> getCurrentUtilizationFreeWorksaces() {
		return restTemplate.getForEntity(url+"/currentUtilization/free",Integer.class);
	}

	@GetMapping("/current/occupied")
	public ResponseEntity<Integer> getCurrentUtilizationOccupiedWorksaces() {
		return restTemplate.getForEntity(url+"/currentUtilization/occupied",Integer.class);
	}

	@GetMapping("/current/percentageFree")
	public ResponseEntity<Double> getCurrentUtilizationFreePercentage() {
		return restTemplate.getForEntity(url+"/currentUtilization/percentageFree",Double.class);
	}

	@GetMapping("/current/percentageOccupied")
	public ResponseEntity<Double> getCurrentUtilizationOccupiedPercentage() {
		return restTemplate.getForEntity(url+"/currentUtilization/percentageOccupied",Double.class);
	}
}
