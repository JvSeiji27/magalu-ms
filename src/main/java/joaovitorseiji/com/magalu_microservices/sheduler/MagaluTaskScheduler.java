package joaovitorseiji.com.magalu_microservices.sheduler;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import joaovitorseiji.com.magalu_microservices.service.NotificationService;

@Component
public class MagaluTaskScheduler {
	
	private final Logger logger = LoggerFactory.getLogger(MagaluTaskScheduler.class);
	
	@Autowired
	private NotificationService service;
	
	@Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
	public void checkTasks() {
		
		var dateTime = LocalDateTime.now();
		logger.info("Running at {}", dateTime);
		service.checkAndSend(dateTime);
	}
}
