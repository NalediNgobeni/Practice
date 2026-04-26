package za.ac.cput.practice.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Name {
    private String firstName;
    private String middleName;
    private String lastName;


    protected Name(){}
    private Name(Builder builder){
       this.firstName=builder.firstName;
        this.middleName=builder.middleName;
        this.lastName=builder.lastName;

    }
    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }


public static class Builder{
    private String firstName;
    private String middleName;
    private String lastName;

    public Builder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Builder setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public Builder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public Name build(){
        return new Name(this);
    }
}

}
