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

public class User
{
        
    private int identifier;
    private String firstName;
    private String lastName;
    private String dob;
    private Sex sex;
    
    public User(String firstName, String lastName, String dob, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.sex = sex;
        this.identifier = IdGenerator.nextId();
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getDob() {
        return dob;
    }
    
    public void setDob(String dob) {
        this.dob = dob;
    }
    
    public Sex getSex() {
        return sex;
    }
    
    public void setSex(Sex sex) {
        this.sex = sex;
    }
    
    public int getIdentifier() {
        return identifier;
    }
    
}
