package com.getarrays.server;

import com.getarrays.server.enumeration.Status;
import com.getarrays.server.model.Server;
import com.getarrays.server.repo.ServerRepo;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEncryptableProperties
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ServerRepo serverRepo){
		return args -> {
			serverRepo.save(new Server(null, "192.168.1.184", "Macbook", "64GB", "Personal Notebook",
					"http://localhost:8080/server/image/server1.png", Status.SERVER_UP));
			serverRepo.save(new Server(null, "192.192.1.10", "Ubuntu Linux", "64GB", "Personal PC",
					"http://localhost:8080/server/image/server3.png", Status.SERVER_DOWN));
			serverRepo.save(new Server(null, "192.192.1.113", "MS 2008", "32GB", "Web Server",
					"http://localhost:8080/server/image/server2.png", Status.SERVER_DOWN));
			serverRepo.save(new Server(null, "192.192.1.11", "AOL", "16GB", "Mail Server",
					"http://localhost:8080/server/image/server4.png", Status.SERVER_UP));

		};
	}

}
