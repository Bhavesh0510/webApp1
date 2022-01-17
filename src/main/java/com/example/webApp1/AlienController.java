package com.example.webApp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        mv.addObject(alien);
        return mv;
    }

    @RequestMapping("/delAlien")
    public ModelAndView delAlien(@RequestParam int aid) {
        ModelAndView mv = new ModelAndView("delete.jsp");
        repo.deleteById(aid);
        return mv;
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
