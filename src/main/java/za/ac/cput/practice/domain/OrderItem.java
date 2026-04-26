package za.ac.cput.practice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {
    @Id
    private String orderItemId;
    private int quantity;
    private double subTotal;
    @ManyToOne
    private Product product;

    @ManyToOne
    private Order order;


    private OrderItem(Builder builder){
        this.orderItemId=builder.orderItemId;
        this.quantity=builder.quantity;
        this.subTotal=builder.subTotal;
        this.product=builder.product;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public int getquantity() {
        return quantity;
    }

    public double getSubTotal() {
        //now that we are intoducing repositories we calculate
        return product.getPrice() * quantity;

    }

    public Product getProduct() {
        return product;
    }

    public static class Builder{

        private String orderItemId;
        private int quantity;
        private double subTotal;
        private Product product;

        public Builder setOrderItemId(String orderItemId) {
            this.orderItemId = orderItemId;
            return this;
        }

        public Builder setquantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setSubTotal(double subTotal) {
            this.subTotal = subTotal;
            return this;
        }

        public Builder setProduct(Product product) {
            this.product = product;
            return this;
        }

        public OrderItem build(){
            return new OrderItem(this);
        }
    }
}
