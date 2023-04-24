package StockCommandService.controller;

import StockCommandService.dto.StockDTO;
import StockCommandService.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class StockController {
    @Autowired
    private StockService stockService;

    @PostMapping("/stocks")
    public ResponseEntity<?> add(@RequestBody StockDTO stockDTO){
        stockService.add(stockDTO);
        return new ResponseEntity<>(stockDTO, HttpStatus.OK);
    }

    @PutMapping("/stocks/{productNumber}")
    public ResponseEntity<?> update(@PathVariable String productNumber, @RequestBody StockDTO stockDTO){
        stockService.update(productNumber, stockDTO);
        return new ResponseEntity<>(stockDTO, HttpStatus.OK);
    }

    @DeleteMapping("/stocks/{productNumber}")
    public ResponseEntity<?> delete(@PathVariable String productNumber){
        stockService.delete(productNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
