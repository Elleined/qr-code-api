package com.elleined.qrcodeapi.service;

import com.elleined.qrcodeapi.dto.QrCode;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class QrCodeReader {

    // This method will transform the specified paths like: C://myqrcode.jpg automatically
    public String read(QrCode qrCode)
            throws IOException,
            NotFoundException {

        String filePath = qrCode.getFilePath();
        String fileName = qrCode.getFileName();
        String imageFormat = qrCode.getImageFormat();

        String formattedPath = filePath + "\\" + fileName + '.' + imageFormat;
        BufferedImage bf = ImageIO.read(new FileInputStream(formattedPath));

        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(bf)
        ));

        Result result = new MultiFormatReader().decode(bitmap);
        log.debug("QR Code with single-valued value read successfully");
        return result.getText();
    }

    // This method will transform the specified paths like: C://myqrcode.jpg automatically
    public List<String> readMultiValued(QrCode qrCode)
            throws NotFoundException,
            IOException {

        String filePath = qrCode.getFilePath();
        String fileName = qrCode.getFileName();
        String imageFormat = qrCode.getImageFormat();

        String formattedPath = filePath + "\\" + fileName + '.' + imageFormat;
        BufferedImage bf = ImageIO.read(new FileInputStream(formattedPath));

        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(bf)
        ));

        Result result = new MultiFormatReader().decode(bitmap);
        String decodeQrCode = result.getText();

        List<String> list = Arrays.asList(decodeQrCode.split(","));

        log.debug("QR Code with multi-valued values read successfully");
        return list;
    }
}
