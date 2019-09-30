package tablemaker;

public class cleanData {
	
	public static boolean isSimilar(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
  
        int [] costs = new int [b.length() + 1];
        
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        
        for (int i = 1; i <= a.length(); i++) {
            costs[0] = i;
            int nw = i - 1;
            
            for (int j = 1; j <= b.length(); j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        
      //if levenshtein distance is close enough to the string
        if(costs[b.length()]<3)
        	return true;
        else
        	return false;
    }
	
}
