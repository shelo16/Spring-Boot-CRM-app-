package com.tornikeshelia.springboot.SpringBootCrmWithIntelliJ.service;

import com.tornikeshelia.springboot.SpringBootCrmWithIntelliJ.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {



}
