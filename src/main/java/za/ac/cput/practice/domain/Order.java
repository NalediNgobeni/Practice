package za.ac.cput.practice.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
@Entity
@Table(name="Order")
 @Inheritance(strategy= InheritanceType.JOINED)
public abstract class Order {
    @Id
    private String orderId;
    private Date date;
    private String status;
  


    protected Order(Builder builder){
        this.orderId = builder.orderId;
        this.date = builder.date;
        this.status = builder.status;

    }

    public Order() {

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



    public abstract static class Builder {
        private String orderId;
        private Date date;
        private String status;


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

        public abstract Order build() ;

    }
}