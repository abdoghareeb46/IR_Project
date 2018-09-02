package irproject;

import java.util.ArrayList;

public class Stemming {

    private ArrayList<String> token = new ArrayList<>();
    private ArrayList<String> after_normalization = new ArrayList<>();
    private ArrayList<String> after_Stremming = new ArrayList<>();

    public Stemming(ArrayList list) {
        this.token = list;
        normalization();
        Stemmer();

    }

    public void Stemmer() {

        for (int i = 0; i < after_normalization.size(); i++) {
            String newword = after_normalization.get(i);
            if (after_normalization.get(i).endsWith("ed")) {
                newword = after_normalization.get(i).replaceAll("ed", "");
            } else if (after_normalization.get(i).endsWith("tional")) {
                newword = after_normalization.get(i).replaceAll("tional", "tion");
            } else if (after_normalization.get(i).endsWith("ational")) {
                newword = after_normalization.get(i).replaceAll("ational", "ate");
            } else if (after_normalization.get(i).endsWith("ment")) {
                newword = after_normalization.get(i).replaceAll("ment", "");

            } else if (after_normalization.get(i).endsWith("ies")) {
                newword = after_normalization.get(i).replaceAll("ies", "i");

            } else if (after_normalization.get(i).endsWith("sses")) {
                newword = after_normalization.get(i).replaceAll("sses", "ss");
            } else if (after_normalization.get(i).endsWith("'s")) {
                newword = after_normalization.get(i).replaceAll("'s", "");
            } else if (after_normalization.get(i).endsWith("s")) {
                newword = after_normalization.get(i).replaceAll("s", "");
            } else if (after_normalization.get(i).endsWith("ic")) {
                newword = after_normalization.get(i).replaceAll("ic", "");
            }
             else if (after_normalization.get(i).endsWith("ing")) {
                newword = after_normalization.get(i).replaceAll("ing", "");
            }
            after_Stremming.add(newword);

        }

    }

    public void normalization() {
        for (int i = 0; i < token.size(); i++) {

            //// dealing with punticuation ////////
            String newword = "";
            for (int j = 0; j < token.get(i).length(); j++) {
                if (token.get(i).charAt(j) != '-' && token.get(i).charAt(j) != '@' && token.get(i).charAt(j) != '.' && token.get(i).charAt(j) != '$' && token.get(i).charAt(j) != ',') {
                    newword += token.get(i).charAt(j);
                }

            }
            /// lowercase //////
            after_normalization.add(newword.toLowerCase());

        }

    }

    public ArrayList afetr() {

        return after_Stremming;
    }

}
