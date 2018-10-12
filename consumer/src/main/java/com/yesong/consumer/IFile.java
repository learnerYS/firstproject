package com.yesong.consumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@FeignClient("eureka-fileclient")
public interface IFile {
    @PostMapping(value = "images", consumes = MULTIPART_FORM_DATA_VALUE)
    public String uploadImage(
            @RequestParam("image") MultipartFile image,
            @RequestParam("id") String id,
            HttpServletRequest request);
}
