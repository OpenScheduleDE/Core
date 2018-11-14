package de.openschedule.core.cover;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/cover")
public class CoverRestController {

    private final CoverService service;

    @Autowired
    public CoverRestController(final CoverService service) {
        this.service = service;
    }

    @RequestMapping("/today")
    public List<Cover> listTodayCovers() {
        return service.getCoversByDate(LocalDate.now());
    }

    @RequestMapping("/tomorrow")
    public List<Cover> listTomorrowCovers() {
        return service.getCoversByDate(LocalDate.now().plusDays(1));
    }

    @RequestMapping("/{date}")
    public List<Cover> listCoversByDate(@PathVariable LocalDate date) {
        return service.getCoversByDate(date);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Cover addCover(@RequestBody Cover cover) {
        return service.saveNewCover(cover);
    }
}
