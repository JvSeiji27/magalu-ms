package joaovitorseiji.com.magalu_microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import joaovitorseiji.com.magalu_microservices.dto.ScheduleNotificationDTO;
import joaovitorseiji.com.magalu_microservices.entity.Notification;
import joaovitorseiji.com.magalu_microservices.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
	
	@Autowired
	private NotificationService service;
	
	@PostMapping
	public ResponseEntity<Void> scheduleNotification(@RequestBody ScheduleNotificationDTO dto){
		service.scheduleNotification(dto);
		
		return ResponseEntity.accepted().build();
	}
	
	@GetMapping("/{notificationId}")
	public ResponseEntity<Notification> getNotification(@PathVariable ("notificationId") Long notificationId){
		var notification = service.findById(notificationId);
		
		if(notification.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(notification.get());
	}
}
