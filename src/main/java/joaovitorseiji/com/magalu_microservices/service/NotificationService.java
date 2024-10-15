package joaovitorseiji.com.magalu_microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import joaovitorseiji.com.magalu_microservices.dto.ScheduleNotificationDTO;
import joaovitorseiji.com.magalu_microservices.repository.NotificationRepository;

@Service
public class NotificationService {
	@Autowired
	private NotificationRepository repository;
	
	public void scheduleNotification(ScheduleNotificationDTO dto) {
		repository.save(dto.toNotification());
	}
}
