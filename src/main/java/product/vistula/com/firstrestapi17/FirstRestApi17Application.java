package product.vistula.com.firstrestapi17;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Products for Winnie", version ="1.0",description = "Products Information"))
public class FirstRestApi17Application {

    public static void main(String[] args) {
        SpringApplication.run(FirstRestApi17Application.class, args);
    }

}
