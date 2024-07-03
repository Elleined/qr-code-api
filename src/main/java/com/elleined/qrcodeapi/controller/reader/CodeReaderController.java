package com.elleined.qrcodeapi.controller.reader;

import com.elleined.qrcodeapi.service.CodeService;
import com.google.zxing.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class CodeReaderController {


    @GetMapping("/read")
    public String read(@RequestParam("source") String source) throws NotFoundException, IOException {
        return CodeService.read(source);
    }
}
