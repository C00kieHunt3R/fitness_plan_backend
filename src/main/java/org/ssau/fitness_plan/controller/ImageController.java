package org.ssau.fitness_plan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.ssau.fitness_plan.service.ImageService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class ImageController {

    @Autowired
    ImageService imageService;

    @GetMapping(value = "/get/{image}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] findImage(@PathVariable String image) throws IOException {
        return imageService.getImage(image);
    }

    @GetMapping(value = "/get-all")
    public List<String> findAll() throws IOException {
        return imageService.getAll();
    }
}
