package az.inci.pos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class PosApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(PosApplication.class, args);
    }
}
