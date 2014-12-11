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
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Database;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.base.*;
/**
 *
 * @author niallquinn
 */
public class ApplicationController
{
    //Singleton app controller
    private static ApplicationController sharedController;
    
    public static ApplicationController getShared() throws JAXBException, ClassNotFoundException {
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
    
    public void addUser(User u) throws TransformerConfigurationException {
        users.add(u);
        writeStateToXML();
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
    
    public void readUsersFromXML() throws JAXBException, ClassNotFoundException {
        
        users = new ArrayList<>();

        String URI = "xmldb:exist://localhost:8444/exist/xmlrpc";
        String driver = "org.exist.xmldb.DatabaseImpl";

        XMLResource res = null;
        Node resNode = null;
//        File usersFile = new File("/Users/niallquinn/Developer/Java/clothesclub/clothesclub/Assets/Users.xml");
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document dom = null;
        
        try {
            Class cl = Class.forName(driver);
            Database database = (Database) cl.newInstance();
            DatabaseManager.registerDatabase(database);

            // get the collection
            Collection col = (Collection) DatabaseManager.getCollection(URI + "/db/clothesclub", "admin", "");


            col.setProperty(OutputKeys.INDENT, "no");
            res = (XMLResource)col.getResource("Users.xml");

            resNode = res.getContentAsDOM();

            dom = (Document) resNode;
        }catch (Exception e) {
            System.err.println("Error Document: "+e.getMessage());
        }
        
        if (dom == null) {
            return;
        }
        //get the root element
	Element docEle = dom.getDocumentElement();

	NodeList nl = docEle.getElementsByTagName("user");
        int len = nl.getLength();
	if(nl != null && nl.getLength() > 0) {
            for(int i = 0 ; i < nl.getLength() ; i++) {
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
        
//        File usersFile = new File("/Users/niallquinn/Developer/Java/clothesclub/clothesclub/Assets/Packages.xml");
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        Document dom = null;
//	try {
//            DocumentBuilder db = dbf.newDocumentBuilder();
//            dom = db.parse("/Users/niallquinn/Developer/Java/clothesclub/clothesclub/Assets/Packages.xml");
//
//	}catch(ParserConfigurationException | SAXException | IOException pce) {
//	}
        
        String URI = "xmldb:exist://localhost:8444/exist/xmlrpc";
        String driver = "org.exist.xmldb.DatabaseImpl";

        XMLResource res = null;
        Node resNode = null;
//        File usersFile = new File("/Users/niallquinn/Developer/Java/clothesclub/clothesclub/Assets/Users.xml");
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document dom = null;
        
        try {
            Class cl = Class.forName(driver);
            Database database = (Database) cl.newInstance();
            DatabaseManager.registerDatabase(database);

            // get the collection
            Collection col = (Collection) DatabaseManager.getCollection(URI + "/db/clothesclub", "admin", "");


            col.setProperty(OutputKeys.INDENT, "no");
            res = (XMLResource)col.getResource("Packages.xml");
             
            resNode = res.getContentAsDOM();

            dom = (Document) resNode;
        }catch (Exception e) {
            System.err.println("Error Document: "+e.getMessage());
        }
        
        if (dom == null) {
            return;
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
    
    public void writeStateToXML() throws TransformerConfigurationException {
        try {
 
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("users");
		doc.appendChild(rootElement);
 
                for (User u : users) {
                    Element user = doc.createElement("user");
                    rootElement.appendChild(user);
                    
                    Element firstname = doc.createElement("firstName");
                    firstname.appendChild(doc.createTextNode(u.getFirstName()));
                    user.appendChild(firstname);
                    
                    Element lastName = doc.createElement("lastName");
                    lastName.appendChild(doc.createTextNode(u.getLastName()));
                    user.appendChild(lastName);
                    
                    Element dob = doc.createElement("dob");
                    if (u.getDob()!=null) {
                        dob.appendChild(doc.createTextNode(u.getDob()));
                    } else {
                        dob.appendChild(doc.createTextNode("dd/mm/yyyy"));
                    }
                    user.appendChild(dob);
                    
                    String sexString = (u.getSex()==Sex.MALE) ? "male":"female";
                    Element sex = doc.createElement("sex");
                    sex.appendChild(doc.createTextNode(sexString));
                    user.appendChild(sex);
                    
                    String styleString = (u.getStyle()==Style.FORMAL) ? "formal":"teen";
                    Element style = doc.createElement("style");
                    style.appendChild(doc.createTextNode(styleString));
                    user.appendChild(style);
                }
 
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
                
                String URI = "xmldb:exist://localhost:8444/exist/xmlrpc";
                String driver = "org.exist.xmldb.DatabaseImpl";

                XMLResource res = null;
                Node resNode = null;
                Document dom = null;

                try {
                    Class cl = Class.forName(driver);
                    Database database = (Database) cl.newInstance();
                    DatabaseManager.registerDatabase(database);

                    // get the collection
                    Collection col = (Collection) DatabaseManager.getCollection(URI + "/db/clothesclub", "admin", "");


                    col.setProperty(OutputKeys.INDENT, "no");
                    res = (XMLResource)col.getResource("Users.xml");

                    res.setContentAsDOM(doc);

                    col.storeResource(res);
                }catch (Exception e) {
                    System.err.println("Error Document: "+e.getMessage());
                }
                        System.out.println("File saved!");

                  } catch (ParserConfigurationException pce) {
                  } catch (TransformerException tfe) {
                }
	
    }

    private Object getServletContext()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
