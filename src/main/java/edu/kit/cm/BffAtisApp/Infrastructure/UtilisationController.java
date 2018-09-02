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

	@PutMapping("/update")
	public void update() {
		utilisationAdapter.update();
	}

	@GetMapping("/utilisation/workspaceState")
	public ResponseEntity<String> getCurrentState() {
		return restTemplate.getForEntity(url+"/currentState",String.class);
	}

	@GetMapping("/utilisation/current")
	public ResponseEntity<String> getCurrentUtilization() {
		System.out.println("Test2");
		return restTemplate.getForEntity(url+"/currentUtilization",String.class);
	}

	@GetMapping("/utilisation/current/free")
	public ResponseEntity<Integer> getCurrentUtilizationFreeWorksaces() {
		return restTemplate.getForEntity(url+"/currentUtilization/free",Integer.class);
	}

	@GetMapping("/utilisation/current/occupied")
	public ResponseEntity<Integer> getCurrentUtilizationOccupiedWorksaces() {
		return restTemplate.getForEntity(url+"/currentUtilization/occupied",Integer.class);
	}

	@GetMapping("/utilisation/current/percentageFree")
	public ResponseEntity<Double> getCurrentUtilizationFreePercentage() {
		return restTemplate.getForEntity(url+"/currentUtilization/percentageFree",Double.class);
	}

	@GetMapping("/utilisation/current/percentageOccupied")
	public ResponseEntity<Double> getCurrentUtilizationOccupiedPercentage() {
		return restTemplate.getForEntity(url+"/currentUtilization/percentageOccupied",Double.class);
	}
}
