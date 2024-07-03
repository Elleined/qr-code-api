package com.elleined.qrcodeapi.config;

import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.oned.UPCAWriter;
import com.google.zxing.pdf417.PDF417Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CodeWriterConfig {

    @Bean
    public EAN13Writer ean13Writer() {
        return new EAN13Writer();
    }

    @Bean
    public UPCAWriter upcaWriter() {
        return new UPCAWriter();
    }

    @Bean
    public Code128Writer code128Writer() {
        return new Code128Writer();
    }

    @Bean
    public PDF417Writer pdf417Writer() {
        return new PDF417Writer();
    }

    @Bean
    public QRCodeWriter qrCodeWriter() {
        return new QRCodeWriter();
    }
}
