package de.openschedule.core.cover;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CoverService {

    private final CoverRepository coverRepository;
    private final Sort sorting = new Sort(Sort.Direction.ASC, "day", "grades", "hours");

    @Autowired
    public CoverService(CoverRepository coverRepository) {
        this.coverRepository = coverRepository;
    }

    private Sort getSorting() {
        return this.sorting;
    }

    public List<Cover> getCoversByDate(LocalDate date) {
        return coverRepository.findByDay(this.getSorting(), date);
    }

    public Cover saveNewCover(Cover cover) {
        return coverRepository.save(cover);
    }
}
