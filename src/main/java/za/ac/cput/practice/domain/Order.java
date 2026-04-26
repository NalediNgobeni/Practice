package za.ac.cput.practice.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class Order {
    @Id
    private String orderId;
    private Date date;
    private String status;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    protected Order(Builder builder){
        this.orderId = builder.orderId;
        this.date = builder.date;
        this.status = builder.status;
        this.orderItems=builder.orderItems;
    }

    public String getOrderId() {
        return orderId;
    }

    public Date getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    // 🔥 Builder
    public abstract static class Builder {
        private String orderId;
        private Date date;
        private String status;
        private List<OrderItem> orderItems;

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setDate(Date date) {
            this.date = date;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setOrderItems(List<OrderItem> orderItems) {
            this.orderItems = orderItems;
            return this;
        }

        public abstract Order build() ;

    }
}