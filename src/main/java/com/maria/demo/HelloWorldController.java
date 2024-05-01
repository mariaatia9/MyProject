/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maria.demo;

import java.util.ArrayList;
import java.util.List;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author matia
 */



/*
There are five types of spring bean scopes:

1-singleton - only one instance of the spring bean will be created for the spring container.This is the default spring bean scope.
     While using this scope, make sure bean doesn’t have shared instance variables otherwise it might lead to data inconsistency issues.
2-prototype – A new instance will be created every time the bean is requested from the spring container.
3-request – This is same as prototype scope, however it’s meant to be used for web applications. A new instance of the bean will be created for each HTTP request.
4-session – A new bean will be created for each HTTP session by the container.
5-global-session – This is used to create global session beans for Portlet applications.*/
@RestController
@Scope(scopeName = "session")
@RequestMapping(path = "/api")
public class HelloWorldController {

    private List<Person> personenListe;
    @Autowired
    private MyService myService;

    public HelloWorldController() {
        personenListe = new ArrayList<>();
        System.out.println("Mein Restcontroller wurde instantiiert!");
        
        

    }

    public HelloWorldController(MyService myServices) {
        this();
        this.myService = myServices;
    }

    public List<Person> getPersonenListe() {
         if(personenListe.isEmpty()){
            personenListe=myService.serviceListe();
        }
        return personenListe;
    }

    public void setPersonenListe(List<Person> personenListe) {
        this.personenListe = personenListe;
    }
      
    @GetMapping(path = "/greeting")
    public String doSomething(){
        return "<h2>Hallo Spring Boot World</h2>";
    }
    
    
    
    
     @GetMapping(path = "/greet")
    public String doSomething1(){
        return "Hallo Spring Boot World 2";
    }
    
    @GetMapping(path="/person")
    public Person takePerson(){
        Person p=new Person("Hans","Musterman");
        
        return p;
    }
    
    @GetMapping(path="/liste")
    public List<Person> listPerson(){
        
        return getPersonenListe();
    }

}
