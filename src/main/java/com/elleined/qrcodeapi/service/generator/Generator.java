package com.elleined.qrcodeapi.service.generator;

import java.awt.image.BufferedImage;

public interface Generator {
    BufferedImage generate(String text, int width, int height);
}

