package ru.test.vasileva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.vasileva.domain.HistoryConverterDomain;
import ru.test.vasileva.repo.HistoryConverterRepo;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class HistoryConverterService {
    @Autowired
    HistoryConverterRepo historyConverterRepo;


    public void save(HistoryConverterDomain historyConverterDomain) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(new Date());
        historyConverterDomain.setDate(date);
        historyConverterRepo.save(historyConverterDomain);
    }
}
