package com.elleined.qrcodeapi.service;

import com.elleined.qrcodeapi.PathValidator;
import com.elleined.qrcodeapi.exception.data.NoDataException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
public class QrCodeGenerator {

    /**
     * This method will store single valued QR Code right away in the specified directory path
     * If you want to store an array or multivalued data in your QR Code consider using generateQrCode method with the parameter of List<String>
     * @param data is the text you want to encode/store in your QR Code
     * @param width is the width of the QR Code image
     * @param height is the height of the QR Code image
     * @param filePath is the full path directory where the file is located. example: C://
     * @param fileName is the actual file name of the qr code. example: myqrcode
     * @param imageFormat is file format of the qr code. example: jpg, png, etc...
     */
    public void generateQrCode(String data, int width, int height, String filePath, String fileName, String imageFormat)
            throws WriterException,
            IOException,
            NoDataException {

        if (PathValidator.validate(data)) throw new NoDataException("Please specify the data that will be encoded in your qr code");
        if (PathValidator.validate(filePath)) filePath = "./";
        if (PathValidator.validate(fileName)) fileName = "generated-qr-code";
        if (PathValidator.validate(imageFormat)) imageFormat = "jpg";

        BitMatrix matrix = new MultiFormatWriter()
                .encode(data, BarcodeFormat.QR_CODE, width, height);

        String formattedPath = filePath + "\\" + fileName + '.' + imageFormat;
        MatrixToImageWriter.writeToPath(matrix, imageFormat, Paths.get(formattedPath));
        log.debug("Qr Code Created Successfully");
    }

    /**
     * This method will store an List<String> that will be encoded in your QR Code
     * If you want to read the list back consider using readMultiValuedQrCode method in QrCodeReader object
     * Note: If you use readQrCode it will only return the literal String of all the values you encoded
     * @param dataList is the List<String> of values you want to store in your QR Code
     * @param width is the width of the QR Code image
     * @param height is the height of the QR Code image
     * @param filePath is the full path directory where the file is located. example: C://
     * @param fileName is the actual file name of the qr code. example: myqrcode
     * @param imageFormat is file format of the qr code. example: jpg, png, etc...
     */
    public void generateQrCode(List<String> dataList, int width, int height, String filePath, String fileName, String imageFormat)
            throws WriterException,
            IOException,
            NoDataException {

        if (dataList.isEmpty()) throw new NoDataException("Please specify the data that will be encoded in your qr code");
        if (PathValidator.validate(filePath)) filePath = "./";
        if (PathValidator.validate(fileName)) fileName = "generated-qr-code";
        if (PathValidator.validate(imageFormat)) imageFormat = "jpg";

        String joinedData = String.join(", ", dataList);

        BitMatrix matrix = new MultiFormatWriter()
                .encode(joinedData, BarcodeFormat.QR_CODE, width, height);

        String formattedPath = filePath + "\\" + fileName + '.' + imageFormat;
        MatrixToImageWriter.writeToPath(matrix, imageFormat, Paths.get(formattedPath));
        log.debug("Qr Code Created Successfully");
    }
}
