package ProductCommandService.integration;

import ProductCommandService.service.ProductChangeEventDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsSender {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendProductChangeEventMessage(ProductChangeEventDTO productChangeEventDTO){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String productChangeEventMessage = objectMapper.writeValueAsString(productChangeEventDTO);
            jmsTemplate.convertAndSend("productChangeEventQueue", productChangeEventMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
