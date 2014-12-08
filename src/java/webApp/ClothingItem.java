/*
 * Copyright 2014 niallquinn
 * ClothingItem.java created Nov 22, 2014
 * WebDevProject
 */
/**
 *
 * @author niallquinn
 */

package webApp;

public class ClothingItem
{
    private String imageUri;
    private String description;
    private String type;
    
    public ClothingItem(){}
    
    public String getImageUri() {
        return imageUri;
    }
    
    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }
    
}
