package com.studentmanagement.root.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.root.entity.Review;

	@Repository
	public interface ReviewRepo extends JpaRepository <Review, Integer> {

	}
