package ru.test.vasileva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.vasileva.dto.DirectoryCurrency;
import ru.test.vasileva.service.CurrencyService;

import java.util.List;

@RestController
public class CurrencyController {

    private List<DirectoryCurrency> directoryCurrencies;
    @Autowired
    private CurrencyService currencyService;

    @PostMapping("/currency")
    public List<DirectoryCurrency> currency() {
        directoryCurrencies = currencyService.getAll();
        return directoryCurrencies;
    }
}
