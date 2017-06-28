package com.qainfotech.tap.training.resourceio.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.qainfotech.tap.training.resourceio.TeamsJsonReader;

/**
 *
 * @author Ramandeep RamandeepSingh AT QAInfoTech.com
 */
public class Team {
   
	
	TeamsJsonReader teamjsonreader = new TeamsJsonReader();
   
    private final String name;
    private final Integer id;
    private final List<Individual> members;
    
    
    
    public Team(Map<String, Object> teamMap) throws FileNotFoundException, IOException, ParseException{
        //throw new UnsupportedOperationException("Not implemented.");
    	Map<String, Object> myMap = teamMap;
    	
        this.name = myMap.get("name").toString();
        this.id = Integer.parseInt(myMap.get("id").toString());
        this.members = (List<Individual>) teamMap.get("members");
        
       
        	}
        
        
        //members = Boolean.parseBoolean(myMap.get("members").toString());
        
    
    
   // public Team(Object object, Object object2, Object object3) {
		// TODO Auto-generated constructor stub
	//}

	/**
     * get team name
     * 
     * @return 
     */
   
    
    
    public String getName(){
        return name;
    }
    
    /**
     * get team id
     * 
     * @return 
     */
    public Integer getId(){
        return id;
    }
    
    
    
    /** 
     * get list of individuals that are members of this team
     * 
     * @return 
     */
   
    //List<Individual> mynewlist = new ArrayList<Individual>();
    
    public List<Individual> getMembers() throws FileNotFoundException, IOException, ParseException{
    	
    	
    	
    	
		return members;
    	
    					
    					}
    			
    	
    
    
    /**
     * get a list of individuals that are members of this team and are also active
     * 
     * @return 
     * @throws ParseException 
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    public List<Individual> getActiveMembers() throws FileNotFoundException, IOException, ParseException{
    	List<Individual> individualList;
		List<Individual> activeIndividualList = new ArrayList<>();

		individualList = this.getMembers();
		System.out.println(individualList.size());
		for (Individual e : individualList) {
			if (e.isActive().compareTo(true) == 0)
				activeIndividualList.add(e);
		}

		return activeIndividualList;

    	
    	
    	
  
    		
    		
    		
    		
    	
       // throw new UnsupportedOperationException("Not implemented.");
        
  }
    
    
    public static void main(String... S)
    {
   
    	
    	
    }
        
    /**
     * get a list of individuals that are members of this team but are inactive
     * 
     * @return 
     * @throws ParseException 
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    public List<Individual> getInactiveMembers() throws FileNotFoundException, IOException, ParseException{
        //throw new UnsupportedOperationException("Not implemented.");
    	List<Individual> individualList;
		List<Individual> inactiveIndividualList = new ArrayList<>();

		individualList = this.getMembers();

		for (Individual e : individualList) {
			if (e.isActive().compareTo(false) == 0)
				inactiveIndividualList.add(e);

		}

		return inactiveIndividualList;
    }
}
