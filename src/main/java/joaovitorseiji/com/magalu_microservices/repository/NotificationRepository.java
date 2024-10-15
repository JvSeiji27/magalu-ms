package joaovitorseiji.com.magalu_microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import joaovitorseiji.com.magalu_microservices.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
