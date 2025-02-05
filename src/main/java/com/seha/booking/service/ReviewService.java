package com.seha.booking.service;

import com.seha.booking.entity.Review;
import com.seha.booking.entity.User;
import com.seha.booking.entity.Apartment;
import com.seha.booking.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public List<Review> getReviewsByCustomer(User customer) {
        return reviewRepository.findByCustomer(customer);
    }

    public List<Review> getReviewsForApartment(Apartment apartment) {
        return reviewRepository.findByApartment(apartment);
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }
}