package com.studentmanagement.root.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagement.root.entity.BoardingHouse;
import com.studentmanagement.root.service.BoardingHouseService;

@RestController
@RequestMapping("/boardinghouse")
public class BoardingHouseController {
	@Autowired
	private BoardingHouseService boardingHouseService;

	@GetMapping("/{id}")
	public ResponseEntity<BoardingHouse> getBoardingHouseById(@PathVariable("id") Integer id) {
		BoardingHouse boardingHouse = boardingHouseService.getBoardingHouseById(id);
		if (boardingHouse != null) {
			return ResponseEntity.ok(boardingHouse);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<BoardingHouse>> getAllBoardingHouses(){
		return ResponseEntity.ok(boardingHouseService.getAllBoardingHouses());
	}
	
	@PostMapping("/postbh")
	public ResponseEntity<BoardingHouse> createBoardingHouse(@RequestBody BoardingHouse boardingHouse) {
		BoardingHouse createdBoardingHouse = boardingHouseService.createBoardingHouse(boardingHouse);
		return ResponseEntity.ok(createdBoardingHouse);
	}
	
	@PutMapping("updatebh/{id}")
	public ResponseEntity<BoardingHouse> updateBoardingHouse(@PathVariable("id") Integer id,
			@RequestBody BoardingHouse boardingHouse) {
		BoardingHouse updatedBoardingHouse = boardingHouseService.updateBoardingHouse(id, boardingHouse);
		if (updatedBoardingHouse != null) {
			return ResponseEntity.ok(updatedBoardingHouse);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("deletebh/{id}")
	public ResponseEntity<Void> deleteBoardingHouse(@PathVariable("id") Integer id) {
		boolean deleted = boardingHouseService.deleteBoardingHouse(id);
		if (deleted) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
