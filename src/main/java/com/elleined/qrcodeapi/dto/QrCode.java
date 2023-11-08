package com.elleined.qrcodeapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QrCode {
    @NotBlank(message = "File path is blank, null, or empty. Please specify the correct file path example: C://")
    private String filePath;

    @NotBlank(message = "File name is blank, null, or empty. Please specify the correct file name example: your-qrcode")
    private String fileName;

    @NotBlank(message = "Image format is blank, null, or empty. Please specify the correct image format example: jpg")
    private String imageFormat;
}
