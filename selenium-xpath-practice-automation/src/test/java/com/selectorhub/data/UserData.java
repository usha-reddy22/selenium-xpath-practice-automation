package com.selectorhub.data;

/**
 * User Data Model with Builder Pattern
 */
public class UserData {
    private String email;
    private String password;
    private String company;
    private String mobile;
    private String email2;
    private String carPreference;

    private UserData(Builder builder) {
        this.email = builder.email;
        this.password = builder.password;
        this.company = builder.company;
        this.mobile = builder.mobile;
        this.email2 = builder.email2;
        this.carPreference = builder.carPreference;
    }

    // Getters
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getCompany() { return company; }
    public String getMobile() { return mobile; }
    public String getEmail2() { return email2; }
    public String getCarPreference() { return carPreference; }

    public static class Builder {
        private String email;
        private String password;
        private String company;
        private String mobile;
        private String email2;
        private String carPreference;

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder company(String company) {
            this.company = company;
            return this;
        }

        public Builder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder email2(String email2) {
            this.email2 = email2;
            return this;
        }

        public Builder carPreference(String carPreference) {
            this.carPreference = carPreference;
            return this;
        }

        public UserData build() {
            return new UserData(this);
        }
    }

    @Override
    public String toString() {
        return "UserData{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", company='" + company + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email2='" + email2 + '\'' +
                ", carPreference='" + carPreference + '\'' +
                '}';
    }
}
