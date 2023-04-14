package com.cloverbaytechnologies.user.repository;

import com.cloverbaytechnologies.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);

    List<User> findUserByFirstName(String firstName);

    List<User> findUserByLastName(String lastName);

    List<User> findUserByPhoneNumber(String phoneNumber);

    List<User> findUserByCompanyName(String companyName);
}
