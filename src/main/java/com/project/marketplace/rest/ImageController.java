package com.project.marketplace.rest;

import com.project.marketplace.entity.*;
import com.project.marketplace.service.ImageStorageService;
import com.project.marketplace.service.ImageService;
import com.project.marketplace.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/image")
public class ImageController {
    private final ImageService imageService;
    private final ProductService productService;
    @Autowired
    private ImageStorageService imageStorageService;

    public ImageController(ImageService imageService, ProductService clientService) {
        this.imageService = imageService;
        this.productService = clientService;
    }

        @GetMapping("/load/{id}")
    public String getPath(@PathVariable Long id) {
        return this.imageService.getImage(id);
    }

//    @GetMapping("/loadClientImage/{id}")
//    public String getClientImagePath(@PathVariable Long id) {
//        return this.imageService.getImageByClientId(id);
//    }

    @PostMapping("/uploadImage/{id}")
    public String uploadFile(@PathVariable("product") Product product, @RequestParam("file") MultipartFile file) {

        String fileName = imageStorageService.storeImage(file,product);
        Image image = new Image(file,product);
//        this.imageService.addImage(image);
        return image.getPath();
    }

    @PostMapping("/uploadCatalogue/{id}")
    public String uploadCatalogue(@PathVariable("product") Product product, @RequestParam("file") MultipartFile file) {
        String fileName = imageStorageService.storeCatalogue(file,product);
        return "http://localhost:8080/catalogues/"+product.getProvider().getId()+"/"+product.getId()+"/" + file.getOriginalFilename();
    }

//    @PostMapping("/upload-multiple-images")
    @PostMapping("/upload-multiple-images/{id}")
    @ResponseBody
//    public String uploadMultipleFiles(@RequestParam("images") MultipartFile[] images) {
    public String uploadMultipleFiles(@PathVariable("product") Product product , @RequestParam("images") MultipartFile[] images) {

        System.out.println(images.length);
        return Arrays.stream(images)
                .map(file -> uploadFile(product,file))
                .collect(Collectors.toList()).toString();
//        return ""+images.length;
    }
}
