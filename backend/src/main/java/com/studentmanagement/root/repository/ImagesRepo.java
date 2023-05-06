package com.studentmanagement.root.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.root.entity.Image;

	@Repository
	public interface ImagesRepo extends JpaRepository <Image, Integer> {

	}
