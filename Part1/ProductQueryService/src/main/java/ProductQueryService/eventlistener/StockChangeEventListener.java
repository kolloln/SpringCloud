package ProductQueryService.eventlistener;

import ProductQueryService.dto.StockChangeEventDTO;
import ProductQueryService.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class StockChangeEventListener {
    @Autowired
    ProductService productService;

    @JmsListener(destination = "stockChangeEventQueue")
    public void receiveMessage(final String stockChangeEventMessage){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            StockChangeEventDTO stockChangeEventDTO = objectMapper.readValue(stockChangeEventMessage,
                    StockChangeEventDTO.class);
            productService.handle(stockChangeEventDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
