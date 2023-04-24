package ProductQueryService.dto;

public class ProductDTO {
    private String productNumber;
    private String name;
    private double price;
    private int numberInStock;

    public ProductDTO(){}

    public ProductDTO(String productNumber, String name, double price, int numberInStock) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
        this.numberInStock = numberInStock;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getNumberInStock() {
        return numberInStock;
    }

    @Override
    public String toString() {
        return "Product {" +
                "productNumber='" + productNumber + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price + '\'' +
                ", numberInStock=" + numberInStock +
                '}';
    }
}
