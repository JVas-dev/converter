package ru.test.vasileva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.vasileva.domain.HistoryConverterDomain;
import ru.test.vasileva.repo.HistoryConverterRepo;

import java.util.List;

@Service
public class TableHistoryService {
    @Autowired
    HistoryConverterRepo historyConverterRepo;

    public List<HistoryConverterDomain> findAll() {
        return historyConverterRepo.findAll();
    }

    public List<HistoryConverterDomain> filter(String sourceName, String targetName, String date) {

        if (!sourceName.equals("null") && !targetName.equals("null") && !date.equals("null")) {
            return historyConverterRepo.findBySourceNameAndTargetNameAndDate(sourceName, targetName, date);
        } else if (!sourceName.equals("null") && !targetName.equals("null")) {
            return historyConverterRepo.findBySourceNameAndTargetName(sourceName, targetName);
        } else if (!sourceName.equals("null") && !date.equals("null")) {
            return historyConverterRepo.findBySourceNameAndDate(sourceName, date);
        } else if (!sourceName.equals("null")) {
            return historyConverterRepo.findBySourceName(sourceName);
        } else if (!targetName.equals("null") && !date.equals("null")) {
            return historyConverterRepo.findByTargetNameAndDate(targetName, date);
        } else if (!targetName.equals("null")) {
            return historyConverterRepo.findByTargetName(targetName);
        } else if (!date.equals("null")) {
            return historyConverterRepo.findByDate(date);
        } else return findAll();
    }
}
