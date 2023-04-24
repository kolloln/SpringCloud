package StockCommandService.integration;

import StockCommandService.dto.StockChangeEventDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsSender {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendStockChangeEventMessage(StockChangeEventDTO stockChangeEventDTO){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String stockChangeEventMessage = objectMapper.writeValueAsString(stockChangeEventDTO);
            jmsTemplate.convertAndSend("stockChangeEventQueue", stockChangeEventMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
