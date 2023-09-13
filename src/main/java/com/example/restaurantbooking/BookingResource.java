package com.example.restaurantbooking;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/api/bookings")
public class BookingResource {
    private static List<Booking> bookings = new ArrayList<>();

    @GET
    @Path("/hello")
    public String sayHello() {
        return "Hello, MuServer!";
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBooking(Booking booking) {
        // Handle the booking object, e.g., save it to a database
        // You can access booking fields using getters like booking.getCustomerName()
        // You can also return the created booking or a confirmation response

        // Assuming you have some logic to save the booking, you can return a response like this:
        // return Response.status(201).entity("Booking created: " + booking.getCustomerName()).build();
        return Response.status(201).entity("Booking created").build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createBooking(
            @FormParam("customerName") String customerName,
            @FormParam("tableSize") int tableSize,
            @FormParam("date") String date,
            @FormParam("time") String time) {
        // Create a Booking object with the provided parameters
        Booking booking = new Booking(customerName, tableSize, date, time);
        bookings.add(booking);

        // Handle the booking object, e.g., save it to a database
        // You can access booking fields using getters like booking.getCustomerName()
        // You can also return the created booking or a confirmation response

        // Assuming you have some logic to save the booking, you can return a response like this:
        // return Response.status(201).entity("Booking created: " + booking.getCustomerName()).build();
        return Response.status(201).entity("Booking created").build();
    }

    @GET
    @Path("/get")
    @Produces("application/json")
    public Response  getAllBookings(@QueryParam("date") String date) {
        if (date == null || date.isEmpty()) {
            throw new WebApplicationException("Date parameter is required", Response.Status.BAD_REQUEST);
        }
        List<Booking> filteredBookings = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getDate().equals(date)) {
                filteredBookings.add(booking);
            }
        }

        if (filteredBookings.isEmpty()) {
            return Response.status(201).entity("No bookings found for the specified date").build();
        }

        return Response.status(201).entity(filteredBookings.toString()).build();

    }
}
