package ProductCommandService.service;

import ProductCommandService.domain.Product;
import ProductCommandService.dto.ProductDTO;

public class ProductAdapter {
    public static Product fromDTO(ProductDTO dto){
        return new Product(dto.getProductNumber(), dto.getName(), dto.getPrice());
    }

    public static ProductDTO toDTO(Product product){
        return new ProductDTO(product.getProductNumber(), product.getName(), product.getPrice());
    }
}
