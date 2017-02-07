package nl.bsoft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoComplaintsStatsApplication {

    private final Logger log = LoggerFactory.getLogger(DemoComplaintsStatsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoComplaintsStatsApplication.class, args);
    }
}
