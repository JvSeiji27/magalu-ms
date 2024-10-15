package joaovitorseiji.com.magalu_microservices.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import joaovitorseiji.com.magalu_microservices.dto.ScheduleNotificationDTO;
import joaovitorseiji.com.magalu_microservices.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
	
	private NotificationService service;
	
	@PostMapping
	public ResponseEntity<Void> scheduleNotification(@RequestBody ScheduleNotificationDTO dto){
		service.scheduleNotification(dto);
		
		return ResponseEntity.accepted().build();
	}
}
