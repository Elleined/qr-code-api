package com.elleined.qrcodeapi.controller;

import com.elleined.qrcodeapi.dto.QrCode;
import com.elleined.qrcodeapi.service.QrCodeReader;
import com.google.zxing.NotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/read")
public class QrCodeReaderController {

    private final QrCodeReader qrCodeReader;

    @PostMapping("/single-valued")
    public String read(@Valid @RequestBody QrCode qrCode) throws NotFoundException, IOException {
        return qrCodeReader.read(qrCode);
    }

    @PostMapping("/multi-valued")
    public List<String> readMultiValued(@Valid @RequestBody QrCode qrCode) throws NotFoundException, IOException {
        return qrCodeReader.readMultiValued(qrCode);
    }
}
