import java.util.*;
/** HangmanManger class manages the Hangman game.
* Manages the number of guesses, manages the words chosen, keeps track of characters guessed, and shows the patterns
* @author Liam Barragan
* @version 1.0 (5/14/2023) */
public class HangmanManager{
   /** keeps track of the number of guess*/
   private int guessNumber;
   /** keeps track of the words of words chosen*/
   private Set<String> wordChoice;
   /** keeps track of the characters guessed */
   private Set<Character> userGuess;
   /** keeps track for the pattern */
   private String dashPatternState;
  
   /** Bascially the constructor, it will throw an illegal argument if the length of the word or if the guess is 0
   * this is the constructor for the pattern, length of the word chosen in the diction, and making a set for characters.
   * also makes inital pattern for the begining.
   *@param Dictionary is the collection of words for computer to choose.
   * @param length of the word chosen by computer
   * @param max the number of guess for the user. 
   *@throw IllegalArgumentException if the length is less than 1 or max is less than 0*/
   public HangmanManager(Collection<String> Dictionary, int length, int max){
      if( length < 1 || max < 0 ){
         throw new IllegalArgumentException();
      }
         this.guessNumber = max;
         this.wordChoice = new TreeSet<>();
         for(String word : Dictionary){
            if(word.length() == length)
            {
               wordChoice.add(word);
            }
         }
         this.userGuess = new TreeSet<>();
         dashPatternState = "-";
            for(int i = 0; i < length; i++){
              dashPatternState += "-";
            }
   }
   /* this calls the set of words to be considered
   * @return the set of words chosen */
   public Set<String> words(){
      return wordChoice;
   }
      /** this will show the number of guess left for the user
      * @return number of guess left*/
      public int guessesLeft(){
         return this.guessNumber;
      }
      /* this will be the user
      * @return returns the set of character guess*/
      public Set<Character> guesses(){
         return this.userGuess;
      }
       /** returns the inital pattern state
       * throws the illegalstateexception if there is no words found in the set
       * @throw IllegalStateException if there no word set*/
         public String pattern(){
            if(wordChoice.isEmpty()){
               throw new IllegalStateException("There was no set of words found!");
            }                                 
            return this.dashPatternState;
          }
          /** this will count the number of occurances for the letter guessed
          * if there is no occurance then the number of guesses decrease
          * @param guesses is the character guessed
          * @return the number of the characters guessed */
         private int count(char guesses){
            int numOfOccurance = 0;
            for(int i = 0; i< dashPatternState.length(); i+= 2){
               if(dashPatternState.charAt(i) == guesses){
                  numOfOccurance++;
               }
             }
             if(numOfOccurance == 0){
               guessNumber--;
             }
             return numOfOccurance;
         }
         
         /** this helps build the pattern for when the character is guessed right and helps display the dash pattern and letter
         * @param map is the map of word and the pattern it is associated with, keeping track of the charcter guessed
         * @param word goes through the current word
         * @param letter is the letter guessed by the user
         * @return the state of the dash pattern with the letter guessed */
            private void showingPattern(Map<String, Set<String>> map,String word, char letter){
               String newPattern = "";
               for(int i = 0; i< word.length(); i++){
                  if(userGuess.contains(word.charAt(i))){
                     newPattern += word.charAt(i);
                  }
                     else if(word.charAt(i) == letter){
                        newPattern += letter+ "-";
                     }
                     else{
                        newPattern += "-";
                     }
               }
               if(!map.containsKey(newPattern)){
                        Set<String> wordSet = new TreeSet<>();
                        map.put(newPattern, wordSet);
                     }
               map.get(newPattern).add(word);
              dashPatternState = newPattern;
               
           }
            /** this will pull the largest pattern and it will compare each one in order to do that
            * @param map this is the map of the words and the patterns needed in order to guess correctly
            * @return the dash pattern with the correct letter */ 
            private String newString(Map<String, Set<String>> map){
               String a = "";
               int counting = 0;
                  for(String allPatternsNeeded: map.keySet()){
                    if(counting < map.get(allPatternsNeeded).size()){
                        a = allPatternsNeeded;
                        counting = map.get(allPatternsNeeded).size();
                     }
                    }
                    wordChoice = map.get(a);
                    dashPatternState = a;
                    return dashPatternState;
                  }
                  
       /* records the guess by the user, and updates the pattern after the user guesses the letter
       * it returns the number of occurances of the pattern that was guessed in the new pattern.
       * @param guess the character guessed by the user
       * @throw IllegalStateException if there is no guesses and there is no words in the set
       * @throw IllegalArgumentException if the character is already used and if the the set is not empty
       * @return the number of occurances of the guessed letter */      
         public int record(char guess){
            if(guessNumber < 1 || wordChoice.isEmpty()){
               throw new IllegalStateException("Sorry your guesses are all gone and there is no words!");
            }
               else if(!wordChoice.isEmpty() && userGuess.contains(guess)){
                  throw new IllegalArgumentException("You guess that Character already!");
               }
               userGuess.add(guess);
               Map<String, Set<String>> map = new TreeMap<>();
               
                  for(String word : wordChoice){
                      showingPattern(map,word, guess);             
                  }
               wordChoice = map.get(dashPatternState);
               newString(map);
               wordChoice = map.get(dashPatternState);
               return count(guess);
         }  
}