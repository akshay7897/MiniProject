package in.ap.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ap.entity.Category_Plan;
import in.ap.entity.Plan;
import in.ap.repo.Category_Plan_Repo;
import in.ap.repo.PlanRepo;
import in.ap.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService {
	
	Logger logger=LoggerFactory.getLogger(PlanServiceImpl.class);

	@Autowired
	private PlanRepo planRepo;

	@Autowired
	private Category_Plan_Repo category_Plan_Repo;

	@Override
	public Map<Integer, String> getPlan_Categories() {
		
		logger.info("getplan_categories Method of service impl is excuting...");

		List<Category_Plan> categories = category_Plan_Repo.findAll();
		Map<Integer, String> cat = new HashMap<>();
		categories.forEach(category -> {
			cat.put(category.getCategoryId(), category.getCategoryName());
		});
		logger.info("getplan_categories Method of service impl excution done...");
		return cat;

	}

	@Override
	public List<Plan> getAllPlans() {
		return planRepo.findAll();
	}

	@Override
	public boolean savePlan(Plan plan) {

		Plan savePlan = planRepo.save(plan);

		return savePlan.getPlanId() != null;

	}

	@Override
	public Plan getPlanById(Integer id) {

		Optional<Plan> plan = planRepo.findById(id);
		if (plan.isPresent()) {
			return plan.get();
		} else {
			return null;
		}
	}

	@Override
	public boolean updatePlan(Plan plan) {
		
		Plan planSave = planRepo.save(plan);
			
		return planSave.getPlanId()!=null;
	}

	@Override
	public boolean deletePlanById(Integer id) {

		boolean status = false;

		try {
			planRepo.deleteById(id);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public boolean active_status(Integer id, String status) {

		Optional<Plan> plan = planRepo.findById(id);
		if (plan.isPresent()) {
			Plan plan2 = plan.get();
			plan2.setActive_sw(status);
			planRepo.save(plan2);
			return true;
		} else {
			return false;
		}
	}

}
