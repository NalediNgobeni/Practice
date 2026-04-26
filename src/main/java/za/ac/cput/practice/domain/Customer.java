package za.ac.cput.practice.domain;

import jakarta.persistence.*;


@Entity
public class Customer {
    @Id
    private String patientId;

    @Embedded
    private Name name;
    private String email;
    private String mobileNumber;

    private Customer(Builder builder){
        this.patientId=builder.patientId;
        this.name=builder.name;
        this.email=builder.email;
        this.mobileNumber=builder.mobileNumber;
    }

    public String getPatientId() {
        return patientId;
    }

    public Name getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
    public static class Builder{
        private String patientId;
        private Name name;
        private String email;
        private String mobileNumber;

        public Builder setPatientId(String patientId) {
            this.patientId = patientId;
            return this;
        }

        public Builder setName(Name name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }
        public Customer build(){
            if(patientId==null || name==null){

                throw new IllegalStateException("Customer must have an ID and name");            }
            return new Customer(this);
        }
    }
}
