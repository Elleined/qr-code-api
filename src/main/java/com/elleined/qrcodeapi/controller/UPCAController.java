package com.elleined.qrcodeapi.controller;

import com.elleined.qrcodeapi.service.UPCACodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
@RequiredArgsConstructor
@RequestMapping("/upc-a")
public class UPCAController {
    private final UPCACodeService upcaCodeService;

    @GetMapping(value = "/generate", produces = MediaType.IMAGE_PNG_VALUE)
    public BufferedImage generate(@RequestParam(value = "text", defaultValue = "12345678901") String text,
                                  @RequestParam(value = "width", required = false, defaultValue = "300") int width,
                                  @RequestParam(value = "height", required = false, defaultValue = "150") int height) {

        return upcaCodeService.generate(text, width, height);
    }
}
