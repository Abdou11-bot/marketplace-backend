package com.project.marketplace.service;

import com.project.marketplace.entity.Image;
import com.project.marketplace.repository.ImageRepository;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    private final ImageRepository imageRepository;
    public ImageService(ImageRepository imageRepository){
        this.imageRepository = imageRepository;
    }
    public void addImage(Image image){
        this.imageRepository.save(image);
    }
    public String getImage(Long id){
        Image image = this.imageRepository.findById(id).orElseThrow();
        return image.getPath();
    }
    public Image updateImage(Image image){
        return this.imageRepository.save(image);
    }

//    public String getImageByClientId(Long id){
//        Image image = this.imageRepository.findFirstByClientId(id);
//        if(!image.equals(null))
//            return image.getPath();
//        else
//            return "L'image n'existe pas";
//    }
//    public void deleteImages(Long id){
//        this.imageRepository.deleteAllByClientId(id);
//    }
}
