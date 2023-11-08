package com.elleined.qrcodeapi.controller;

import com.elleined.qrcodeapi.PathValidator;
import com.elleined.qrcodeapi.dto.QrCode;
import com.elleined.qrcodeapi.exception.NoDataException;
import com.elleined.qrcodeapi.service.QrCodeGenerator;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Paths;
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
                               @Valid @RequestBody QrCode qrCode) throws IOException, WriterException {

        qrCodeGenerator.generateQrCode(data, width, height, qrCode);
    }

    @PostMapping("/multi-valued")
    public void generateQrCode(@RequestBody List<String> dataList,
                               @RequestParam int width,
                               @RequestParam int height,
                               @Valid @RequestBody QrCode qrCode) throws IOException, WriterException {

        qrCodeGenerator.generateQrCode(dataList, width, height, qrCode);
    }
}
