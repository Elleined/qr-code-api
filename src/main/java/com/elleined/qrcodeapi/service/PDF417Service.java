package com.elleined.qrcodeapi.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.PDF417Writer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Slf4j
@Service
@RequiredArgsConstructor
public class PDF417Service implements CodeService {

    private final PDF417Writer pdf417Writer;

    @Override
    public BufferedImage generate(String text, int width, int height) throws WriterException {
        BitMatrix bitMatrix = pdf417Writer.encode(text, BarcodeFormat.PDF_417, width, height);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}
