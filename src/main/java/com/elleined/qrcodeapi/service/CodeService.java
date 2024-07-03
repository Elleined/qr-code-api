package com.elleined.qrcodeapi.service;

import com.google.zxing.WriterException;

import java.awt.image.BufferedImage;

public interface CodeService {
    BufferedImage generate(String text, int width, int height) throws WriterException;
    // Read
}

