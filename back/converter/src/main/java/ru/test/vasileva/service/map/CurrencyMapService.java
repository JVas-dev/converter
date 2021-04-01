package ru.test.vasileva.service.map;

import org.springframework.stereotype.Service;
import ru.test.vasileva.domain.DailyCoursesDomain;
import ru.test.vasileva.dto.DirectoryCurrency;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyMapService {

    public List<DirectoryCurrency> saveAllDirectoryCurrencyDomain(List<DailyCoursesDomain> dailyCoursesDomains) {
        return (dailyCoursesDomains
                .stream()
                .map(this::convertToDirectoryCurrencyDomain)
                .collect(Collectors.toList()));
    }

    private DirectoryCurrency convertToDirectoryCurrencyDomain(DailyCoursesDomain dailyCoursesDomain) {
        DirectoryCurrency directoryCurrency = new DirectoryCurrency();
        directoryCurrency.setName(dailyCoursesDomain.getName());
        return directoryCurrency;
    }
}
