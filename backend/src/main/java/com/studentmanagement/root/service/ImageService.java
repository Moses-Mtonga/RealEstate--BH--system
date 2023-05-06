package com.studentmanagement.root.service;

import com.studentmanagement.root.entity.Image;
import com.studentmanagement.root.repository.ImagesRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImagesRepo imageRepository;

    public Image createImage(Image image) {
        return imageRepository.save(image);
    }

    public Image getImageById(Integer id) {
        Optional<Image> optionalImage = imageRepository.findById(id);
        return optionalImage.orElse(null);
    }

//    public Image updateImage(Integer id, Image image) {
//        Optional<Image> optionalImage = imageRepository.findById(id);
//        if (optionalImage.isPresent()) {
//            image.setId(id);
//            return imageRepository.save(image);
//        } else {
//            return null;
//        }
//    }

    public String deleteImage(Integer id) {
        Optional<Image> optionalImage = imageRepository.findById(id);
        if (optionalImage.isPresent()) {
            imageRepository.deleteById(id);
            return "deleted";
        } else {
            return "image not present";
        }
    }
}
