package com.elleined.qrcodeapi.service.reader;

import com.google.zxing.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class QrCodeReaderImplTest {

    @Test
    void read() throws NotFoundException, IOException {
        // Expected Value
        QrCodeReader qrCodeReader = new QrCodeReaderImpl();

        // Mock data
        String returnedData = qrCodeReader.readSingleValued("./src/test/resources/images/my-single-valued-qr-code.jpg");

        // Set up method

        // Stubbing methods

        // Calling the method

        // Behavior Verifications

        // Assertions
        assertNotNull(returnedData, "If this test is failing there are 2 possible reasons. the provided path or the qr code code are not yet generated");
    }

    @Test
    void readMultiValued() throws NotFoundException, IOException {
// Expected Value
        QrCodeReader qrCodeReader = new QrCodeReaderImpl();

        // Mock data
        List<String> returnedData = qrCodeReader.readMultiValued("./src/test/resources/images/my-multi-valued-qr-code.jpg");

        // Set up method

        // Stubbing methods

        // Calling the method

        // Behavior Verifications
        // Assertions
        assertFalse(returnedData.isEmpty(), "If this test is failing there are 2 possible reasons. the provided path or the qr code code are not yet generated");
        assertNotNull(returnedData, "If this test is failing there are 2 possible reasons. the provided path or the qr code code are not yet generated");
    }
}