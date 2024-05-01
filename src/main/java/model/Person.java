/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author matia
 */

//wie können diese annotation benutzen um nich set und get zu schreiben
@Setter
@Getter
public class Person {
    private String fname;
    private String lname;
    private Address address;

    public Person() {
         address=new Address();
    }

    public Person(String fname, String lname) {
        this();
        this.fname = fname;
        this.lname = lname;
        
    }
    
    
    
    
}
