package com.studentmanagement.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.root.entity.User;

@Repository
public interface UserRepository extends JpaRepository< User, Integer>{

}
