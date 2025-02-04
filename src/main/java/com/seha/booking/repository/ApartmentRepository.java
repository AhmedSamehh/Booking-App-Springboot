package com.seha.booking.repository;

import com.seha.booking.entity.Apartment;
import com.seha.booking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
    List<Apartment> findByOwner(User owner);

    List<Apartment> findByLocationContainingIgnoreCase(String location);
}
