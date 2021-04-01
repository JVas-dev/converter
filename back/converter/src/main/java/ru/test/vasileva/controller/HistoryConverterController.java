package ru.test.vasileva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.vasileva.domain.HistoryConverterDomain;
import ru.test.vasileva.service.HistoryConverterService;

@RestController
public class HistoryConverterController {
    @Autowired
    HistoryConverterService historyConverterService;

    @PostMapping("/history")
    public void history(HistoryConverterDomain historyConverterDomain) {
        historyConverterService.save(historyConverterDomain);
    }
}
