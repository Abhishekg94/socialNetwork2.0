package com.example.allinone.dao;

import com.example.allinone.dao.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileDao extends JpaRepository<UserProfile, Integer> {
}
