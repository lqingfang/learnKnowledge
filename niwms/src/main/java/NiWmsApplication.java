import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
public class NiWmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(NiWmsApplication.class, args);
    }
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
