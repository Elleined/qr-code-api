package com.elleined.qrcodeapi.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.EAN13Writer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Slf4j
@Service
@RequiredArgsConstructor
public class EAN13CodeService implements CodeService {
    private final EAN13Writer ean13Writer;

    @Override
    public BufferedImage generate(String text, int width, int height) {
        BitMatrix bitMatrix = ean13Writer.encode(text, BarcodeFormat.EAN_13, width, height);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}
