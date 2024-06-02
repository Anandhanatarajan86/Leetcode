package arrays.partition;

public class ApplesAndPineApples {
    int lowestPrefixDivision = 0;
    int[] prefixMangoesCount;
    int[] prefixPineAppleCount;
    int   totalMangoes  = 0;
    int   totalPineApples = 0;

    public int solve(String s, int n) {
        //Write your code here;
        char[] tempArray = s.toCharArray();
        //calculate prefixMangoesCount
        int prefixMangoes = 0;
        int prefixPineApples = 0;
        prefixMangoesCount = new int[tempArray.length];
        prefixPineAppleCount = new int[tempArray.length];
        for(int charIndex = 0; charIndex < tempArray.length; charIndex++){
           char current = tempArray[charIndex];
            if(current=='M'){
                prefixMangoesCount[charIndex] = prefixMangoes+ 1;
                prefixMangoes = prefixMangoesCount[charIndex];
                prefixPineAppleCount[charIndex] = prefixPineApples;
            }
            if(current=='P'){
                prefixPineAppleCount[charIndex] = prefixPineApples + 1;
                prefixPineApples = prefixPineAppleCount[charIndex];
                prefixMangoesCount[charIndex] = prefixMangoes;
            }


        }
        totalMangoes    = prefixMangoesCount[tempArray.length-1];
        totalPineApples = prefixPineAppleCount[tempArray.length-1];
        for(int index = 0; index < tempArray.length ; index++){
            if(constraintsSatisfying(index)){
                //System.out.println("min indes:"+index+1);
                int ans = index +1;
               // System.out.println("min indes:"+ans);
                return ans;
            }
        }

    return -1;
    }

    private boolean constraintsSatisfying(int currIndex){
            int prefixMangoes = prefixMangoesCount[currIndex];
            int prefixPineApples = prefixPineAppleCount[currIndex];
           // int prefixPineApples = prefixPineAppleCount[currIndex];
            int suffixMangoes = totalMangoes - prefixMangoes;
            int suffixPineApples = totalPineApples - prefixPineApples;
            //check the left part
        if((prefixMangoes ==0 && prefixPineApples ==0) || (suffixMangoes==0 && suffixPineApples==0) ){
            return false;
        }
        int mangoesDifference = Math.abs(prefixMangoes - suffixMangoes);
        int pineApplesDifference = Math.abs(prefixPineApples -suffixPineApples);
        if(mangoesDifference==0 || pineApplesDifference ==0){
            return false;
        }
      return true;
    }
    public  static  void main(String[] args){
        ApplesAndPineApples applesAndPineApples = new ApplesAndPineApples();
        //applesAndPineApples.solve("PMP",3);
        applesAndPineApples.solve("PMPP",4);

    }
}
