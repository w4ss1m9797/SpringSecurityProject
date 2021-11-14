package com.userservice.userservice.repository;

import com.userservice.userservice.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<AppUser,Long> {
    AppUser findByUsername(String username);
}
