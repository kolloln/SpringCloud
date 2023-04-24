package ProductCommandService.service;

import ProductCommandService.dto.ProductDTO;

public interface ProductService {
    void add(ProductDTO productDTO);
    void delete(String productNumber);
    void update(String productNumber,ProductDTO productDTO);
}
