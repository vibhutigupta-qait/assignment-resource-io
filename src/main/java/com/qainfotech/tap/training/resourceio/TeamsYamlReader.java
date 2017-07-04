package com.qainfotech.tap.training.resourceio;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import com.qainfotech.tap.training.resourceio.exceptions.ObjectNotFoundException;
import com.qainfotech.tap.training.resourceio.model.Individual;
import com.qainfotech.tap.training.resourceio.model.Team;
/**
 *
 * @author Ramandeep RamandeepSingh AT QAInfoTech.com
 */
public class TeamsYamlReader{
    
    /**
     * get a list of individual objects from db yaml file
     * 
     * @return 
     */
	  
    Yaml yaml = new Yaml();
    
	
	List<Individual> listindividual = new ArrayList<Individual>();
	List<Individual> active = new ArrayList<Individual>();
	List<Individual> notactive = new ArrayList<Individual>();
	List<Team> teamlist = new ArrayList<Team>();
	public List<Individual> getListOfIndividuals(){
		listindividual.clear();
        //throw new UnsupportedOperationException("Not implemented.");
		Individual obj1;
		
		try {
		     InputStream input = new FileInputStream(new File("src/main/resources/db.yaml"));

		     // Parse the YAML file and return the output as a series of Maps and Lists
		     Map<String,Object> mymap = (Map<String,Object>)yaml.load(input);
		     ArrayList<?> individual = (ArrayList<?>) mymap.get("individuals");
		    // System.out.println(individual.size());
		     for(int i=0;i<individual.size();i++){
		    	
		     Map<String,Object> a= (Map<String, Object>) individual.get(i);
		     Map<String,Object> b = new HashMap<>();
		     b.put("id", a.get("id"));
		     b.put("name", a.get("name"));
		     b.put("active", a.get("active"));
		     obj1 = new Individual(b);
		     listindividual.add(obj1);
		     
		     }
		     
		    



		  } catch (Exception e) {
		     e.printStackTrace();
		  }
		return listindividual;
	    
    }

	 /**
     * get individual object by id
     * 
     * @param id individual id
     * @return 
     * @throws com.qainfotech.tap.training.resourceio.exceptions.ObjectNotFoundException 
     */
    public Individual getIndividualById(Integer id) throws ObjectNotFoundException{
    	 try{
    	    	if(this.getListOfIndividuals()==null)
    	    		this.getListOfIndividuals();
    	        for(int i=0;i<listindividual.size();i++){
    	        	if(listindividual.get(i).getId()==(int)id){
    	        		return listindividual.get(i);
    	        	}
    	        }
    	 }
    	        
    	        catch(Exception e){}
		return null;
        //throw new UnsupportedOperationException("Not implemented.");
}
	
	
    
    /**
     * get individual object by name
     * 
     * @param name
     * @return 
     *@throws com.qainfotech.tap.training.resourceio.exceptions.ObjectNotFoundException 
     */
    public Individual getIndividualByName(String name) throws ObjectNotFoundException{
    	 try
         {
         	if(this.getListOfIndividuals()==null)
         		this.getListOfIndividuals();
        for(int i=0;i<listindividual.size();i++)
        {
     	   if(listindividual.get(i).getName().equals(name))
     	   {
     		   
     		  return listindividual.get(i);
     		   
     	   }
     	   
        }
         }
         catch(Exception e)
         {
        
         }
		return null;
        //throw new UnsupportedOperationException("Not implemented.");
        
    }
    
    
     public List<Individual> getListOfInactiveIndividuals(){
    		try
            {
            	if(this.getListOfIndividuals()==null)
            		this.getListOfIndividuals();
        	
        	for(int i=0;i<listindividual.size();i++){
        		if(listindividual.get(i).isActive()==false)
        		{
        			notactive.add(listindividual.get(i));
        		}
        	
    	
        	}
        	return notactive;
        
        }
        catch(Exception e){
        	
        }
    		
		return notactive;
		
    
    	
    	//throw new ObjectNotFoundException(null, null, null);
}/**

    	
    }
    /**
     * get a list of individual objects who are active
     * 
     * @return List of active individuals object
     */
    public List<Individual> getListOfActiveIndividuals(){
    	try
        {
        	if(this.getListOfIndividuals()==null)
        		this.getListOfIndividuals();
    	
    	
    	for(int i=0;i<listindividual.size();i++){
    		if(listindividual.get(i).isActive()==true){
    			
    			active.add(listindividual.get(i));
    			
    			}
    		}
		}
    	
    catch(Exception e)

    {}
    	return (List<Individual>)active;
		
        //throw new UnsupportedOperationException("Not implemented.");
    }
    
    /**
     * get a list of team objects from db yaml
     * 
     * @return 
     */
    public List<Team> getListOfTeams(){
    	teamlist.clear();
        Team obj1;
		
		try {
		     InputStream input = new FileInputStream(new File("src/main/resources/db.yaml"));

		     // Parse the YAML file and return the output as a series of Maps and Lists
		     Map<String,Object> mymap = (Map<String,Object>)yaml.load(input);
		     List<Team> team  =  (List<Team>) mymap.get("teams");
		    // System.out.println(individual.size());
		     for(int i=0;i<team.size();i++){
		    	 List<Object> memberlist = new ArrayList<>();
				    
		     Map<String,Object> a= (Map<String, Object>) team.get(i);
		     Map<String,Object> b = new HashMap<>();
		     b.put("id", a.get("id"));
		     b.put("name", a.get("name"));
		    
		      ArrayList list = (ArrayList) a.get("members");
		      
		     for(int j=0;j<list.size();j++){
		    	 memberlist.add(this.getIndividualById(Integer.parseInt(list.get(j).toString())));	 
		     }
		     
		     b.put("members", memberlist);
		     
		   
		     
		     obj1 = new Team(b);
		     teamlist.add(obj1);
		     
		     }
		     
		    



		  } catch (Exception e) {
		     e.printStackTrace();
		  }
		return teamlist;
    	
    	
	

    }




	
}