package com.elleined.qrcodeapi.service.reader;

import com.elleined.qrcodeapi.dto.QrCode;
import com.google.zxing.NotFoundException;

import java.io.IOException;
import java.util.List;

public interface QrCodeReader {

    // Example: C:\\my-qr-code.png
    String read(String absolutePathWithFileName)
            throws IOException,
            NotFoundException;

    // Example: C:\\my-qr-code.png
    List<String> readMultiValued(String absolutePathWithFileName)
            throws NotFoundException,
            IOException;
}
