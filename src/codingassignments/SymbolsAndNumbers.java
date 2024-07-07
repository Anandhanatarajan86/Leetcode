package codingassignments;

import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;
    import java.util.Stack;

public class SymbolsAndNumbers {
    List<String> symbols = new ArrayList<>();

    public void sortCards(ArrayList<String> cards, int n) {
        //Check the no of digits
        int numberIndex = -1;
        // Temporary list to hold numeric strings
        ArrayList<String> reorderedList = new ArrayList<>(cards.size());
        for(String currentStr : cards){

            try {
                Integer.parseInt(currentStr);  // Check if the string is a valid integer
                reorderedList.add(currentStr);
                numberIndex++;
            } catch (NumberFormatException e) {
                symbols.add(currentStr);

            }
        }

        // Add non-numeric symbols at the end
        for(int symbolIndex  = 0; symbolIndex  < symbols.size(); symbolIndex++){
           reorderedList.add(symbols.get(symbolIndex));
       }
       StringBuilder resBuilder = new StringBuilder();
        for(String res : reorderedList){
            resBuilder.append(res);
            resBuilder.append(" ");

        }
        resBuilder.deleteCharAt(resBuilder.length()-1);
        System.out.println(resBuilder.toString());

    }
    public  static  void main(String[] args){
        SymbolsAndNumbers symbolsAndNumbers = new SymbolsAndNumbers();
        ArrayList<String> numAndSymbolList = new ArrayList<>(Arrays.asList("3","2","+","4","*","-","$","5"));
        symbolsAndNumbers.sortCards(numAndSymbolList,8);
    }
}
