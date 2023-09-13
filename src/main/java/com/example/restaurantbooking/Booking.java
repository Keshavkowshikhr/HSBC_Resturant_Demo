package com.example.restaurantbooking;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Booking  {
    @JsonProperty("customerName")
    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public Booking(String customerName, int tableSize, String date, String time) {
        this.customerName = customerName;
        this.tableSize = tableSize;
        this.date = date;
        this.time = time;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getTableSize() {
        return tableSize;
    }

    public void setTableSize(int tableSize) {
        this.tableSize = tableSize;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("tableSize")
    private int tableSize;

    @JsonProperty("date")
    private String date;

    @JsonProperty("time")
    private String time;


    @Override
    public String toString() {
        return "{" +
                "\"customerName\": \"" + customerName + "\", " +
                "\"tableSize\": " + tableSize + ", " +
                "\"date\": \"" + date + "\", " +
                "\"time\": \"" + time + "\"" +
                "}";
    }



}