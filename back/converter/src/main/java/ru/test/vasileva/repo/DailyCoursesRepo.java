package ru.test.vasileva.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.vasileva.domain.DailyCoursesDomain;

import java.util.List;

public interface DailyCoursesRepo extends JpaRepository<DailyCoursesDomain, Long> {
    List<DailyCoursesDomain> findByDate(String date);

    List<DailyCoursesDomain> findAll();

    DailyCoursesDomain findByName(String name);
}
