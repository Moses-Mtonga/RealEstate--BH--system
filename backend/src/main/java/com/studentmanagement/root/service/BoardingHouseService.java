package com.studentmanagement.root.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.root.entity.BoardingHouse;
import com.studentmanagement.root.repository.BoardingHouseRepo;

@Service
public class BoardingHouseService {

	@Autowired
	private BoardingHouseRepo boardingHouseRepo;

	public BoardingHouse getBoardingHouseById(Integer id) {
		Optional<BoardingHouse> optionalBoardingHouse = boardingHouseRepo.findById(id);
		return optionalBoardingHouse.orElse(null);
	}
	
	public List<BoardingHouse> getAllBoardingHouses(){
		return boardingHouseRepo.findAll();
	}
	
	public BoardingHouse createBoardingHouse(BoardingHouse boardingHouse) {
		return boardingHouseRepo.save(boardingHouse);
	}
	
	public BoardingHouse updateBoardingHouse(Integer id, BoardingHouse boardingHouse) {
		Optional<BoardingHouse> optionalBoardingHouse = boardingHouseRepo.findById(id);
		if (optionalBoardingHouse.isPresent()) {
			BoardingHouse existingBoardingHouse = optionalBoardingHouse.get();
			existingBoardingHouse.setName(boardingHouse.getName());
			existingBoardingHouse.setLocation(boardingHouse.getLocation());
			existingBoardingHouse.setDescription(boardingHouse.getDescription());
			existingBoardingHouse.setCapacity(boardingHouse.getCapacity());
			existingBoardingHouse.setTotalRooms(boardingHouse.getTotalRooms());
			existingBoardingHouse.setPrice(boardingHouse.getPrice());
		
			return boardingHouseRepo.save(existingBoardingHouse);
		} else {
			return null;
		}
	}
		
		public boolean deleteBoardingHouse(Integer id) {
			Optional<BoardingHouse> optionalBoardingHouse = boardingHouseRepo.findById(id);
			if (optionalBoardingHouse.isPresent()) {
				boardingHouseRepo.delete(optionalBoardingHouse.get());
				return true;
			} else {
				return false;
			}
		}
		
	
}
