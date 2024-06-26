package com.elleined.qrcodeapi.controller.reader;

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
    public String read(@RequestParam("destinationWithFileName") String destinationWithFileName) throws NotFoundException, IOException {
        return qrCodeReader.readSingleValued(destinationWithFileName);
    }

    @PostMapping("/multi-valued")
    public List<String> readMultiValued(@RequestParam("destinationWithFileName") String destinationWithFileName) throws NotFoundException, IOException {
        return qrCodeReader.readMultiValued(destinationWithFileName);
    }
}
