package com.elleined.qrcodeapi.service.generator;

import com.google.zxing.WriterException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class QrCodeGeneratorImplTest {

    @Test
    void singleValuedGenerateQrCode() throws IOException, WriterException {
        // Expected Value

        // Mock data
        QrCodeGenerator qrCodeGenerator = new QrCodeGeneratorImpl();

        // Set up method
        qrCodeGenerator.generateSingleValuedQrCode("My Data", 500, 500, "./src/test/resources/images/my-single-valued-qr-code.jpg");

        // Stubbing methods

        // Calling the method

        // Behavior Verifications

        // Assertions
    }

    @Test
    void multiValuedGenerateQrCode() throws IOException, WriterException {
        // Expected Value

        // Mock data
        QrCodeGenerator qrCodeGenerator = new QrCodeGeneratorImpl();
        List<String> dataList = List.of("Data 1", "Data 2");

        // Set up method
        qrCodeGenerator.generateMultiValuedQrCode(dataList, 500, 500, "./src/test/resources/images/my-multi-valued-qr-code.jpg");

        // Stubbing methods

        // Calling the method

        // Behavior Verifications

        // Assertions
    }
}