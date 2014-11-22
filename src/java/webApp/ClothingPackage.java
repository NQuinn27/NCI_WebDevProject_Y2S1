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

public class ClothingPackage
{
    private ClothingItem topItem;
    private ClothingItem bottomItem;
    private ClothingItem accessoryItem;
    private Sex sex;
    
    public ClothingPackage(ClothingItem topItem, ClothingItem bottomItem, ClothingItem accessoryItem, Sex sex) {
        this.topItem = topItem;
        this.bottomItem = bottomItem;
        this.accessoryItem = accessoryItem;
        this.sex = sex;
    }
    
    public void setTopItem(ClothingItem item) {
        this.topItem = item;
    }
    
    public ClothingItem getTopItem() {
        return topItem;
    }
    
    public void setBottomItem(ClothingItem item) {
        this.bottomItem = item;
    }
    
    public ClothingItem getBottomItem() {
        return this.bottomItem;
    }
    
    public void setAccessoryItem(ClothingItem item) {
        this.accessoryItem = item;
    }
    
    public ClothingItem getAccessoryItem() {
        return this.accessoryItem;
    }
    
    public Sex getSex() {
        return sex;
    }
    
    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
