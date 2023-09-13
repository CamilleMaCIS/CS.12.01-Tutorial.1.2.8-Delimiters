import java.util.ArrayList;

public class Delimiters {
    //instance variables a.k.a. properties
    private String openDel;
    private String closeDel;

    //constructor
    public Delimiters(String open, String close){
        this.openDel = open;
        this.closeDel = close;
    }

    //getter methods

    public String getOpenDel() {
        return openDel;
    }
    public String getCloseDel() {
        return closeDel;
    }

    //method getDelimitersList
    public ArrayList<String> getDelimitersList(String[] tokens){
        ArrayList<String> delimitersList = new ArrayList<>();
        for (String token : tokens){
            if (token.equals(openDel) || token.equals(closeDel)){
                delimitersList.add(token);
            }
        }
        return delimitersList;
    }
    //method isBalanced
    public boolean isBalanced(ArrayList<String> delimiters){
        //no point at which there are more close delimiters than open delimiters at or before that point
        for (int i = 0; i < delimiters.size(); i++){
            int currentCloseCount = 0;
            int currentOpenCount = 0;
            for (int j = 0; j <= i; j++){
                if (delimiters.get(j).equals(openDel)){
                    currentOpenCount++;
                }
                else if (delimiters.get(j).equals(closeDel)){
                    currentCloseCount++;
                }
            }
            //if at any point, there are more close delimiters than open delimiters, returns false
            if (currentCloseCount > currentOpenCount){
                return false;
            }
        }

        //total number of open delimiters is equal to the total number of close delimiters
        int countOpen = 0;
        int countClose = 0;
        //count how many occurrences of open delimiter and close delimiter
        for (String delimiter : delimiters){
            if (delimiter.equals(openDel)){
                countOpen++;
            }
            else if (delimiter.equals(closeDel)){
                countClose++;
            }
        }
        //check if amount of occurrences are NOT equal
        if (countOpen != countClose){
            return false;
        }

        return true;
    }
}
