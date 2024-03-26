package com.elleined.qrcodeapi.service.reader;

import com.google.zxing.NotFoundException;

import java.io.IOException;
import java.util.List;

public interface QrCodeReader {

    // Example: C:\\my-qr-code.png
    String read(String destinationWithFileName)
            throws IOException,
            NotFoundException;

    // Example: C:\\my-qr-code.png
    List<String> readMultiValued(String destinationWithFileName)
            throws NotFoundException,
            IOException;
}
