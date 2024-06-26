package com.elleined.qrcodeapi.service.generator;

import com.elleined.qrcodeapi.PathValidator;
import com.elleined.qrcodeapi.exception.data.NoDataException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@Service
public class QrCodeGeneratorImpl implements QrCodeGenerator {

    @Override
    public void generateQrCode(String data, int width, int height, String destinationWithFileName)
            throws WriterException,
            IOException,
            NoDataException {

        if (PathValidator.validate(data))
            throw new NoDataException("Please specify the data that will be encoded in your qr code");

        BitMatrix matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, width, height);
        MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(destinationWithFileName));
        log.debug("QR Code with single-valued value generated successfully");
    }

    @Override
    public void generateQrCode(List<String> dataList, int width, int height, String destinationWithFileName)
            throws WriterException,
            IOException,
            NoDataException {

        if (dataList.isEmpty()) throw new NoDataException("Please specify the data that will be encoded in your qr code");
        String joinedData = String.join(", ", dataList);
        BitMatrix matrix = new MultiFormatWriter()
                .encode(joinedData, BarcodeFormat.QR_CODE, width, height);
        MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(destinationWithFileName));
        log.debug("QR Code with multi-valued values generated successfully");
    }
}
