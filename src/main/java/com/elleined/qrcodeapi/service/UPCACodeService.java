package com.elleined.qrcodeapi.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.UPCAWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Slf4j
@Service
@RequiredArgsConstructor
public class UPCACodeService implements CodeService {
    private final UPCAWriter upcaWriter;

    @Override
    public BufferedImage generate(String text, int width, int height) {
        BitMatrix bitMatrix = upcaWriter.encode(text, BarcodeFormat.UPC_A, width, height);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}
