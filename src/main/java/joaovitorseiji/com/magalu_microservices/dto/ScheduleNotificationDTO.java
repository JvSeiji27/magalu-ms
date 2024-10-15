package joaovitorseiji.com.magalu_microservices.dto;

import java.time.LocalDateTime;

import joaovitorseiji.com.magalu_microservices.entity.Channel;
import joaovitorseiji.com.magalu_microservices.entity.Notification;
import joaovitorseiji.com.magalu_microservices.entity.Status;

public record ScheduleNotificationDTO(LocalDateTime dateTime,
		String destination,
		String message,
		Channel.Values channel
		) {
	
	public Notification toNotification() {
		return new Notification(dateTime, destination, message, channel.toChannel(), Status.Values.PENDING.toStatus());
	}
}
