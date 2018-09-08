package edu.kit.cm.BffAtisApp.Infrastructure;

import edu.kit.cm.BffAtisApp.Service.UtilisationAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
public class UtilisationController {

	UtilisationAdapter utilisationAdapter = UtilisationAdapter.getInstance();

	private RestTemplate restTemplate = new RestTemplate();
	private String url = "https://utilization.cm.tm.kit.edu";
	//private String url = "http://localhost:8080";

	@GetMapping("/utilisation/workspaceState")
	public ResponseEntity<String> getCurrentState() {
		return restTemplate.getForEntity(url+"/currentState",String.class);
	}

	@GetMapping("/utilisation")
	public ResponseEntity<String> getCurrentUtilization() {
		return restTemplate.getForEntity(url+"/currentUtilization",String.class);
	}

	@GetMapping("/utilisation/free")
	public ResponseEntity<Integer> getCurrentUtilizationFreeWorksaces() {
		return restTemplate.getForEntity(url+"/currentUtilization/free",Integer.class);
	}

	@GetMapping("/utilisation/occupied")
	public ResponseEntity<Integer> getCurrentUtilizationOccupiedWorksaces() {
		return restTemplate.getForEntity(url+"/currentUtilization/occupied",Integer.class);
	}

	@GetMapping("/utilisation/percentageFree")
	public ResponseEntity<Double> getCurrentUtilizationFreePercentage() {
		return restTemplate.getForEntity(url+"/currentUtilization/percentageFree",Double.class);
	}

	@GetMapping("/utilisation/percentageOccupied")
	public ResponseEntity<Double> getCurrentUtilizationOccupiedPercentage() {
		return restTemplate.getForEntity(url+"/currentUtilization/percentageOccupied",Double.class);
	}
}
