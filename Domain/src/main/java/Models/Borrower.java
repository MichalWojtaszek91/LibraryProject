package Models;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Borrower {
    private String name;
    private String lastName;
    private int phoneNumber;
    private String email;
    private Long borrowerId;
    private boolean isRemoved;

    private Borrower(BorrowerBuilder borrowerBuilder) {
        this.name = borrowerBuilder.name;
        this.lastName = borrowerBuilder.lastName;
        this.phoneNumber = borrowerBuilder.phoneNumber;
        this.email = borrowerBuilder.email;
    }

    public void setRemoved(boolean removed) {
        isRemoved = removed;
    }

    public boolean isRemoved() {
        return isRemoved;
    }

    public void setBorrowerId(Long borrowerId) {
        this.borrowerId = borrowerId;
    }

    public Long getBorrowerId() {
        return borrowerId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }


    public String getEmail() {
        return email;
    }

    public class BorrowerBuilder{
        private String name;
        private String lastName;
        private int phoneNumber;
        private String email;

        public BorrowerBuilder(String name, String lastName, int phoneNumber, String email) {
            this.name = name;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        public Borrower Build(){
            return new Borrower(this);
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setPhoneNumber(int phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
