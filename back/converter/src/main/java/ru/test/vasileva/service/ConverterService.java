package ru.test.vasileva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.test.vasileva.domain.DailyCoursesDomain;
import ru.test.vasileva.repo.DailyCoursesRepo;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ConverterService {
    @Autowired
    DailyCoursesRepo dailyCoursesRepo;
    @Autowired
    ParseCoursesXmlService parseCoursesXmlService;
    List<DailyCoursesDomain> dailyCoursesDomains;

    @Value("${cbr.courses.uri}")
    private String coursesUri;

    @PostConstruct
    public void init() {
        getAll();
    }


    public void getAll() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String date = simpleDateFormat.format(new Date());
        dailyCoursesDomains = dailyCoursesRepo.findByDate(simpleDateFormat.format(new Date()));
        if (dailyCoursesDomains.size() == 0) {
            dailyCoursesRepo.deleteAll();
            dailyCoursesDomains = parseCoursesXmlService.parseXml(coursesUri.concat(date));
        }
    }

    public Double converter(String sourceName, String targetName, Double sourceValue) {
        DailyCoursesDomain dailyCoursesDomain1 = dailyCoursesRepo.findByName(sourceName);
        DailyCoursesDomain dailyCoursesDomain2 = dailyCoursesRepo.findByName(targetName);

        Double fromCurrencyToRuble = Double.parseDouble(dailyCoursesDomain1.getValue().replace(',', '.')) / dailyCoursesDomain1.getNominal();
        Double toCurrencyToRuble = Double.parseDouble(dailyCoursesDomain2.getValue().replace(',', '.')) / dailyCoursesDomain2.getNominal();
        double aDouble = ((fromCurrencyToRuble / toCurrencyToRuble * sourceValue) * 100) / 100;
        return BigDecimal.valueOf(aDouble).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
