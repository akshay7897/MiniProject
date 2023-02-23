package in.ap.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import in.ap.entity.Plan;

@Service
public interface PlanService {
	
	
	public Map<Integer, String> getPlan_Categories();
	
	public List<Plan> getAllPlans();
	
	public boolean savePlan(Plan plan);
	
	public Plan getPlanById(Integer id);
	
	public boolean updatePlan(Plan plan);
	
	public boolean deletePlanById(Integer id);
	
	public boolean active_status(Integer id,String status);

}
