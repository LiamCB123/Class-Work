/** 
* This helps generate strings for the GrammarSolver main and helps manage the main
* Manages what symbols and helps store other stuff that are in the file into arrays
*@author Liam Barragan
*@version 1.0 5/21/2023 */
import java.util.*;
public class GrammarSolver{
   /** this map will be used to hold the nonterminal and terminal stuff*/
   private Map<String, String[]> grammarHelp;
   /** this will help with generating a random occruance in the generate method */
   private  Random r = new Random();
   /** 
   *  This will be the constructor for the program. It will initalize the grammar solver and go through the rules
   * it also breaks apart the rules
   *@param rules the list of grammar rules
   *@throw Illegal argument exception when rules is empty or when rules are null
   *@throw Illegal argument exception if there is rules that are repeated */
   public GrammarSolver(List<String> Rules){
      if(Rules.isEmpty()|| Rules == null){
         throw new IllegalArgumentException();
      }
         grammarHelp = new TreeMap<>();
         for(String s: Rules){
         String[] divide = s.split("::=");
            if(grammarHelp.containsKey(divide[0])){
               throw new IllegalArgumentException();
            }
         String[] or = divide[1].trim().split("[|]");
         for(int i = 0; i<2; i++){
            divide[i] = divide[i].trim();
         }
         grammarHelp.put(divide[0], or);
         }
   }
   /** this is checking to see if the symbol is nonterminal
   * @param Symbol is the symbol that will be checked
   * @throw an illegal argument exception if the symbol is null or if it has a length of zero
   * @return true if the symbol is nonterminal and false if isn't */
   
      public boolean contains(String Symbol){
         if(Symbol.length() == 0 || Symbol == null){
            throw new IllegalArgumentException();
         }
        
         return grammarHelp.containsKey(Symbol);
        
      }
      /** this will return the nonterminal symbols in a sorted set
      * @return this will return the nonterminal symbol in a sorted set */
         public Set<String> getSymbols(){
            return grammarHelp.keySet();
         }
         /** this will use the grammar to help generate random occruances of the given symbol
         *this will of course return it as a string
         * if the string is passed down as nonterminal, it will assume it is terminal
         *@param symbol that will generate the String
         *@throw new illegal argument exception when symbol length is empty or if it is null
         *@return the string as a sentence or a random occurance of symbol */
            public String generate(String Symbol){
             
               String stringResult = "";
               if(Symbol.length() == 0 || Symbol == null){
                  throw new IllegalArgumentException();
               }
               if(!grammarHelp.containsKey(Symbol)){
                  return Symbol;
               }
                  String[] hold = grammarHelp.get(Symbol);
                  String store = hold[r.nextInt(hold.length)];
                  String[] newArray = store.split("[ \t]+");
                  for(String word: newArray){
                     if(grammarHelp.containsKey(word)){
                        stringResult += generate(word)+ " ";
                     }
                        else{
                           stringResult += word + " ";
                        }
                   }
                return stringResult.trim();
            }
}