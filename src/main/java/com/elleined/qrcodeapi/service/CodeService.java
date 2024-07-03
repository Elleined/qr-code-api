package com.elleined.qrcodeapi.service;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public interface CodeService {
    BufferedImage generate(String text, int width, int height) throws WriterException;

    static String read(String source) throws IOException, NotFoundException {
        BufferedImage bf = ImageIO.read(new FileInputStream(source));
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(bf)
        ));
        Result result = new MultiFormatReader().decode(bitmap);
        return result.getText();
    }

    static String read(BufferedImage bufferedImage) throws NotFoundException {
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(bufferedImage)
        ));
        Result result = new MultiFormatReader().decode(bitmap);
        return result.getText();
    }
}

