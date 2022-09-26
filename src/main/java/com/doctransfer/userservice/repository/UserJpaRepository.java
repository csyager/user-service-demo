package com.doctransfer.userservice.repository;

import com.doctransfer.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {
    User findById(long id);
}
