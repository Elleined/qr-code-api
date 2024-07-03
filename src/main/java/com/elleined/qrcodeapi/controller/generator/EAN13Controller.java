package com.elleined.qrcodeapi.controller.generator;

import com.elleined.qrcodeapi.service.generator.EAN13Generator;
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

    private final EAN13Generator ean13Generator;

    @GetMapping(value = "/generate", produces = MediaType.IMAGE_PNG_VALUE)
    public BufferedImage generate(@RequestParam("text") String text,
                                  @RequestParam(value = "width", required = false, defaultValue = "300") int width,
                                  @RequestParam(value = "height", required = false, defaultValue = "150") int height) {

        return ean13Generator.generate(text, width, height);
    }
}
