package in.ap.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.ap.entity.Plan;
import in.ap.service.PlanService;

@RestController
public class PlanController {

	Logger logger = LoggerFactory.getLogger(PlanController.class);

	@Autowired
	private PlanService planService;

	@GetMapping("/getCategory")
	@ResponseStatus(HttpStatus.OK)
	public Map<Integer, String> getCategoryPlans() {

		logger.info("getcetegoryplans method execution started..");
		Map<Integer, String> plan_Categories = planService.getPlan_Categories();
		logger.info("getcetegoryplans method execution ended..");

		return plan_Categories;
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public String savePlan(@RequestBody Plan plan) {

		String msg = "";
		boolean isSave = planService.savePlan(plan);
		if (isSave) {
			msg = "plan created.";

		} else {
			msg = "plan not created";
		}
		return msg;

	}

	@GetMapping("/plans")
	@ResponseStatus(HttpStatus.OK)
	public List<Plan> getAllPlans() {

		return planService.getAllPlans();

	}

	@GetMapping("/plan/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Plan editPlan(@PathVariable Integer id) {

		return planService.getPlanById(id);

	}

	@PutMapping("/update-plan")
	@ResponseStatus(HttpStatus.CREATED)
	public String updatePlan(@RequestBody Plan plan) {
		String msg = "";
		boolean updatePlan = planService.updatePlan(plan);
		if (updatePlan) {
			msg = "plan updated..";
		} else {
			msg = "plan not updated..";

		}
		return msg;
	}

	@DeleteMapping("/delete-plan/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String deletePlan(@PathVariable Integer id) {
		String msg = "";
		boolean deletePlanById = planService.deletePlanById(id);
		if (deletePlanById) {
			msg = "plan deleted";
		} else {
			msg = "plan not deleted..";
		}
		return msg;
	}

	@PutMapping("/status-update/{id}/{status}")
	@ResponseStatus(HttpStatus.OK)
	public String acticeStatus(@PathVariable Integer id, @PathVariable String status) {
		String msg = "";

		boolean active_status = planService.active_status(id, status);
		if (active_status) {
			msg = "status updated..";
		} else {
			msg = "status not updated..";
		}

		return msg;

	}

}
