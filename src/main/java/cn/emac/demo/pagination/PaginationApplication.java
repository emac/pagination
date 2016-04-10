package cn.emac.demo.pagination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("cn.emac")
public class PaginationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaginationApplication.class, args);
    }
}
