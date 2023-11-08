package com.elleined.qrcodeapi.controller;

import com.elleined.qrcodeapi.service.QrCodeReader;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/read")
public class QrCodeReaderController {
    
    private final QrCodeReader qrCodeReader;

    @PostMapping
    public String read() {
        return null;
    }


    @PostMapping
    public List<String> readMultiValued() {
        return null;
    }
}
