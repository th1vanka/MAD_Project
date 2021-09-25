package com.example.auto_care;



public class booking {
    private String Vehicle_ID;
    private String Vehicle_Type;
    private String Km_per_day;
    private String UserName;
    private String Email;
    private String Date;

    public booking(){

    }

    public booking(String id,String type,String km,String uname ,String mail,String date){
        this.Vehicle_ID=id;
        this.Vehicle_Type=type;
        this.Km_per_day= km;
        this.UserName=uname;
        this.Email= mail;
        this.Date= date;

    }



    public String getVehicle_ID() {
        return Vehicle_ID;
    }

    public void setVehicle_ID(String vehicle_ID) {
        Vehicle_ID = vehicle_ID;
    }

    public String getVehicle_Type() {
        return Vehicle_Type;
    }

    public void setVehicle_Type(String vehicle_Type) {
        Vehicle_Type = vehicle_Type;
    }

    public String getKm_per_day() {
        return Km_per_day;
    }

    public void setKm_per_day(String km_per_day) {
        Km_per_day = km_per_day;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
