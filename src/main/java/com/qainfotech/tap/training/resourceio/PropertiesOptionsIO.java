package com.qainfotech.tap.training.resourceio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author Ramandeep RamandeepSingh AT QAInfoTech.com
 */
public class PropertiesOptionsIO{
    
    public Object getOptionValue(String optionKey) throws IOException {
    	
    	//File f new File("src/main/resources/options.properties");
    	Properties property = new Properties();
    	InputStream input = null;
    	Object obj = null;
    	
    	//File file = new File("src/main/resources/db.json");
    	 try {
    	     property.load(new FileInputStream("src/main/resources/options.properties"));
    	  } catch (IOException e) {
    	  }
    	
    	 obj=property.getProperty(optionKey);
		return obj;
        //throw new UnsupportedOperationException("Not implemented.");
        
        
        
        
        
        
    }

    public void addOption(String optionKey, Object optionValue) throws IOException {
       // throw new UnsupportedOperationException("Not implemented.");
        
      Properties property = new Properties(); 
      OutputStream output=null;
      Object obj =null;
      
      try {
	      property.load(new FileInputStream("src/main/resources/options.properties"));
	  } catch (IOException e) {
		 
	  }
      obj=property.setProperty(optionKey, optionValue.toString());
	  property.store(new FileOutputStream(("src/main/resources/options.properties"), true), optionKey);
	 
      
      //property.store(new FileOutputStream("optionkey"), optionValue);
}
}
