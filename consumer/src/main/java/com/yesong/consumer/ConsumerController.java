package com.yesong.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private ISend isend;

    @Autowired
    private IFile iFile;
    //@PostMapping(value = "test", consumes = MULTIPART_FORM_DATA_VALUE)
    @RequestMapping(value = "test")
    //@HystrixCommand(fallbackMethod = "fallback")
    public String test(
            @RequestParam("image") MultipartFile image,
            @RequestParam("id") String id,
            HttpServletRequest request) {
        String s = iFile.uploadImage(image, id, request);
        return s;
    }
    public String fallback(){
        return "网络异常";
    }

}
