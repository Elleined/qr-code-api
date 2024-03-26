package com.elleined.qrcodeapi.controller;

import com.elleined.qrcodeapi.service.reader.QrCodeReader;
import com.google.zxing.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/read")
public class QrCodeReaderController {

    private final QrCodeReader qrCodeReader;

    @PostMapping("/single-valued")
    public String read(@RequestParam("absolutePathWithFileName") String absolutePathWithFileName) throws NotFoundException, IOException {
        return qrCodeReader.read(absolutePathWithFileName);
    }

    @PostMapping("/multi-valued")
    public List<String> readMultiValued(@RequestParam("absolutePathWithFileName") String absolutePathWithFileName) throws NotFoundException, IOException {
        return qrCodeReader.readMultiValued(absolutePathWithFileName);
    }
}
