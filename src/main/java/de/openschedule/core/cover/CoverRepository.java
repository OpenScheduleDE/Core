package de.openschedule.core.cover;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface CoverRepository extends MongoRepository<Cover, String> {

    List<Cover> findByDay(Sort sort, LocalDate day);

}
