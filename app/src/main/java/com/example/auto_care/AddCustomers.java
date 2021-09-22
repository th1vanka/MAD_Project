package com.example.auto_care;

public class AddCustomers {
    private String cusName;
    private String cusUserName;
    private String cusEmail;
    private String phone;


    public AddCustomers(){

    }

    public AddCustomers(String name,String uname,String mail,String no){
        this.cusName=name;
        this.cusUserName=uname;
        this.cusEmail=mail;
        this.phone=no;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusUserName() {
        return cusUserName;
    }

    public void setCusUserName(String cusUserName) {
        this.cusUserName = cusUserName;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
