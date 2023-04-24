package ProductQueryService.eventlistener;

import ProductQueryService.dto.ProductChangeEventDTO;
import ProductQueryService.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ProductChangeEventListener {
    @Autowired
    ProductService productService;

    @JmsListener(destination = "productChangeEventQueue")
    public void receiveMessage(final String productChangeEventMessage){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            ProductChangeEventDTO productChangeEventDTO = objectMapper.readValue(productChangeEventMessage,
                    ProductChangeEventDTO.class);
            productService.handle(productChangeEventDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
