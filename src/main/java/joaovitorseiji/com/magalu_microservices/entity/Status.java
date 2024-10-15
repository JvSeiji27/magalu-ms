package joaovitorseiji.com.magalu_microservices.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_status")
public class Status {
	
	private Long statusId;
	
	private String description;
}
