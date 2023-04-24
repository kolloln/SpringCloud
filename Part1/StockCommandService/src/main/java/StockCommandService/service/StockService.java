package StockCommandService.service;

import StockCommandService.dto.StockDTO;

public interface StockService {
    void add(StockDTO stockDTO);
    void delete(String productNumber);
    void update(String productNumber, StockDTO stockDTO);
}
