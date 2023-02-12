package tiendq.system.shipper_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ShipperSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShipperSystemApplication.class, args);
    }

}
