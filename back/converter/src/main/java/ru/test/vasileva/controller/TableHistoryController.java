package ru.test.vasileva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.vasileva.domain.HistoryConverterDomain;
import ru.test.vasileva.service.TableHistoryService;

import java.util.List;

@RestController
public class TableHistoryController {
    @Autowired
    TableHistoryService tableHistoryService;

    @PostMapping("/table_history")
    public List<HistoryConverterDomain> tableHistory() {

        return tableHistoryService.findAll();
    }

    @PostMapping("/table_history_filter")
    public List<HistoryConverterDomain> filer(String sourceName, String targetName, String date) {
        return tableHistoryService.filter(sourceName, targetName, date);
    }
}
