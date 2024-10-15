package joaovitorseiji.com.magalu_microservices.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import joaovitorseiji.com.magalu_microservices.entity.Notification;
import joaovitorseiji.com.magalu_microservices.entity.Status;

public interface NotificationRepository extends JpaRepository<Notification, Long>{
	List<Notification> findByStatusInAndDateTimeBefore(List<Status> status, LocalDateTime dateTime);
}
