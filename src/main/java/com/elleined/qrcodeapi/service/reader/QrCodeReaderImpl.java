package com.elleined.qrcodeapi.service.reader;

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
public class QrCodeReaderImpl implements QrCodeReader {

    @Override
    public String read(String absolutePathWithFileName)
            throws IOException,
            NotFoundException {

        BufferedImage bf = ImageIO.read(new FileInputStream(absolutePathWithFileName));
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(bf)
        ));
        Result result = new MultiFormatReader().decode(bitmap);
        log.debug("QR Code with single-valued value read successfully");
        return result.getText();
    }

    @Override
    public List<String> readMultiValued(String absolutePathWithFileName)
            throws NotFoundException,
            IOException {
        BufferedImage bf = ImageIO.read(new FileInputStream(absolutePathWithFileName));
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(bf)
        ));
        Result result = new MultiFormatReader().decode(bitmap);
        List<String> list = Arrays.asList(result.getText().split(","));
        log.debug("QR Code with multi-valued values read successfully");
        return list;
    }
}
