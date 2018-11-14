package de.openschedule.core.cover;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
public class CoverController {

    private final CoverService service;

    @Autowired
    public CoverController(CoverService service) {
        this.service = service;
    }

    @RequestMapping({"/", "/today", "/heute"})
    public ModelAndView listAllCoversToday() {
        return listAllCoversForDate(LocalDate.now());
    }

    @RequestMapping({"/tomorrow", "/morgen"})
    public ModelAndView listAllCoversForTomorrow() {
        return listAllCoversForDate(LocalDate.now().plusDays(1));
    }

    @RequestMapping("/{date}")
    public ModelAndView listAllCoversForDate(@PathVariable LocalDate date) {
        ModelAndView model = new ModelAndView("list");

        model.addObject("day", date);
        model.addObject("covers", service.getCoversByDate(date));

        return model;
    }

}
