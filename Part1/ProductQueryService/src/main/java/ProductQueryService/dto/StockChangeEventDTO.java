package ProductQueryService.dto;

public class StockChangeEventDTO {
    private String productNumber;
    private int quantity;

    public StockChangeEventDTO() {
    }

    public StockChangeEventDTO(String productNumber, int quantity) {
        this.productNumber = productNumber;
        this.quantity = quantity;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public int getQuantity() {
        return quantity;
    }
}
