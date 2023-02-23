package in.ap.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
public class Plan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer planId;
	@Column(name="PLAN_NAME")
	private String planName;
	
	@Column(name="PLAN_START_DATE")
	private Date plan_Start_Date;
	
	@Column(name="PLAN_END_DATE")
	private Date plan_End_Date;
	
	@Column(name="ACTIVE_SW")
	private String active_sw;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@CreationTimestamp()
	@Column(name="CREATED_DATE",updatable = false)
	private LocalDate createdDate;
	
	@Column(name="UPDATED_DATE",insertable = false)
	@UpdateTimestamp()
	private LocalDate updatedDate;
	
	
	
	

}
