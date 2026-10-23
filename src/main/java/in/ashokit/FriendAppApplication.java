package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class FriendAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FriendAppApplication.class, args);
	}

}
