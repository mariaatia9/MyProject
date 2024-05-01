/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maria.demo;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import model.Address;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author matia
 */
@Controller
@Getter
@Setter
@RequestMapping(path = "/web")

public class FirstMvcController {

    @Autowired
    private MyService myService;
    
    private Person person;

    public FirstMvcController() {
            Person p = new Person("maria", "atia");
        Address a=new Address("berlin","Ulrikenstr");
        p.setAddress(a);
        System.out.println("Controller erstellt!");
    }

    @GetMapping(path = "/start")
    public ModelAndView lp() {
        ModelAndView m = new ModelAndView();
        m.addObject("personen", myService.serviceListe());
        m.setViewName("listperson.xhtml");
        return m;
    }

    @GetMapping(path = "/person")
    public String person(Model m) {
    
        m.addAttribute("person", person);

        return "person.xhtml";
    }
    
    
    
    @GetMapping(path = "/new")
    public String mynew(Model m) {
    
        m.addAttribute("person", new Person());

        return "new.xhtml";
    }
    
@PostMapping(path = "/create")    
public String submitPerson(@ModelAttribute Person p,Model m)
{
    person=p;
    m.addAttribute("person", person);
    return "person.xhtml";
}
}
