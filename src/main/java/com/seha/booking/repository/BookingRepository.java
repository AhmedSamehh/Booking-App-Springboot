package com.seha.booking.repository;

import com.seha.booking.entity.Apartment;
import com.seha.booking.entity.Booking;
import com.seha.booking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByCustomer(User customer);

    List<Booking> findByApartment(Apartment apartment);
}