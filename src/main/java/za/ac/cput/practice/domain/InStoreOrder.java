package za.ac.cput.practice.domain;

import jakarta.persistence.Entity;

@Entity
public class InStoreOrder extends Order {
    private Double immediatePayment;
    private String cashierName;

    private InStoreOrder(Builder builder){
        super(builder);
        this.immediatePayment=builder.immediatePayment;
        this.cashierName=cashierName;
    }

    public InStoreOrder() {

    }

    public Double getImmediatePayment() {
        return immediatePayment;
    }

    public String getCashierName() {
        return cashierName;
    }
    public static class Builder extends Order.Builder{
        private Double immediatePayment;
        private String cashierName;

        public Builder setImmediatePayment(Double immediatePayment) {
            this.immediatePayment = immediatePayment;
            return this;
        }

        public Builder setCashierName(String cashierName) {
            this.cashierName = cashierName;
            return this;
        }
        @Override
        public InStoreOrder build(){
            return new InStoreOrder(this);
        }
    }

}
