package ProductQueryService.controller;

import ProductQueryService.dto.ProductDTO;
import ProductQueryService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products/{productNumber}")
    public ResponseEntity<?> get(@PathVariable String productNumber){
        ProductDTO productDTO = productService.get(productNumber);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }
}
