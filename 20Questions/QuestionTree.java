/** this will help with saving the game's tree, read the file and print that tree from a given file, and help build a new tree
* it will be updating the tree whenever the ai loses and adds the new answer to the tree from the user
* it will help update the wins the ai won and the games played.
* when loading the file to the game, it will traverse down the tree and help make new nodes
* if there is a node that is a question it will have a new left and right node on the bottom and the loop will continue
* when saving the game, it will go through the pre-order steps in order for it to traverse down tree.
* @author Liam Barragan
* @version 1.0 6/10/2023 */
import java.util.*;
import java.io.*;

public class QuestionTree
{
   /**this will help keep track of the root of the tree*/
   QuestionNode OverallRoot;
   /** help keep track of games played*/
   private int totalGamesP;
   /** this will help keep track of the games won by the ai*/
   private int aiWon;
   /** this will help utilize the UserInterface class*/
   UserInterface my;
   /** this will be the constructor, it will help initialize the data fields
   * this is help set the root up too
   * @param is the userinterface
   * @throw an illegal argument exception if there is nothing from the userinterface */
  public QuestionTree (UserInterface ui)
  {
    if(ui == null){
      throw new IllegalArgumentException();
    }
    this.my = ui;
    this.OverallRoot = new QuestionNode("Jedi");//initalize the root of the tree
    this.totalGamesP = 0;//initialize the total games played
    this.aiWon = 0;//initalize the total games the ai won
  }
  /** this will help call the play method which will help be used to play the game, more explanation will be down there
  * after it has been called, the total games played will be updated */ 
  public void play()
  {
   OverallRoot = playMethod(OverallRoot);
   totalGamesP++;
  }
  /** this will help save the game/tree 
  *@param output which is whatever is on the game screen,in terms of the tree, more explaination will be on the bottom
  * @throw illegal argument exception when output is null */
  public void save(PrintStream output)
  {
   if(output == null){
      throw new IllegalArgumentException();
   }
      saveOutcome(OverallRoot, output);
  }
  /** this will help call the buildtree method
  * basically it is building a tree after going through a given file
  * @param file scanner which will go through each line in the file
  * @throw illegal argument exception when scanner is null */
  public void load(Scanner input)
  {
   if(input == null){
      throw new IllegalArgumentException();
   }
      if(input.hasNextLine()){
      OverallRoot = buildTree(OverallRoot, input);
      }
   }
  /** this will return the number of games played
  *@return the number of games played by the user*/
  public int totalGames()
  {
    return totalGamesP;
  }
  /** this will return the number of games won by the ai
  * @return the number of games won by the computer. */
  public int gamesWon()
  {
    return aiWon;
  }
  /** this will help build the game
  *this will help print out a node on the right or left depending on the answer to question
  * it will update the tree and root as the game is continued
  * if the ai guesses the right answer then the games won by the ai is updated
  * otherwise it will update the tree
  *it will also ask questions to collect data to update the tree
  @param the root of the tree
  @return the update tree */
   private QuestionNode playMethod(QuestionNode node){
   //when building this method I had to draw out the tree and how I want it to work.
   //some of the parts I utilized the userinterface class, to help with the if statements
   //stacksoverflow and geeksforgeeks are both sources that helped me build this method
      if(node.left == null && node.right == null){
         System.out.println("Does your object happen to be: " + node.data + "?");
            if(my.nextBoolean()){//after reading the userinterface class, if yes is the responce then the ai wins 
               System.out.println("I win!");
               aiWon++;//increases the ai win
               return node;//return the root
            }
            else{//if both right and left node are not empty then this method will update the nodes
               System.out.println("I lose! What was the object?");
               String answer = my.nextLine();//keeps track of the answer to what the user's answer
               System.out.println();//When testing my code, I needed this because it was throwing errors if i did not have this
               System.out.println("Type a yes/no question to distinguish your item from " + node.data + ": ");
               String futureQuestion = my.nextLine();//this will hold the question
               System.out.println();
               System.out.println("And what is the answer for your object? ");
               String answerToQ = my.nextLine();//this will hold the answer to the question the user provided
               System.out.println();
               if(answerToQ.equalsIgnoreCase("y")){//if the answer to the question is yes
                 node = new QuestionNode(futureQuestion, new QuestionNode(answer), node); //it will update the tree
                 //this will help put the question, then the answer to the left if the answer is yes to the question, and past answer to the right
               }
                  else{//otherwise the tree will be updated if the answer is no
                  node = new QuestionNode(futureQuestion, node,new QuestionNode(answer));  
                  //it will put the question, the answer that was already in there, and the new answer to the right as the answer is no                    
                  }
               
                return node;
            } 
      }  
      else{// this helps traverse down the tree
         System.out.println(node.data);
         if(my.nextBoolean()){ //if the answer is yes then it goes to the left
            node.left = playMethod(node.left);
         }
            else{
               node.right = playMethod(node.right);//otherwise it goes to the right
            }
      }
                  
  return node;
  }
         /** this will save the tree and print out the answer or leaf node  with an A: in the begining
         * and if it is not a leaf node then it will have Q: in the beginging
         * this will go through and if it reaches a leaf node then it will do as stated above
         * if it is not a leaf node then it will be considered a question and make two left and right nodes which will be called into this method
         * after it is called it will traverse down until it reaches the leaf node AKA the base case
         * @param the node of the question or answer 
         * @param the print stream outcome which is what is given input */
         private void saveOutcome(QuestionNode node, PrintStream outcome){//this will allow me to print out the stuff in pre-order
         //I had to look up how to do that, my source is geeksforgeeks website
            if(node.left == null && node.right == null){
               outcome.println("A: "+ node.data);//when you reach the leaf node this is the what will need to be printed out 
               
            }
               else{
                  outcome.println("Q: " + node.data);//otherwise if it isn't a leaf node it will traverse down the tree in pre-order
                  saveOutcome(node.left, outcome);
                  saveOutcome(node.right, outcome);
              }
        }
        /** this will help build the tree from a given file
        * this will go through the lines with base case being there is no next line in the file
        * if there is a next line in the file then make a new node for the lines in the file
        * then if it starts with a Q in the begining then go make a right and left node underneath and it will go through the process of
        * distinguishing answer nodes and question nodes
        * if there is no next line then it will return the tree
        * @param the node of a tree
        * @param the scanner that reads through the file
        *@return the updated tree */
        private QuestionNode buildTree(QuestionNode node, Scanner input){
        //This idea came from both slides from and a geeksforgeeks website
        //This will go through the lines and be the base case
        //if there is no line left it will return the node
         if(!input.hasNextLine()){
            return node;
         }
            else{//this idea is what was combined from the slides and the geeksforgeeks website
            //based on the slides, it will be add a new node to as each line is passed
            //this is very similar to when node == null and make a new node
            //and just like very similar to the slides, if the line is = to something it will make to new nodes underneath
            //and as it is making the left and right nodes it will go through this method again
            //the geeksforgeeks website helped give me a better understanding of how to build a binary tree
               String line1 = input.nextLine();//helps go through each line
               node = new QuestionNode(line1);//makes a new node for that line
               if(line1.startsWith("Q")){//starts with is something I learned on the geeksforgeeks website
                  node.left = buildTree(node.left, input);//helps build the tree on the left side
                  node.right = buildTree(node.right, input);//helps build the tree on the right side
               }
            }
                
               return node;//return the tree after all the loops
        }
}