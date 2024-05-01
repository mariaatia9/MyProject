/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maria.demo;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import model.Address;
import model.Person;
import org.springframework.stereotype.Service;

/**
 *
 * @author matia
 */
@Service
public class MyService {

    

    public MyService() {
       
        System.out.println("Service initialisiert!");
    }

    public List<Person> serviceListe() {
       List<Person> personenListe = new ArrayList<>();
            Faker f = new Faker(new Locale("de"));
            for (int i = 0; i < 8; i++) {
                Person p = new Person(f.address().firstName(), f.address().lastName());
                Address a = new Address(f.address().cityName(), f.address().streetName());
                p.setAddress(a);
                personenListe.add(p);
            }
        
       
        return personenListe;
    }

}
