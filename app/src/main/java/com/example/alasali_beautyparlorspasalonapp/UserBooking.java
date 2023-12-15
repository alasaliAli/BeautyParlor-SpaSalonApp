package com.example.alasali_beautyparlorspasalonapp;

public class UserBooking {
    public String bookingName;
    public String bookingSerName;
    public String bookingPrice;
    public String bookingDate;
    public String bookingTime;

    public UserBooking() {
    }

    public UserBooking(String bookingName, String bookingSerName, String bookingPrice, String bookingDate, String bookingTime) {
        this.bookingName = bookingName;
        this.bookingSerName = bookingSerName;
        this.bookingPrice = bookingPrice;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    public String getBookingSerName() {
        return bookingSerName;
    }

    public void setBookingSerName(String bookingSerName) {
        this.bookingSerName = bookingSerName;
    }

    public String getBookingPrice() {
        return bookingPrice;
    }

    public void setBookingPrice(String bookingPrice) {
        this.bookingPrice = bookingPrice;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }
}
