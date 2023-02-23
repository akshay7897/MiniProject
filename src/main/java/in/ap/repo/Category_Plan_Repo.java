package in.ap.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ap.entity.Category_Plan;

@Repository
public interface Category_Plan_Repo extends JpaRepository<Category_Plan, Integer> {

}
