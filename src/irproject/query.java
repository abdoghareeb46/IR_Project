package irproject;


import irproject.positings;
import java.util.ArrayList;
import java.util.Objects;

public class query {

    ArrayList<Integer> result;

    public ArrayList search(String search_key, ArrayList<positings> list) {

        if (search_key.contains("and")) {
            String before = search_key.substring(0, search_key.lastIndexOf("and") - 1);
            String after = search_key.substring(search_key.lastIndexOf("and") + 4);

            ArrayList<Integer> before_list = new ArrayList<>();

            ArrayList<Integer> after_list = new ArrayList<>();

            for (positings list1 : list) {
//                
//                if (list1.term.equals(before)) {
//                    before_list = list1.num;
//                }
//                if (list1.term.equals(after)) {
//                    after_list = list1.num;
//                }
            }

            before_list.listIterator();
            after_list.listIterator();
            
            result = new ArrayList<>();
//            System.out.println(before_list);
//            System.out.println(after_list);
//            
            try{
            for (int j = 0; j < after_list.size(); j++) {

                for (int i = 0; i < after_list.size(); i++) {
                    if (!before_list.isEmpty() && !after_list.isEmpty()) {
                        if (Objects.equals(before_list.get(i), after_list.get(j))) {
                            result.add( before_list.get(i));
                            break ;
                        } 
                        
                        if (after_list.get(j) < before_list.get(i)) {
                         break ; 
                         
                        }
                        
//                        if (after_list.get(j) > before_list.get(i)) {
//                           break ;
//                        }
                        
                        
                    }
                }
            }

            // return result;
         }catch(Exception e)
                 {
                     e.printStackTrace();
                 }
        
        }
        else if (search_key.contains("or")) {
            
            String before = search_key.substring(0, search_key.lastIndexOf("or") - 1);
            String after = search_key.substring(search_key.lastIndexOf("and") + 3);
             
            result = new ArrayList<>();
            ArrayList<Integer> before_list = new ArrayList<>();

            ArrayList<Integer> after_list = new ArrayList<>();

            for (positings list1 : list) {
//                if (list1.term.equals(before)) {
//                    before_list = list1.num;
//                }
//                if (list1.term.equals(after)) {
//                    after_list = list1.num;
//                }
            }

            before_list.listIterator();
            after_list.listIterator();
            
            for (int i = 0; i < before_list.size(); i++) {
                for (int j = 0; j < after_list.size(); j++) {
                 
                if(before_list.get(i)==after_list.get(j))
                {
                  before_list.remove(i);
                }
            }
            }
            
            for (int i = 0; i < before_list.size(); i++) {
                  result.add(before_list.get(i));
            }
            
            for (int i = 0; i < after_list.size(); i++) {
                  result.add(after_list.get(i));
            }
            
            
        }
        return result;    
    }
       
}
   