package za.ac.cput.practice.domain;

import jakarta.persistence.Entity;

@Entity
public class OnlineOrder extends Order {

    private String deliveryAddress;
    private String shippingCode;
    private Double digitalPayment;

    // Constructor
    private OnlineOrder(Builder builder) {
        super(builder); // 🔥 VERY IMPORTANT (calls Order constructor)
        this.deliveryAddress = builder.deliveryAddress;
        this.shippingCode = builder.shippingCode;
        this.digitalPayment = builder.digitalPayment;
    }

    // Getters
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getShippingCode() {
        return shippingCode;
    }

    public Double getDigitalPayment() {
        return digitalPayment;
    }

    // 🔥 Builder (extends Order.Builder)
    public static class Builder extends Order.Builder {
        private String deliveryAddress;
        private String shippingCode;
        private Double digitalPayment;

        public Builder setDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public Builder setShippingCode(String shippingCode) {
            this.shippingCode = shippingCode;
            return this;
        }

        public Builder setDigitalPayment(Double digitalPayment) {
            this.digitalPayment = digitalPayment;
            return this;
        }

        @Override
        public OnlineOrder build() {
            return new OnlineOrder(this);
        }
    }
}