package org.ssau.fitness_plan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.ssau.fitness_plan.service.ImageService;

import java.io.IOException;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    ImageService imageService;

    @GetMapping(value = "/{image}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] findImage(@PathVariable String image) throws IOException {
        return imageService.getImage(image);
    }
}
