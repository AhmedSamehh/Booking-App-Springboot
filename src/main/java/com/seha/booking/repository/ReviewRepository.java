package com.seha.booking.repository;

import com.seha.booking.entity.Review;
import com.seha.booking.entity.User;
import com.seha.booking.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByCustomer(User customer);

    List<Review> findByApartment(Apartment apartment);
}
