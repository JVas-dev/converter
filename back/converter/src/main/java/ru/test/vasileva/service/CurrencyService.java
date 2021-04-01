package ru.test.vasileva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.vasileva.domain.DailyCoursesDomain;
import ru.test.vasileva.dto.DirectoryCurrency;
import ru.test.vasileva.repo.DailyCoursesRepo;
import ru.test.vasileva.service.map.CurrencyMapService;

import java.util.List;

@Service
public class CurrencyService {
    @Autowired
    DailyCoursesRepo dailyCoursesRepo;
    @Autowired
    CurrencyMapService currencyMapService;

    List<DailyCoursesDomain> dailyCoursesDomains;
    List<DirectoryCurrency> directoryCurrencies;

    public List<DirectoryCurrency> getAll() {
        dailyCoursesDomains = dailyCoursesRepo.findAll();
        directoryCurrencies = currencyMapService.saveAllDirectoryCurrencyDomain(dailyCoursesDomains);
        return directoryCurrencies;
    }

}
