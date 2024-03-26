package com.elleined.qrcodeapi.controller;

import com.elleined.qrcodeapi.dto.QrCode;
import com.elleined.qrcodeapi.service.generator.QrCodeGenerator;
import com.google.zxing.WriterException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/generate")
public class QrCodeGeneratorController {
    private final QrCodeGenerator qrCodeGenerator;

    @PostMapping("/single-valued")
    public void generateQrCode(@RequestParam String data,
                               @RequestParam int width,
                               @RequestParam int height,
                               @Valid @RequestPart("qrCode") QrCode qrCode) throws IOException, WriterException {

        qrCodeGenerator.generateQrCode(data, width, height, qrCode);
    }

    @PostMapping("/multi-valued")
    public void generateQrCode(@RequestPart("dataList") List<String> dataList,
                               @RequestParam int width,
                               @RequestParam int height,
                               @Valid @RequestPart("qrCode") QrCode qrCode) throws IOException, WriterException {

        qrCodeGenerator.generateQrCode(dataList, width, height, qrCode);
    }
}
