package com.elleined.qrcodeapi.config;

import com.google.zxing.oned.Code128Reader;
import com.google.zxing.oned.EAN13Reader;
import com.google.zxing.oned.UPCAReader;
import com.google.zxing.pdf417.PDF417Reader;
import com.google.zxing.qrcode.QRCodeReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CodeReaderConfig {

    @Bean
    public EAN13Reader ean13Reader() {
        return new EAN13Reader();
    }

    @Bean
    public UPCAReader upcaReader() {
        return new UPCAReader();
    }

    @Bean
    public Code128Reader code128Reader() {
        return new Code128Reader();
    }

    @Bean
    public PDF417Reader pdf417Reader() {
        return new PDF417Reader();
    }

    @Bean
    public QRCodeReader qrCodeReader() {
        return new QRCodeReader();
    }
}
