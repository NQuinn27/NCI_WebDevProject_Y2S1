/*
 * Copyright 2014 niallquinn
 * ClothingPackage.java created Nov 22, 2014
 * WebDevProject
 */
/**
 *
 * @author niallquinn
 */
package webApp;

public class ClothingPackage implements Comparable<ClothingPackage>
{
    private ClothingItem topItem;
    private ClothingItem trousersItem;
    private ClothingItem shirtItem;
    private ClothingItem shoes;
    private ClothingItem accessories;
    private Sex sex;
    private int month;
    private Style style;
    
    
    public ClothingPackage(){}
    
    public ClothingPackage(ClothingItem topItem, 
                            ClothingItem trousersItem, 
                            ClothingItem accessories,
                            ClothingItem shirtItem,
                            ClothingItem shoes,
                            Sex sex, 
                            int month, 
                            Style style) {
        this.topItem = topItem;
        this.trousersItem = trousersItem;
        this.accessories = accessories;
        this.shirtItem = shirtItem;
        this.shoes = shoes;
        this.sex = sex;
        this.month = month;
        this.style = style;
    }
    
    public void setMonthWithString(String monthString) {
        if (null != monthString)switch (monthString)
        {
            case "January":
                month = Month.JAN;
                break;
            case "February":
                month = Month.FEB;
                break;
            case "March":
                month = Month.MAR;
                break;
            case "April":
                month = Month.APR;
                break;
            case "May":
                month = Month.MAY;
                break;
            case "June":
                month = Month.JUN;
                break;
            case "July":
                month = Month.JUL;
                break;
            case "August":
                month = Month.AUG;
                break;
            case "September":
                month = Month.SEP;
                break;
            case "October":
                month = Month.OCT;
                break;
            case "November":
                month = Month.NOV;
                break;
            case "December":
                month = Month.DEC;
                break;
        }
    }
    
    public void setStyle(Style style) {
        this.style = style;
    }
    
    public Style getStyle() {
        return style;
    }
    
    public void setTopItem(ClothingItem item) {
        this.topItem = item;
    }
    
    public ClothingItem getTopItem() {
        return topItem;
    }
    
    public void setShoes(ClothingItem item) {
        this.shoes = item;
    }
    
    public ClothingItem getShoes() {
        return shoes;
    }
    
    public void setShirtItem(ClothingItem item) {
        this.shirtItem = item;
    }
    
    public ClothingItem getShirtItem() {
        return shirtItem;
    }
    
    public void setTrousersItem(ClothingItem item) {
        this.trousersItem = item;
    }
    
    public ClothingItem getTrousersItem() {
        return this.trousersItem;
    }
    
    public void setAccessoryItem(ClothingItem item) {
        this.accessories = item;
    }
    
    public ClothingItem getAccessoryItem() {
        return this.accessories;
    }
    
    public Sex getSex() {
        return sex;
    }
    
    public void setSex(Sex sex) {
        this.sex = sex;
    }
    
    public int getMonth() {
        return month;
    }

    @Override
    public int compareTo(ClothingPackage o)
    {
        return (this.month > o.getMonth()) ? 1 : 0;
    }
}
