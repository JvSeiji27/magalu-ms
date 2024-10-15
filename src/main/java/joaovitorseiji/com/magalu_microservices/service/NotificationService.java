package joaovitorseiji.com.magalu_microservices.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import joaovitorseiji.com.magalu_microservices.dto.ScheduleNotificationDTO;
import joaovitorseiji.com.magalu_microservices.entity.Notification;
import joaovitorseiji.com.magalu_microservices.entity.Status;
import joaovitorseiji.com.magalu_microservices.repository.NotificationRepository;

@Service
public class NotificationService {
	@Autowired
	private NotificationRepository repository;
	
	public void scheduleNotification(ScheduleNotificationDTO dto) {
		repository.save(dto.toNotification());
	}
	
	public Optional<Notification> findById(Long notificationId){
		return repository.findById(notificationId);
	}

	public void cancelNotification(Long notificationId) {
		var notification = repository.findById(notificationId);
		if(notification.isPresent()) {
			notification.get().setStatus(Status.Values.CANCELED.toStatus());
			repository.save(notification.get());
		}
	
	}
	
	public void checkAndSend(LocalDateTime dateTime) {
		var notifications = repository.findByStatusInAndDateTimeBefore(List.of(Status.Values.PENDING.toStatus(), Status.Values.ERROR.toStatus()), dateTime);
		notifications.forEach(sendNotification());
			//TODO - Realizar o envio
			
	}
	private  Consumer<Notification> sendNotification(){
		return n-> {
			//TODO realizar o envio da notificação
			n.setStatus(Status.Values.SUCESS.toStatus());
			repository.save(n);
		};
	}
}
