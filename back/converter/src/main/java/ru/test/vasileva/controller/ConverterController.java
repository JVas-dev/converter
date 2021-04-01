package ru.test.vasileva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.vasileva.service.ConverterService;

@RestController
public class ConverterController {

    @Autowired
    private ConverterService converterService;

    @PostMapping("/converter")
    public Double getCurrency(String sourceName, String targetName, Double sourceValue) {
        converterService.getAll();

        return converterService.converter(sourceName, targetName, sourceValue);
    }
}
