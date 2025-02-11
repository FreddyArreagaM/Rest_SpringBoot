package api.fnam.apiProducto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiProductoApplication {

	private final static Logger logger = LoggerFactory.getLogger(ApiProductoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ApiProductoApplication.class, args);
		logger.info("API Producto iniciada...");
	}

}
