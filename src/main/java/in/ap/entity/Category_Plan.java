package in.ap.entity;

import java.time.LocalDate;

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
public class Category_Plan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CATEGORY_ID")
	private Integer categoryId;
	
	@Column(name = "CATEGORY_NAME")
	private String categoryName;
	
	@Column(name = "ACTIVE_SW")
	private String active_SW;
	
	@Column(name = "CREATED_DATE" ,updatable = false)
	@CreationTimestamp
	private LocalDate created_date;
	
	@Column(name = "UPDATED_DATE",insertable = false)
	@UpdateTimestamp
	private LocalDate update_date;
	
	@Column(name = "CREATED_BY")
	private String created_By;
	
	@Column(name = "UPDATED_BY")
	private String updated_By;
	
	

}
