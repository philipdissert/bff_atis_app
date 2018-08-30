package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class LayoutAPIController {

	@GetMapping("/test")
	public String getTest() {
		return "test";
	}


	@GetMapping("/SecureTest")
	public String secureTest() {
		return "Correct";
	}
}
