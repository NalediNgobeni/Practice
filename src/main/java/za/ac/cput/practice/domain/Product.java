package za.ac.cput.practice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    private String productId;
    private String productName;
    private double price;
    private int stockQuantity;

    private Product(Builder builder){
        this.productId=builder.productId;
        this.productName=builder.productName;
        this.price=builder.price;
        this.stockQuantity=builder.stockQuantity;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
    public static class Builder{
        private String productId;
        private String productName;
        private double price;
        private int stockQuantity;

        public Builder setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder setStockQuantity(int stockQuantity) {
            this.stockQuantity = stockQuantity;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }
        public Product build() {
            if (productId == null){
                throw new IllegalStateException("Product must have an ID");
        }
            return new Product(this);

        }
    }
}
