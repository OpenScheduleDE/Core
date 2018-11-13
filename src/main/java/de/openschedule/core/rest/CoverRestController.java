package de.openschedule.core.rest;

import de.openschedule.core.database.Cover;
import de.openschedule.core.database.CoverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/cover")
public class CoverRestController {

    private final CoverRepository coverRepository;
    private final Sort sorting = new Sort(Sort.Direction.ASC, "day", "grades", "hours");

    @Autowired
    public CoverRestController(final CoverRepository coverRepository) {
        this.coverRepository = coverRepository;
    }

    @RequestMapping("/today")
    public List<Cover> listTodayCovers() {
        return coverRepository.findByDay(sorting, LocalDate.now());
    }

    @RequestMapping("/tomorrow")
    public List<Cover> listTomorrowCovers() {
        return coverRepository.findByDay(sorting, LocalDate.now().plusDays(1));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Cover addCover(@RequestBody Cover cover) {
        return coverRepository.save(cover);
    }
}
