/**
 * This is the clockshop class that will put the clock object into arraylist
 * It will sort the clocks in the arraylist, find clock objects in arraylist, read files and write in it, and place clocks into the arraylist
 * @author Liam Barragan
 * @version 1.0 10/8/2023
 */

import java.util.*;
import java.io.*;
public class ClockShop {
    /** This will be the arraylist that will hold the clock objects */
    private ArrayList<Clock> myClocks;

    /**
     * This will be the constructor to help build the arraylist
     */
    public ClockShop(){

        myClocks = new ArrayList<>();
    }

    /**
     * This will read through a file and collect the clock objects and place them into the arraylist
     * @param theInputFileName this will be the file that it will read through
     * @throws FileNotFoundException if the file does not exist
     */
    public void fillClockShop(final String theInputFileName){
       Scanner inputFile = null;

        try{
            inputFile = new Scanner(new File(theInputFileName));
            inputFile.useDelimiter("[:|\\s]");
           // Clock fileClock = new Clock(0,0,0);
            while(inputFile.hasNext()){
                Clock fileClock = new Clock(0,0,0);
                fileClock.setHour(inputFile.nextInt());
                fileClock.setMinute(inputFile.nextInt());
                fileClock.setSecond(inputFile.nextInt());

                inputFile.nextLine();
                myClocks.add(fileClock);

            }
            inputFile.close();
        }
        catch(FileNotFoundException theException) {
            System.out.println("File not found: " + theInputFileName);
            System.exit(-1);
        }
    }

    /**
     * This will help sort the clocks from smallest time to biggest time, using the compareTo method from the clock class
     */
    public void sortClocks(){
       for (int i = 0; i < myClocks.size(); i++){ //helps iterate through the arraylist
           for(int j = myClocks.size()-1; j > i; j--){ //start at the end of the arraylist and go backwards
               if(myClocks.get(i).compareTo(myClocks.get(j)) >0){
                   Clock tempClock = myClocks.get(i);
                   myClocks.set(i,myClocks.get(j));
                   myClocks.set(j,tempClock);
               }
           }


       }
    }

    /**
     * This will add a clock object to the arraylist
     * @param clockObject the clock object that you are adding to the arraylist
     */
    public void addClock(Clock clockObject){

        myClocks.add(clockObject);
    }

    /**
     * this will help print out the clocks and put a new line for each clock
     * @Override toString method
     * @return returns the clocks printed with new line
     */
    public String toString(){
       String output = "";
        for(Clock clock: myClocks){
            output += clock.toString() + "\r\n";
        }
        return output;
    }

    /**
     * This will help check if a clock object exists within the arraylist
     * @param theClock object that you are looking for
     * @return the index of where that clock object is located in the arraylist
     * @return -1 if it doesn't exist in the arraylist
     */
    public int findClock(final Clock theClock){
        for(int i = 0; i < myClocks.size(); i++){
            if(myClocks.get(i).equals(theClock)){
                return myClocks.indexOf(theClock);
            }
        }
        return -1;
    }

    /**
     * this will find the clock object with the given index
     * @throws IllegalArgumentException if the index outside the index
     * @param theIndex is the index of the arraylist to find the clock object
     * @return the clock in that index
     */
    public Clock getClock(final int theIndex){
        if((theIndex < 0) || (theIndex >= myClocks.size())){
            throw new IllegalArgumentException("This index is out of the range!");
        }
        else{
            return myClocks.get(theIndex);
        }
    }

    /**
     * this will help place a clock object with a certain index into the arraylist
     * @param theClock the clock object
     * @param theIndex the index in which the clock is supposed to go into
     * @throws IllegalArgumentException if index is outside the range
     */
    public void setClock(final Clock theClock, final int theIndex) {
        if ((theIndex < 0) || (theIndex >= myClocks.size())) {
            throw new IllegalArgumentException("This index is out of the range!");
        } else {
            myClocks.add(theIndex, theClock);
        }
    }

    /**
     * this will help open a file, write in the arraylist of clock objects into that new file, if the file is not found then it will print that message out
     * @throws IOException if the file is not found or can't be written in
     * @param theFilename the name of the file
     */
    public void writeClocksToFile(final String theFilename){
            FileWriter theFileWriter;
            try{
                theFileWriter = new FileWriter(theFilename);
                BufferedWriter fileWrite = new BufferedWriter(theFileWriter);
                fileWrite.write(this.toString());
                fileWrite.close();
            }
            catch (IOException theException){
                System.out.print("File not found");
            }
        }




}
