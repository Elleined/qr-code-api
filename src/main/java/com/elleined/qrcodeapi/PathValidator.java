package com.elleined.qrcodeapi;

public interface PathValidator {
    static boolean validate(String path) {
        return path == null || path.isEmpty() || path.isBlank();
    }
}
