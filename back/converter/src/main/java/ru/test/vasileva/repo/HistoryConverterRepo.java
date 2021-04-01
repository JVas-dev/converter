package ru.test.vasileva.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.test.vasileva.domain.HistoryConverterDomain;

import java.util.List;

public interface HistoryConverterRepo extends JpaRepository<HistoryConverterDomain, Long> {
    List<HistoryConverterDomain> findAll();

    @Query(value = "select * from history_converter where source_name = ?1 and target_name = ?2 and date = ?3", nativeQuery = true)
    List<HistoryConverterDomain> findBySourceNameAndTargetNameAndDate(String sourceName, String targetName, String date);

    @Query(value = "select * from history_converter where source_name = ?1 and target_name = ?2", nativeQuery = true)
    List<HistoryConverterDomain> findBySourceNameAndTargetName(String sourceName, String targetName);

    List<HistoryConverterDomain> findBySourceName(String sourceName);

    @Query(value = "select * from history_converter where source_name = ?1  and date = ?2", nativeQuery = true)
    List<HistoryConverterDomain> findBySourceNameAndDate(String sourceName, String date);

    @Query(value = "select * from public.history_converter where  target_name = ?1 and date = ?2", nativeQuery = true)
    List<HistoryConverterDomain> findByTargetNameAndDate(String targetName, String date);

    List<HistoryConverterDomain> findByTargetName(String targetName);

    List<HistoryConverterDomain> findByDate(String date);
}
