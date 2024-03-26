package com.elleined.qrcodeapi.service.generator;

import com.elleined.qrcodeapi.exception.data.NoDataException;
import com.google.zxing.WriterException;

import java.io.IOException;
import java.util.List;

public interface QrCodeGenerator {
    void generateSingleValuedQrCode(String data, int width, int height, String destinationWithFileName)
            throws WriterException,
            IOException,
            NoDataException;

    void generateMultiValuedQrCode(List<String> dataList, int width, int height, String destinationWithFileName)
            throws WriterException,
            IOException,
            NoDataException;
}
