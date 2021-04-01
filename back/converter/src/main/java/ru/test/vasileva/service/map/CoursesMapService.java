package ru.test.vasileva.service.map;

import org.springframework.stereotype.Service;
import ru.test.vasileva.domain.DailyCoursesDomain;
import ru.test.vasileva.dto.CurrCourses;
import ru.test.vasileva.dto.Currency;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoursesMapService {
    private String date;

    public List<DailyCoursesDomain> saveAllDailyCoursesDomain(CurrCourses currCourses) {
        date = currCourses.getDate();
        return currCourses.getCurrency()
                .stream()
                .map(this::convertToDailyCoursesDomain)
                .collect(Collectors.toList());
    }

    private DailyCoursesDomain convertToDailyCoursesDomain(Currency currencies) {
        DailyCoursesDomain dailyCoursesDomain = new DailyCoursesDomain();
        dailyCoursesDomain.setDate(date);
        dailyCoursesDomain.setNumCode(currencies.getNumCode());
        dailyCoursesDomain.setCharCode(currencies.getCharCode());
        dailyCoursesDomain.setNominal(currencies.getNominal());
        dailyCoursesDomain.setName(currencies.getName());
        dailyCoursesDomain.setValue(currencies.getValue());
        return dailyCoursesDomain;
    }
}
