package StockCommandService.dto;

public class StockDTO {
    private String productNumber;
    private int quantity;

    public StockDTO(){}

    public StockDTO(String productNumber, int quantity) {
        this.productNumber = productNumber;
        this.quantity = quantity;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Stock {" +
                "productNumber='" + productNumber + '\'' +
                ", quantity='" + quantity +
                '}';
    }
}
