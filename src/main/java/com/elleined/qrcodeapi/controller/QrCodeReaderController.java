package com.elleined.qrcodeapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/read")
public class QrCodeReaderController {
    @PostMapping
    public String read() {
        return null;
    }


    @PostMapping
    public String readMultiValued() {
        return null;
    }
}
