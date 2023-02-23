package in.ap.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ap.entity.Plan;

@Repository
public interface PlanRepo extends JpaRepository<Plan, Integer>{

}
