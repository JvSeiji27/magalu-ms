package joaovitorseiji.com.magalu_microservices.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import joaovitorseiji.com.magalu_microservices.entity.Channel;
import joaovitorseiji.com.magalu_microservices.entity.Status;
import joaovitorseiji.com.magalu_microservices.repository.ChannelRepository;
import joaovitorseiji.com.magalu_microservices.repository.StatusRepository;

@Configuration
public class DataLoader implements CommandLineRunner{
//Assim que o nosso projeto subir, ele executará esse método
	
	@Autowired
	private  StatusRepository sr;
	@Autowired
	private ChannelRepository cr;
	
	
	@Override
	public void run(String... args) throws Exception {
		Arrays.stream(Channel.Values.values())
		.map(Channel.Values::toChannel)
		.forEach(cr::save); //retorna todos os valores do enum;
		
		Arrays.stream(Status.Values.values())
		.map(Status.Values::toStatus)
		.forEach(sr::save);
	}

}
