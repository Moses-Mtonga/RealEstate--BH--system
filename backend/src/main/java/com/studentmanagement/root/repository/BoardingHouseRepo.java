package com.studentmanagement.root.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.root.entity.BoardingHouse;

	@Repository
	public interface BoardingHouseRepo extends JpaRepository <BoardingHouse, Integer> {

	}



