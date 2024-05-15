import java.util.*;
import ou.*;

/**
 * A class which simulates a film sharing group
 * 
 * @author M250 Andrew Redford
 * @version 1.1
 */

public class FilmGroup
{
   /**
    * Stores and retrieves data about person's names and films. 
    */
   public void filmShareDemo() 
   {
      Map<String, Set<String>> personMap = new HashMap<>();
      Set<String> films = new HashSet<>();
      
      //add values to set inside map
      //set used as we have one of each film
      films.add("Terminator");
      films.add("Some like it hot");
      films.add("Gilda");
      personMap.put("John", films);

      films = new HashSet<>();
      films.add("Terminator");
      films.add("Sixth Sense");
      films.add("Toy Story");
      personMap.put("Ilaria", films);

      films = new HashSet<>();
      films.add("Terminator");
      films.add("2001");
      films.add("Some like it hot");
      personMap.put("Vera", films);

      films = personMap.get("Xander");
      System.out.println("Xanders films are " + films);

      if ((personMap.remove("Xander")) == null)
      {
         OUDialog.alert("Xander not found ");
      }

      for (String eachPerson : personMap.keySet()) 
      { 
         films = personMap.get(eachPerson);
         System.out.println(eachPerson + " has the films: " + films);
      }
   }

   /**
    * Finds and outputs matching films. 
    */
   public void filmMatchesDemo() 
   {
      Map<String, Set<String>> personMap = new HashMap<>();
      Set<String> films = new HashSet<>();

      films.add("Terminator");
      films.add("Some like it hot");
      films.add("Gilda");
      personMap.put("John", films);
     
      films = new HashSet<>();
      films.add("Terminator");
      films.add("Sixth Sense");
      films.add("Toy Story");
      personMap.put("Ilaria", films);
     
      films = new HashSet<>();
      films.add("Terminator");
      films.add("2001");
      films.add("Some like it hot");
      personMap.put("Vera", films);

      Set<String> johnsFilms  = personMap.get("John");
      String outputString;
      Set<String> eachPersonFilms;
      Set<String> intersection;

      for (String eachPerson : personMap.keySet()) 
      {
         eachPersonFilms = personMap.get(eachPerson);
         intersection = new HashSet<>(johnsFilms);
         intersection.retainAll(eachPersonFilms);
         outputString = "John and " + eachPerson 
         + " have this many common films: "
         + intersection;
         System.out.println(outputString) ;
      }
   }   

   /**
    * Finds and outputs least films users have in common. 
    */
   public void leastFilmsInCommon() 
   { 
      Map<String, Set<String>> personMap = new HashMap<>();
      Set<String> films = new HashSet<>();

      films.add("Jaws");
      films.add("Apocalypse now");
      films.add("Alien");
      personMap.put("Fred", films);

      films.add("Terminator");
      films.add("Some like it hot");
      films.add("Gilda");
      personMap.put("John", films);

      
      films = new HashSet<>();
      films.add("Terminator");
      films.add("Sixth Sense");
      films.add("Toy Story");
      personMap.put("Ilaria", films);

      films = new HashSet<>();
      films.add("Terminator");
      films.add("2001");
      films.add("Some like it hot");
      personMap.put("Vera", films);

      films = new HashSet<>();
      films.add("Sharknado 1");
      films.add("Sharknado 2");
      films.add("Sharknado 3");
      personMap.put("Sharky", films);
      
      Set<String> johnsFilms  = personMap.get("John");
      String outputString;
      Set<String> eachPersonFilms;
      Set<String> intersection ;
      int lowestMatchesSoFar = 0; //we assume no matches
      String lowestMatchPersonSoFar = "";
      boolean firstTime = true;

      
      
      for (String eachPerson : personMap.keySet()) 
      {
         
         if (!eachPerson.equals("John"))  
         {
            eachPersonFilms = personMap.get(eachPerson);
            
            
            intersection = new HashSet<>(johnsFilms);
            intersection.retainAll(eachPersonFilms);
            outputString = "John and " + eachPerson 
                            + " have this many common films: "
                            + intersection;
            System.out.println(outputString);
            System.out.println("Number of common films: " + intersection.size());             
            
            //make the first person in the key the lowest
            
            if (firstTime==true)
            {
               lowestMatchPersonSoFar = eachPerson;
               lowestMatchesSoFar = intersection.size();
               System.out.println("HURRAH:first time lowest " 
               + lowestMatchPersonSoFar + " with " 
               + lowestMatchesSoFar);
               firstTime = false;

            }
            if (intersection.size() < lowestMatchesSoFar)
            {
               lowestMatchPersonSoFar = eachPerson;
               lowestMatchesSoFar = intersection.size();
               System.out.println("HURRAH DURING WE FOUND ANOTHER LOWEST:  " 
               + lowestMatchPersonSoFar + " with " 
               + lowestMatchesSoFar);
            }
         }
         
      }
      System.out.println("FINAL:Person who John should contact to swap film with first : " 
                        + lowestMatchPersonSoFar);
      System.out.println("Number of films they have in common:" 
                        + lowestMatchesSoFar);
      
   }
   
   /**
    * iterates over all the map's keys 
    * to print out a meaningful textual representation of each
    * key in the map and the associated value.
    */

   //NOT WORKING!
   public void printMap()
   {  

      Map<String, Set<String>> personMap = new HashMap<>();
      Set<String> films = new HashSet<>();
      
      films.add("Jaws");
      films.add("Apocalypse now");
      films.add("Alien");
      personMap.put("Fred", films);

      films.add("Terminator");
      films.add("Some like it hot");
      films.add("Gilda");
      personMap.put("John", films);

      
      films = new HashSet<>();
      films.add("Terminator");
      films.add("Sixth Sense");
      films.add("Toy Story");
      personMap.put("Ilaria", films);

      films = new HashSet<>();
      films.add("Terminator");
      films.add("2001");
      films.add("Some like it hot");
      personMap.put("Vera", films);

      films = new HashSet<>();
      films.add("Sharknado 1");
      films.add("Sharknado 2");
      films.add("Sharknado 3");
      personMap.put("Sharky", films);
      
      
      //Set<String> johnsFilms  = personMap.get("John");

      for (String eachPerson : personMap.keySet()) 
      {
            System.out.println("Name of person is " + eachPerson 
                       + " and the films the person has are: ");
            System.out.println("size of the values: ");
//            personMap.get(eachPerson).size());
            for (String eachOne : personMap.get(eachPerson))
            {
               System.out.println("It's: " + eachOne);
            }
      }
   
//   get
   
  // add
  // 
  //amend
   
   
   //delete
   
   
   }
}