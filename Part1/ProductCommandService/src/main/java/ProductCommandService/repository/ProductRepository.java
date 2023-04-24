package ProductCommandService.repository;

import ProductCommandService.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductRepository extends MongoRepository<Product,String> {
    Optional<Product> findProductByProductNumber(String productNumber);
}
