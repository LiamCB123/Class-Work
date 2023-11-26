/** This will be going through 2 linkedlists, graveyard and killring
* It will go add a "victim" to the graveward and taken out of the killring
* It will update the killer and where it will point to
* It will update the graveyard when there is nothing or if there is a victim in there
* @author Liam Barragan
* @version 1.0 6/5/2023 */
import java.util.*;
public class AssassinManager{
   /** this will hold the kill ring */
   private AssassinNode killRingRef;
   /** this will hold the graveyard */
   private AssassinNode graveYardRef;
   
   /** This is the constructor of the program
   * What it will be doing throwing Illegal argument if there is no name in the list
   * it will get the names and update the kill ring by adding the names from the list to the kill ring
   * @throw IllegalArgumentException if list of names is empty. */
   public AssassinManager(List<String> Names){
      if(Names.isEmpty()){
         throw new IllegalArgumentException();
      }
      this.killRingRef = new AssassinNode(Names.get(0));
      AssassinNode holdNode = killRingRef;
      for(int i = 1; i< Names.size(); i++){
         holdNode.next = new AssassinNode(Names.get(i));
         holdNode = holdNode.next;
      }    
   }
   /** this will be print the kill ring with the names present
   * there is a temp variable that will be holding the names to help print out
   * the temp will also help print the head of the kill ring by referencing the kill ring. */
   public void printKillRing(){
      AssassinNode temp = killRingRef;
      while(temp.next != null){//there was a geeksforgeeks page on how to do something like this
         System.out.println("   < " + temp.name + " > is stalking < " + temp.next.name + " >");
         temp = temp.next;//this idea is from the geeksforgeeks website
      }
      System.out.println("   < " + temp.name + " > is stalking <" + killRingRef.name + " >");
      //this allows me to print the back of the list and the front of the list, by having a temperary list reference
   }
   /** same idea as above, I will be printing out the graveyard
   * I made a temp list to help with this out by referencing the graveyard.
   * this will also help with printing out the killer in which the kill method will help with adding graveyard killer.*/
   public void printGraveyard(){
   //same idea as the one above will be used for this method
   AssassinNode temp = graveYardRef;
    while(temp != null){
      System.out.println("    " + temp.name + "was killed by " + temp.killer);
      temp = temp.next;
      }
  }
   /** this will be checking if the name is in the kill ring
   * this will go through the while loop to iterator to check if there is the name
   * there is a name in it then it will return true
   * if not then it will be false
   * @return true if the name is in the kill ring
   * @return false if the name is not in the kill ring */
   public boolean killRingContains(String Name){
      AssassinNode temp = killRingRef;
      while( temp != null){
         if(temp.name.equalsIgnoreCase(Name)){
            return true;
         }
         temp = temp.next;
      }
      return false;
   }
      /** this will be checking if the name is in the graveyard
      * this will go through the while loop to iterate to check if there is the name in the graveyard
      *if the name is in there then return true
      * if not return false
      * @return true if the name is in the graveyard
      * @return false if name is not in the graveyard */
      public boolean graveyardContains(String name){
      AssassinNode temp = graveYardRef;
      while( temp != null){
         if(temp.name.equalsIgnoreCase(name)){
            return true;
         }
         temp = temp.next;
      }
      return false;
   }
   /** this will check if the game is over
   * if the kill ring is empty the game is over and return true
   * if not then return false
   * @return true if kill ring is empty
   * @return false if the kill ring is not empty*/
   public boolean gameOver(){
      if(killRingRef == null){
         return true;
      }
      else{
         return false;
      } 
  }
   /** this will help declare the winner
   * it will check if the game is not over
   * if it is over then it will return null
   * otherwise it will return the name that is in the kill ring
   * @return null if game is not over
   * @return killring name if it is the only one left. */
   public String winner(){
      if(!gameOver())
      {
         return null;
      }
      else{
      return killRingRef.name;
      }
   } 
      /** this will be going through to update graveyard and kill ring
      * will throw illegal argument excpetion if kill ring does not have that name in it
      * will throw illegal state exception if game over is true
      * the first if statement helps go through the scenario if the head of kill ring is killed
      * I provided comments on how that works
      * the last scenario is when someone outside the head of the kill ring is the victim
      * I also provided comments on that
      * @throw illegal arument excption when killring does not have the name
      * @throw illegal state excpetion when the game is over */
      public void kill(String name){//Nathan Li helped me out with this method
      //helped me understand it and how i should approach the problem
         if(!killRingContains(name)){
            throw new IllegalArgumentException();
         }
            if(gameOver() == true){
               throw new IllegalStateException();
            }
               AssassinNode list1 = killRingRef;//store killer
               AssassinNode list2 = killRingRef; //store killed 
                if(killRingRef.name.equalsIgnoreCase(name)){ 
                  //store killed node
                  //store killer into killed node, must be the last node's name
                  while(list2.next != null){
                     list2 = list2.next;
                  }
                     list1.killer = list2.name;
                  //KR = killed.next
                  killRingRef = list1.next;
                  //killed.next = GY
                  list1.next = graveYardRef;
                  //GY = killed
                  graveYardRef = list1.next;                
               }
               else{
                  //find node of who was killed
                  while(!list2.next.name.equalsIgnoreCase(name)){
                     list2 = list2.next;
                  }
                   list1 = list2.next;     
                  //store killer into killed node, the node before the killed node
                  list1.killer = list2.name;
                  //killer next target = killed.next 
                 list2.next = list1.next;
                  //killed.next = gravyard
                  list1.next = graveYardRef;
                  //graveyard = killed 
                  graveYardRef = list1;
                  
                             
      }
    }
              
   
   
      
}