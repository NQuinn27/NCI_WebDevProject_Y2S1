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
    private Style style;
    private int[] packageIds;
    
    public User(String firstName, String lastName, String dob, Sex sex, Style style) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.sex = sex;
        
        this.style = style;
        packageIds = new int[10];
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
    
    public Style getStyle() {
        return style;
    }
    
    public void setStyle(Style style) {
        this.style = style;
    }
    
    
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }
    
    public int getIdentifier() {
        return identifier;
    }
    
    public String JSONRepresentation() {
        String o = "{";
        o = o + "\"firstName\":\"" + firstName + "\",";
        o = o + "\"lastName\":\"" + lastName + "\",";
        o = o + "\"dob\":\"" + dob + "\"";
        o = o + "}";
        return o;
    }
    
    public String XMLRepresentation() {
        String o = "<user>\n";
        o = o + "\t<id>" + 0 + "</id>\n";
        o = o + "\t<firstName>" + firstName + "</firstName>\n";
        o = o + "\t<lastName>" + lastName + "</lastName>\n";
        o = o + "\t<dob>" + dob  + "</dob>\n";
        String sexString = (sex==Sex.MALE) ? "male":"female";
        o = o + "\t<sex>" + sexString + "</sex>\n";
        String styleString = (style==Style.FORMAL) ? "formal":"teen";
        o = o + "\t<sex>" + styleString + "</sex>\n";
        o = o + "</user>";
        return o;
    }
}
