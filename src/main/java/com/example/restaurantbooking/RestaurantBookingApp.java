package com.example.restaurantbooking;

import io.muserver.MuServer;
import io.muserver.MuServerBuilder;
import io.muserver.rest.RestHandlerBuilder;

public class RestaurantBookingApp {
    public static void main(String[] args) {

       MuServer server = MuServerBuilder.httpServer()
                .withHttpPort(8080)
                .addHandler(RestHandlerBuilder.restHandler(new BookingResource()))
                .start();

        System.out.println("Server started on port 8080");
    }
}

