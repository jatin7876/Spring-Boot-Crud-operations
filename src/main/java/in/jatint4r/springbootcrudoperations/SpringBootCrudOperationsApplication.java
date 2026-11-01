package in.jatint4r.springbootcrudoperations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringBootCrudOperationsApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootCrudOperationsApplication.class, args);
    }

}
