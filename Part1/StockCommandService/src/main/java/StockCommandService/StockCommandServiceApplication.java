package StockCommandService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class StockCommandServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockCommandServiceApplication.class, args);
	}

}
