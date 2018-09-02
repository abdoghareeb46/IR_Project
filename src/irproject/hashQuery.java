package irproject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class hashQuery {

    ArrayList<ArrayList> result = new ArrayList<>();
    ArrayList<Integer> result2 = new ArrayList<>();

    // Hashtable<String, ArrayList<Integer>>
    public ArrayList sword(String search_key, Hashtable<String, ArrayList<Integer>> list) {

        if (list.containsKey(search_key)) {
            result.add(list.get(search_key));
        }
        return result;
    }

    ////////////////// Search with multy and /////////////////////////
    public ArrayList multiAnd(String[] search_key, Hashtable<String, ArrayList<Integer>> list) {

        ArrayList<Integer> all_positing = new ArrayList<>();

        //////////  deleting and from the Search key ////////////////
        ArrayList<String> token_of_search = new ArrayList<>();
        for (int i = 0; i < search_key.length; i++) {

            if (!search_key[i].equals("and")) {
                token_of_search.add(search_key[i]);
            }
        }

        /////////////////// getting the positing list of each key word //////////////////
        for (int i = 0; i < search_key.length; i++) {

            if (list.containsKey(search_key[i])) {

                for (int j = 0; j < list.get(search_key[i]).size(); j++) {
                    all_positing.add(list.get(search_key[i]).get(j));
                }

            }

        }

        /////////////////////// computing the reapting rate of positings /////////////////
        for (int i = 0; i < all_positing.size(); i++) {
            int count = 0;
            for (int j = i; j < all_positing.size(); j++) {

                if (all_positing.get(i) == all_positing.get(j)) {
                    count++;
                }

            }
            if (count == token_of_search.size()) {
                result2.add(all_positing.get(i));
            }

        }

        return result2;

    }

    ////////////////////////////// multy or ///////////////////////////////
    public ArrayList<Integer> multiOr(String[] search_key, Hashtable<String, ArrayList<Integer>> list) {

        ArrayList<Integer> all_positing = new ArrayList<>();

        //////////  deleting and from the Search key ////////////////
        ArrayList<String> token_of_search = new ArrayList<>();
        for (int i = 0; i < search_key.length; i++) {
            if (!search_key[i].equals("or")) {
                token_of_search.add(search_key[i]);
            }
        }

        /////////////////// getting the positing list of each key word //////////////////
        for (int i = 0; i < search_key.length; i++) {

            if (list.containsKey(search_key[i])) {

                for (int j = 0; j < list.get(search_key[i]).size(); j++) {
                    all_positing.add(j, list.get(search_key[i]).get(j));
                }

            }

        }

        
        //  HashSet<Integer> res = new HashSet<>(all_positing);
        return all_positing;

    }

}



