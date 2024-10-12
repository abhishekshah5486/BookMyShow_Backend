package com.abhishek.bookmyshow_backendsystem.Repositories;

import com.abhishek.bookmyshow_backendsystem.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository<User, Long>
    // <User table> and <datatype of the primary key>

    @Override
    Optional<User> findById(Long userId);

    @Query("Select u from users u where u.email = :email")
    Optional<User> findUserByEmail(@Param("email") String email);

    @Override
    User save(User user);
}
