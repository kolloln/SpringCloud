package ProductQueryService.service;

import ProductQueryService.dto.ProductChangeEventDTO;
import ProductQueryService.dto.ProductDTO;
import ProductQueryService.dto.StockChangeEventDTO;

public interface ProductService {
    void add(ProductDTO productDTO);
    void delete(String productNumber);
    void update(String productNumber,ProductDTO productDTO);
    ProductDTO get(String productNumber);

    void handle(ProductChangeEventDTO productChangeEventDTO);
    void handle(StockChangeEventDTO stockChangeEventDTO);
}
