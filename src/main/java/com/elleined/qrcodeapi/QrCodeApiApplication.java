package com.elleined.qrcodeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.InvalidPathException;

@SpringBootApplication
public class QrCodeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(QrCodeApiApplication.class, args);
	}

}
