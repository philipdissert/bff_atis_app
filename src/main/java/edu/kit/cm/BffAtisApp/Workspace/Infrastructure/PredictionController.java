package edu.kit.cm.BffAtisApp.Workspace.Infrastructure;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController("/prediction")
public class PredictionController {

	private RestTemplate restTemplate = new RestTemplate();
	private String url = "https://utilization.cm.tm.kit.edu/prediction";

	@GetMapping("/{day}")
	public ResponseEntity<IntegerArray> getPredictionAtWeekday(@PathVariable("day") String date) {
		if(date.contains("?algo=fast")) {
			return restTemplate.getForEntity(url+"/day/"+date.substring(0,date.indexOf("?")),IntegerArray.class);
		} else {
			return restTemplate.getForEntity(url+"/date/"+date,IntegerArray.class);
		}
	}
}
