package com.elleined.qrcodeapi.controller;

import com.elleined.qrcodeapi.service.QRCodeService;
import com.google.zxing.WriterException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
@RequiredArgsConstructor
@RequestMapping("/qr-code")
public class QRCodeController {
    private final QRCodeService qrCodeService;

    @GetMapping(value = "/generate", produces = MediaType.IMAGE_PNG_VALUE)
    public BufferedImage generate(@RequestParam("text") String text,
                                  @RequestParam(value = "width", required = false, defaultValue = "300") int width,
                                  @RequestParam(value = "height", required = false, defaultValue = "150") int height) throws WriterException {

        return qrCodeService.generate(text, width, height);
    }
}
