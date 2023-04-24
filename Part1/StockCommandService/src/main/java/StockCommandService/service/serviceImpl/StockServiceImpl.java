package StockCommandService.service.serviceImpl;

import StockCommandService.domain.Stock;
import StockCommandService.dto.StockChangeEventDTO;
import StockCommandService.dto.StockDTO;
import StockCommandService.integration.JmsSender;
import StockCommandService.repository.StockRepository;
import StockCommandService.service.StockAdapter;
import StockCommandService.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    StockRepository stockRepository;

    @Autowired
    JmsSender jmsSender;

    @Override
    public void add(StockDTO stockDTO){
        Stock stock = StockAdapter.fromDTO(stockDTO);
        stockRepository.save(stock);
        jmsSender.sendStockChangeEventMessage(new StockChangeEventDTO(stockDTO.getProductNumber(), stockDTO.getQuantity()));
    }

    @Override
    public void delete(String productNumber){
        stockRepository.deleteById(productNumber);
        jmsSender.sendStockChangeEventMessage(new StockChangeEventDTO(productNumber, 0));
    }

    @Override
    public void update(String productNumber, StockDTO stockDTO){
        Optional<Stock> oldProduct = stockRepository.findById(productNumber);
        if (oldProduct.isPresent()){
            Stock updatedProduct = StockAdapter.fromDTO(stockDTO);
            stockRepository.save(updatedProduct);
            jmsSender.sendStockChangeEventMessage(new StockChangeEventDTO(stockDTO.getProductNumber(), stockDTO.getQuantity()));
        }
    }
}
