package com.example.webApp1;

import java.util.List;
import java.util.Optional;

import javax.swing.plaf.OptionPaneUI;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.LEAST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlienController {
    @Autowired
    AlienRepo repo;

    @RequestMapping("/")
    public String home() {
        return "home.jsp";
    }

    @RequestMapping("/addAlien")
    public String addAlien(Alien alien) {
        repo.save(alien);
        return "home.jsp";
    }

    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int aid) {
        ModelAndView mv = new ModelAndView("search.jsp");
        Alien alien = repo.findById(aid).orElse(new Alien());

        System.out.println(repo.findByAtech("Java"));
        System.out.println(repo.findByAidGreaterThan(102));
        System.out.println(repo.findByAtechSorted("Java"));

        mv.addObject(alien);
        return mv;
    }

    // @RequestMapping("/aliens")
    // @ResponseBody
    // public String getAliens() {
    // return repo.findAll().toString();
    // }

    // @RequestMapping("/alien/{aid}")
    // @ResponseBody
    // public String getAlien2(@PathVariable("aid") int aid) {
    // return repo.findById(aid).toString();
    // }

    @GetMapping("/aliens")
    @ResponseBody
    public List<Alien> getAliens() {
        return repo.findAll();
    }

    @GetMapping("/alien/{aid}")
    @ResponseBody
    public Optional<Alien> getAlien2(@PathVariable("aid") int aid) {
        return repo.findById(aid);
    }

    @RequestMapping("/delAlien")
    public ModelAndView delAlien(@RequestParam int aid) {
        ModelAndView mv = new ModelAndView("delete.jsp");
        repo.deleteById(aid);
        return mv;
    }

    @DeleteMapping("/alien/{aid}")
    public String deleteAlien(@PathVariable int aid) {
        repo.deleteById(aid);
        return "Deleted";
    }

    @PostMapping(path = "/alien", consumes = { "application/json" })
    public Alien addAlien2(@RequestBody Alien alien) {
        repo.save(alien);
        return alien;
    }

    @PutMapping(path = "/alien", consumes = { "application/json" })
    public Alien saveOrupdateAlien2(@RequestBody Alien alien) {
        repo.save(alien);
        return alien;
    }

    @RequestMapping("/delAlien2")
    public ModelAndView delAlien2(@RequestParam int aid) {
        ModelAndView mv = new ModelAndView("update.jsp");
        repo.deleteById(aid);
        return mv;
    }

    @RequestMapping("/updateAlien")
    public ModelAndView updateAlien(Alien alien) {
        ModelAndView mv = new ModelAndView("home.jsp");
        repo.save(alien);
        return mv;
    }
}
