package com.elleined.qrcodeapi.controller;

import com.elleined.qrcodeapi.service.EAN13CodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ean13")
public class EAN13Controller {

    private final EAN13CodeService ean13CodeService;

    @GetMapping(value = "/generate", produces = MediaType.IMAGE_PNG_VALUE)
    public BufferedImage generate(@RequestParam(value = "text", defaultValue = "4006381333931") String text,
                                  @RequestParam(value = "width", required = false, defaultValue = "300") int width,
                                  @RequestParam(value = "height", required = false, defaultValue = "150") int height) {

        return ean13CodeService.generate(text, width, height);
    }
}
