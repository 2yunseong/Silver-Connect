package com.confident.silverconnect.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    List<User> findByName(String userName);

    Optional<User> findByEmail(String userEmail);
}
