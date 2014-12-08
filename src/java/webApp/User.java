/*
 * Copyright 2014 niallquinn
 * User.java created Nov 22, 2014
 * WebDevProject
 */
/**
 *
 * @author niallquinn
 */

package webApp;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User
{
        
    private int identifier;
    private String firstName;
    private String lastName;
    private String dob;
    private Sex sex;
    private Style style;
    private int[] packageIds;
    
    public User(String firstName, String lastName, String dob, Sex sex, Style style) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.sex = sex;
        this.identifier = IdGenerator.nextId();
        this.style = style;
        packageIds = new int[10];
    }
    
    @XmlElement
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @XmlElement
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @XmlElement
    public String getDob() {
        return dob;
    }
    
    public void setDob(String dob) {
        this.dob = dob;
    }
    
    @XmlElement
    public Sex getSex() {
        return sex;
    }
    
    public void setSex(Sex sex) {
        this.sex = sex;
    }
    
    public Style getStyle() {
        return style;
    }
    
    public void setStyle(Style style) {
        this.style = style;
    }
    
    @XmlAttribute
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }
    
    public int getIdentifier() {
        return identifier;
    }
    
    public String JSONRepresentation() {
        String o = "{";
        o = o + "\"firstName\":" + firstName + ",";
        o = o + "\"lastName\":" + lastName + ",";
        o = o + "\"dob\":" + dob + ",";
        o = o + "\"sex\":" + sex;
        o = o + "}";
        return o;
    }
}
