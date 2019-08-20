package com.yesong.fileclient;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
public class FeginServiceExample {
    @PostMapping(value = "images", consumes = MULTIPART_FORM_DATA_VALUE)
    public String uploadImage(
            @RequestParam("image") MultipartFile image,
            @RequestParam("id") String id,
            HttpServletRequest request) {

        String name = image.getOriginalFilename();
        return name;
    }
}
