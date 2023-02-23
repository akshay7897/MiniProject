package in.ap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import in.ap.service.PlanService;

@RestController
public class PlanController {
	
	@Autowired
	private PlanService planService;
	

}
