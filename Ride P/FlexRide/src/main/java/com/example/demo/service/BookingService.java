

package com.example.demo.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.BookingEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.CarEntity;
import com.example.demo.repository.BookingRepo;
import com.example.demo.repository.CarRepo;

@Service
public class BookingService {
private static final Logger logger = LoggerFactory.getLogger(BookingService.class);

    @Autowired
    private BookingRepo bookingRepo;
    
    @Autowired
    private CarRepo carRepo;
    
    /* public void bookCar(UserEntity user, CarEntity car) {
        if (user == null || car == null) {
            logger.error("Booking failed: User or Car is null");
            return;
        }
        logger.info("Booking car: {} for user: {}", car, user); //This line logs an informational message indicating that a car is being booked for a user.
        BookingEntity booking = new BookingEntity(user, car); //This line creates a new BookingEntity object using the provided user and car.
        bookingRepo.save(booking); // calls the save method of the bookingRepo repository to save the BookingEntity to the database.
    }*/

    
    public void bookCar(UserEntity user, CarEntity car) {
        if (car.isBooked()) {
            throw new RuntimeException("Car is already booked and unavailable.");
        }
        car.setBooked(true);
        carRepo.save(car);
        bookingRepo.save(new BookingEntity(user, car));
    }

    public List<BookingEntity> getAllBookings() {
     logger.info("Fetching all bookings");
        return bookingRepo.findAll();
    }
    
    
}



