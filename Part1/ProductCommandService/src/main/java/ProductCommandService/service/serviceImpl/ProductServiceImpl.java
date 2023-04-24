package ProductCommandService.service.serviceImpl;

import ProductCommandService.domain.Product;
import ProductCommandService.dto.ProductDTO;
import ProductCommandService.integration.JmsSender;
import ProductCommandService.repository.ProductRepository;
import ProductCommandService.service.ProductAdapter;
import ProductCommandService.service.ProductChangeEventDTO;
import ProductCommandService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    JmsSender jmsSender;

    @Override
    public void add(ProductDTO productDTO){
        Product product = ProductAdapter.fromDTO(productDTO);
        productRepository.save(product);
        jmsSender.sendProductChangeEventMessage(new ProductChangeEventDTO("add", productDTO));
    }

    @Override
    public void delete(String productNumber){
        productRepository.deleteById(productNumber);
        jmsSender.sendProductChangeEventMessage(new ProductChangeEventDTO("delete", new ProductDTO(productNumber, "", 0.0)));
    }

    @Override
    public void update(String productNumber, ProductDTO productDTO) {
        Optional<Product> oldProduct = productRepository.findProductByProductNumber(productNumber);
        if (oldProduct.isPresent()) {
            Product updatedProduct = ProductAdapter.fromDTO(productDTO);
            productRepository.save(updatedProduct);
            jmsSender.sendProductChangeEventMessage(new ProductChangeEventDTO("update", productDTO));
        }
    }
}
