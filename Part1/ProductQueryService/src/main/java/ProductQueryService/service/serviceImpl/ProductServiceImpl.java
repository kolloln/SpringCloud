package ProductQueryService.service.serviceImpl;

import ProductQueryService.domain.Product;
import ProductQueryService.dto.ProductChangeEventDTO;
import ProductQueryService.dto.ProductDTO;
import ProductQueryService.dto.StockChangeEventDTO;
import ProductQueryService.repository.ProductRepository;
import ProductQueryService.service.ProductAdapter;
import ProductQueryService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public void add(ProductDTO productDTO){
        Product product = ProductAdapter.fromDTO(productDTO);
        productRepository.save(product);
    }

    @Override
    public void delete(String productNumber){
        productRepository.deleteById(productNumber);
    }

    @Override
    public void update(String productNumber, ProductDTO productDTO){
        Optional<Product> oldProduct = productRepository.findProductByProductNumber(productNumber);
        if (oldProduct.isPresent()){
            Product updatedProduct = ProductAdapter.fromDTO(productDTO);
            productRepository.save(updatedProduct);
        }
    }

    @Override
    public ProductDTO get(String productNumber){
        Optional<Product> optionalProduct = productRepository.findById(productNumber);
        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            return ProductAdapter.toDTO(product);
        }
        return null;
    }

    @Override
    public void handle(ProductChangeEventDTO productChangeEventDTO){
        switch (productChangeEventDTO.getChange()) {
            case "add":
                add(productChangeEventDTO.getProduct());
                break;
            case "delete":
                delete(productChangeEventDTO.getProduct().getProductNumber());
                break;
            case "update":
                int quantity = 0;
                Optional<Product> optionalProduct = productRepository.findById(productChangeEventDTO.getProduct().getProductNumber());
                if (optionalProduct.isPresent()) {
                    Product product = optionalProduct.get();
                    quantity = product.getNumberInStock();
                }

                update(productChangeEventDTO.getProduct().getProductNumber(),
                        new ProductDTO(productChangeEventDTO.getProduct().getProductNumber(),
                                productChangeEventDTO.getProduct().getName(),
                                productChangeEventDTO.getProduct().getPrice(),
                                quantity));
                break;
        }
    }

    @Override
    public void handle(StockChangeEventDTO stockChangeEventDTO) {
        Optional<Product> optionalProduct = productRepository.findById(stockChangeEventDTO.getProductNumber());
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setNumberInStock(stockChangeEventDTO.getQuantity());
            productRepository.save(product);
        }
    }
}
