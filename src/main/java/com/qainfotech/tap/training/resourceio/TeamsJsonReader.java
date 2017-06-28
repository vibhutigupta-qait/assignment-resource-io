package com.qainfotech.tap.training.resourceio;

import com.qainfotech.tap.training.resourceio.exceptions.ObjectNotFoundException;
import com.qainfotech.tap.training.resourceio.model.Individual;
import com.qainfotech.tap.training.resourceio.model.Team;

import java.io.File;
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

/**
 *
 * @author Ramandeep RamandeepSingh AT QAInfoTech.com
 */
public class TeamsJsonReader{
    
    /**
     * get a list of individual objects from db json file
     * 
     * @return 
     */
	List<Individual> listindividuals = new ArrayList<Individual>();
 	List<Team> listteam = new ArrayList<Team>();
	//List<Individual> listname = new ArrayList<Individual>();
	List<Individual>  active = new ArrayList<Individual>();
	List<Individual>  notactive = new ArrayList<Individual>();
	
	
	//public static final String FILE_NAME="/src/main/resources/db.json";
	
	
    public List<Individual> getListOfIndividuals() throws FileNotFoundException, IOException, ParseException{
       // throw new UnsupportedOperationException("Not implemented.");
        
        
        listindividuals.clear();
    	JSONParser s = new JSONParser();
    	
    	
    	JSONObject obj;
    	
   // try{
           obj = (JSONObject) s.parse(new FileReader("src/main/resources/db.json"));
    	//}
    	//catch(org.json.simple.parser.ParseException e)
        //{
    		
    	//}
    	
      // JSONObject jsonObject = (JSONObject) obj;

		
		JSONArray second = (JSONArray) obj.get("individuals");

		Individual obj1;
		JSONObject myobj;

		for (int i = 0; i < second.size(); i++) {

			myobj = (JSONObject) second.get(i);
			
			
			Map<String, Object> mymap  = new HashMap<String, Object>();
			mymap.put("id",myobj.get("id"));
			mymap.put("name",myobj.get("name"));
			mymap.put("active",myobj.get("active"));
			
		    //Object my=	myobj.get("id")+"_"+myobj.get("name")+"_"+myobj.get("active");
			//mymap.put("my",my );
			
			
			obj1=new Individual(mymap);
			listindividuals.add(obj1);
			
		}
		return listindividuals;
		
			        
    }
    
    /**
     * get individual object by id
     * 
     * @param id individual idteamMap.put("members", individualList);
		teamList.add(new Team(teamMap));
     * @return 
     * @throws com.qainfotech.tap.training.resourceio.exceptions.ObjectNotFoundException 
     * @throws ParseException 
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    public Individual getIndividualById(Integer id) throws ObjectNotFoundException{
       // throw new UnsupportedOperationException("Not implemented.");
    try{
    	if(this.getListOfIndividuals()==null)
    		this.getListOfIndividuals();
        for(int i=0;i<listindividuals.size();i++){
        	if(listindividuals.get(i).getId()==(int)id){
        		return listindividuals.get(i);
        	}
        }
    }
    catch(Exception e){
		
    	//Iterator<Individual> itr=indMembers.iterator();
      
    }
    throw new ObjectNotFoundException(null, null, null);
	//return null;
    }
    
    /**
     * get individual object by nameJSONParser a = new JSONParser();
     * 
     * @param name
     * @return 
     * @throws com.qainfotech.tap.training.resourceio.exceptions.ObjectNotFoundException 
     */
    public Individual getIndividualByName(String name) throws ObjectNotFoundException {
       // throw new UnsupportedOperationException("Not implemented.");
        try
        {
        	if(this.getListOfIndividuals()==null)
        		this.getListOfIndividuals();
       for(int i=0;i<listindividuals.size();i++)
       {
    	   if(listindividuals.get(i).getName().equals(name))
    	   {
    		   
    		  return listindividuals.get(i);
    		   
    	   }
    	   
       }
        }
        catch(Exception e)
        {
       
        }
        throw new ObjectNotFoundException(null, null, null);
		//return null;
    }
    
   // Iterator<Individual> itr=indMembers.iterator();
    /**
     * get a list of individual objects who are not active
     * 
     * @return List of inactive individuals object
     */
    public List<Individual> getListOfInactiveIndividuals() throws ObjectNotFoundException{
        //throw new UnsupportedOperationException("Not implemented.");
    	try
        {
        	if(this.getListOfIndividuals()==null)
        		this.getListOfIndividuals();
    	
    	for(int i=0;i<listindividuals.size();i++){
    		if(listindividuals.get(i).isActive()==false)
    		{
    			notactive.add(listindividuals.get(i));
    		}
    	
	
    	}
    	return notactive;
    
    }
    catch(Exception e){
    	throw new ObjectNotFoundException(null, null, null);
    }
		
    
}
    /**
     * get a list of individual objects who are active
     * 
     * @return List of active individuals object
     * @throws ObjectNotFoundException 
     */
    public List<Individual> getListOfActiveIndividuals() {
        //throw new UnsupportedOperationException("Not implemented.");
    	try
        {
        	if(this.getListOfIndividuals()==null)
        		this.getListOfIndividuals();
    	
    	
    	for(int i=0;i<listindividuals.size();i++){
    		if(listindividuals.get(i).isActive()==true){
    			
    			active.add(listindividuals.get(i));
    			
    			
    		}
    	}
		

		//individualList.add(reader.getIndividualById(((Long)memberArray.get(j)).intValue()));
    }
    	
    catch(Exception e)

    {
    	
    	}
    	return (List<Individual>)active;
    	//throw new ObjectNotFoundException(null, null, null);
}/**
    }
     * get a list of team objects from db jsonproperty file of json
     * 
     * @return 
     * @throws ParseException 
     * @throws IOException 
     * @throws FileNotFoundException 
 * @throws ObjectNotFoundException 
     */
    public List<Team> getListOfTeams() {

    	Map<String ,Object> teamMap = new HashMap<>();
    	try
    	{
    	JSONObject jsonFile = (JSONObject) (new JSONParser()).parse(new FileReader("src/main/resources/db.json"));
    	JSONArray teamArray = new JSONArray();
    	teamArray = (JSONArray) jsonFile.get("teams");
    	List<Team>       teamList1       = new ArrayList<>();
    	TeamsJsonReader reader = new TeamsJsonReader();
    	
    	for(int i=0;i<teamArray.size();i++)
    	{

    		List<Individual> individualList1 = new ArrayList<>();
    		
    		JSONObject singleObject = (JSONObject) teamArray.get(i);
    		teamMap.put("name", (Object) singleObject.get("name"));
    		teamMap.put("id", (Object) ((Long) singleObject.get("id")).intValue());
    		
    		JSONArray memberArray = (JSONArray)singleObject.get("members");
    		
    		for(int j=0;j<memberArray.size();j++)
    		{
    			individualList1.add(reader.getIndividualById(((Long)memberArray.get(j)).intValue()));
    	            		
    		}

    		teamMap.put("members", individualList1);
    		teamList1.add(new Team(teamMap));
    		
    	}
    	//System.out.println(teamList1.size()+"yyyyyyyyyyyyyy");
    	return teamList1;
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    		
    	return null;
    	
    	}
}
