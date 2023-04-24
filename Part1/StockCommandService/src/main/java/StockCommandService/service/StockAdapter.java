package StockCommandService.service;

import StockCommandService.domain.Stock;
import StockCommandService.dto.StockDTO;

public class StockAdapter {
    public static Stock fromDTO(StockDTO stockDTO){
        return new Stock(stockDTO.getProductNumber(), stockDTO.getQuantity());
    }

    public static StockDTO toDTO(Stock stock){
        return new StockDTO(stock.getProductNumber(), stock.getQuantity());
    }
}
