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



    private OrderItem(Builder builder){
        this.orderItemId=builder.orderItemId;
        this.quantity=builder.quantity;
        this.subTotal=builder.subTotal;

    }

    public OrderItem() {

    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubTotal() {
      return subTotal;

    }

    public static class Builder{

        private String orderItemId;
        private int quantity;
        private double subTotal;

        public Builder setOrderItemId(String orderItemId) {
            this.orderItemId = orderItemId;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setSubTotal(double subTotal) {
            this.subTotal = subTotal;
            return this;
        }

        public OrderItem build(){
            return new OrderItem(this);
        }
    }
}
