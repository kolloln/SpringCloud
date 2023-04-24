package ServiceBApplication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ServiceBController {

    @Value("${greeting}")
    private String message;

    @RequestMapping("/")
    public String getName() {
        return message;
    }
}
