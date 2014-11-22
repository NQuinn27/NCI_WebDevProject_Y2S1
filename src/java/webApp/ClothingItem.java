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
    private String title;
    private String type;
    private String style;
    private String colour;
    
    public String getImageUri() {
        return imageUri;
    }
    
    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }
    
    public void setStyle(String style) {
        this.style = style;
    }
    
    public String getStyle() {
        return style;
    }
    
    public void setColour(String colour) {
        this.colour = colour;
    }
    
    public String getColour() {
        return colour;
    }
}
