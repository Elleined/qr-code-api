package com.elleined.qrcodeapi.controller.generator;

import com.elleined.qrcodeapi.service.generator.QrCodeGenerator;
import com.google.zxing.WriterException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/generate")
public class QrCodeGeneratorController {
    private final QrCodeGenerator qrCodeGenerator;

    @PostMapping("/single-valued")
    public void generateQrCode(@RequestParam("data") String data,
                               @RequestParam("width") int width,
                               @RequestParam("height") int height,
                               @RequestParam("destinationWithFileName") String destinationWithFileName) throws IOException, WriterException {

        qrCodeGenerator.generateSingleValuedQrCode(data, width, height, destinationWithFileName);
    }

    @PostMapping("/multi-valued")
    public void generateQrCode(@RequestParam("dataList") List<String> dataList,
                               @RequestParam("width") int width,
                               @RequestParam("height") int height,
                               @RequestParam("destinationWithFileName") String destinationWithFileName) throws IOException, WriterException {

        qrCodeGenerator.generateMultiValuedQrCode(dataList, width, height, destinationWithFileName);
        
    }
}
