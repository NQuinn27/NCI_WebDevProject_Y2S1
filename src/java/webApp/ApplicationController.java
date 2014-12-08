/*
 * Copyright 2014 niallquinn
 * ApplicationController.java created Nov 29, 2014
 * WebDevProject
 */
package webApp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author niallquinn
 */
public class ApplicationController
{
    //Singleton app controller
    private static ApplicationController sharedController;
    
    public static ApplicationController getShared() throws JAXBException {
        if (sharedController == null) {
            sharedController = new ApplicationController();
            sharedController.readUsersFromXML();
            sharedController.readPackagesFromXML();
        }
        return sharedController;
    }
    
    private ArrayList<User> users;
    private ArrayList<ClothingPackage> clothingPackages;
    
    public ApplicationController(){
        this.users = new ArrayList<User>();
        this.clothingPackages = new ArrayList<ClothingPackage>();
    }
    
    public ArrayList<User> getUserList() {
        return users;
    }
    
    public ArrayList<ClothingPackage> getPackagesList() {
        return clothingPackages;
    }
    
    public User getUserById(int id) {
        for (User u : users) {
            if (u.getIdentifier()==id) {
                return u;
            }
        }
        return null;
    }
    
    public ClothingPackage getPackageById(int id){
        return null;
    }
    
    public void readUsersFromXML() throws JAXBException {
        
        users = new ArrayList<>();
        
        File usersFile = new File("/Users/niallquinn/Developer/Java/clothesclub/clothesclub/Assets/Users.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document dom = null;
	try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse("/Users/niallquinn/Developer/Java/clothesclub/clothesclub/Assets/Users.xml");

	}catch(ParserConfigurationException | SAXException | IOException pce) {
	}
        
        //get the root element
	Element docEle = dom.getDocumentElement();

	NodeList nl = docEle.getElementsByTagName("user");
	if(nl != null && nl.getLength() > 0) {
            for(int i = 0 ; i < nl.getLength();i++) {
		//get the user element
		Element el = (Element)nl.item(i);
		//get the User object
		User e = getUser(el);
		users.add(e);
            }
	}
    }
    
    public void readPackagesFromXML() throws JAXBException {
        
        clothingPackages = new ArrayList<>();
        
        File usersFile = new File("/Users/niallquinn/Developer/Java/clothesclub/clothesclub/Assets/Packages.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document dom = null;
	try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse("/Users/niallquinn/Developer/Java/clothesclub/clothesclub/Assets/Packages.xml");

	}catch(ParserConfigurationException | SAXException | IOException pce) {
	}
        
        //get the root element
	Element docEle = dom.getDocumentElement();

	NodeList nl = docEle.getElementsByTagName("package");
	if(nl != null && nl.getLength() > 0) {
            for(int i = 0 ; i < nl.getLength();i++) {
		//get the user element
		Element el = (Element)nl.item(i);
		//get the User object
		ClothingPackage e = getPackage(el);
		clothingPackages.add(e);
            }
	}
    } 
    
    private ClothingPackage getPackage(Element el) {
        
        ClothingPackage clothingPackage = new ClothingPackage();
        
        String month = getTextValue(el,"month");
        String style = getTextValue(el,"style");
        String sex = getTextValue(el,"sex");
        
        NodeList items = el.getElementsByTagName("items");
        if(items != null && items.getLength() > 0) {
            for(int i = 0 ; i < items.getLength();i++) {
		//get the user element
		Element nl = (Element)items.item(i);
		//get the item object
		NodeList packages = nl.getElementsByTagName("clothingItem");
		if(packages != null && packages.getLength() > 0) {
                    for(int j = 0 ; j < packages.getLength();j++) {
                    //get the user element
                        Element cl = (Element)packages.item(j);
                        ClothingItem ci = getClothingItem(cl);
                        
                        switch (ci.getType())
                        {
                            case "topItem":
                                clothingPackage.setTopItem(ci);
                                break;
                            case "shirtItem":
                                clothingPackage.setShirtItem(ci);
                                break;
                            case "trousersItem":
                                clothingPackage.setTrousersItem(ci);
                                break;
                            case "shoes":
                                clothingPackage.setShoes(ci);
                                break;
                            case "accessories":
                                clothingPackage.setAccessoryItem(ci);
                                break;
                        }
                    }
                }
            }
	}
        Sex _sex = ("male".equals(sex)) ? Sex.MALE : Sex.FEMALE;
        clothingPackage.setSex(_sex);
        
        clothingPackage.setMonthWithString(month);
        
        Style _style = ("Formal".equals(style)) ? Style.FORMAL : Style.TEEN;
        clothingPackage.setStyle(_style);
        
        return clothingPackage;
    }
    
    private ClothingItem getClothingItem(Element cl) {
        String type = getTextValue(cl,"type");
	String description = getTextValue(cl,"description");
        String imageUrl = getTextValue(cl,"imageUri");
        ClothingItem item = new ClothingItem();
        item.setDescription(description);
        item.setImageUri(imageUrl);
        item.setType(type);
        return item;
    }
    
    private User getUser(Element el) {
        String firstName = getTextValue(el,"firstName");
	String lastName = getTextValue(el,"lastName");
        String sex = getTextValue(el,"sex");
	String dob = getTextValue(el,"dob");
        String style = getTextValue(el,"style");
        
        System.out.println("Name: " + firstName);
        Sex _sex = ("male".equals(sex)) ? Sex.MALE : Sex.FEMALE;
        Style _style = ("formal".equals(style)) ? Style.FORMAL : Style.TEEN;
	//Create a new User with the value read from the xml nodes
	User e = new User(firstName,lastName,dob,_sex,_style);
	return e;
    }
    
    private String getTextValue(Element ele, String tagName) {
	
        String textVal = null;
        NodeList nl = ele.getElementsByTagName(tagName);
	if(nl != null && nl.getLength() > 0) {
		Element el = (Element)nl.item(0);
		textVal = el.getFirstChild().getNodeValue();
	}

	return textVal;
    }
}
