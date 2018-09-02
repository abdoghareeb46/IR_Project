 
package irproject;

import java.util.ArrayList;
import java.util.Hashtable;

 
public class positings {
    
    Hashtable<String, ArrayList<Integer>> hash ;

    public positings(String term , ArrayList<Integer> num ) {

        this.hash = (Hashtable<String, ArrayList<Integer>>) new Hashtable<>().put(term, num);
        
    }
    
}
