package irproject;

import java.util.ArrayList;

public class biword_index {
    
    ArrayList<String> token;
    ArrayList<String> biTokens = new ArrayList<>();
    ArrayList<String> biQuery = new ArrayList<>();
    String []  query ;
     
    

    /*
    biword approch :
    1 - split thr terms in paired of words
    2 - putting and after each two pair of words in the query
     */
    
    
    public biword_index(String []  arr , ArrayList token) {
        this.token = token ;
        this.query = arr ;
        setToken();
        setQuery();
        
    }
    
    
    
    public void setToken() {
       
        for (int i = 0; i < token.size(); i++) {
            int z = i+1 ;
            if (z!=token.size()) {
            String x = token.get(i);
            String y = token.get(z);
            String newword = x + " " + y ;
            biTokens.add(newword);
                
            }
           
            
        }
        
         
    }

    
    
    
    public void setQuery()
    {
        //System.out.println(query[1]);
        for (int i = 0; i <query.length; i++) {
            
            int z = i+1 ;
            if (z!=query.length) {
            String x = query[i];
            String y = query[z];
            String newword = x + " " + y ;
            biQuery.add(newword);
                
            }
        }
        
    
    }
    
    
    
    public ArrayList get_Query()
    {
      return biQuery ;
    }
    
    public ArrayList get_Term()
    {
      return biTokens ;
    }
    
}
