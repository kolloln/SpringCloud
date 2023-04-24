package ProductQueryService.service;

import ProductQueryService.domain.Product;
import ProductQueryService.dto.ProductDTO;

public class ProductAdapter {
    public static Product fromDTO(ProductDTO dto){
        return new Product(dto.getProductNumber(), dto.getName(), dto.getPrice(), dto.getNumberInStock());
    }

    public static ProductDTO toDTO(Product product){
        return new ProductDTO(product.getProductNumber(), product.getName(), product.getPrice(), product.getNumberInStock());
    }
}
