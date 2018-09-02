/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package irproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JFileChooser;

/**
 * FXML Controller class
 *
 * @author Ali Hassan
 */
public class MainStageController implements Initializable {

    @FXML
    ComboBox<String> combomodule;

    @FXML
    TextField queryTextfield;

    @FXML
    Label folder;

    File f;
    File list_of_files[];
    ArrayList<String> token_from_files;
    ArrayList<String> files_text;
    ArrayList<String> r_tokens = new ArrayList<>();
    ArrayList<String> stopwords;
    //private ArrayList<positings> inverted_hash = new ArrayList<positings>();
    Hashtable<String, ArrayList<Integer>> inverted_hash = new Hashtable<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> searchtypes = new ArrayList();
        searchtypes.add("Boolean");
        searchtypes.add("Distriputed");
        ObservableList<String> items = FXCollections.observableArrayList(searchtypes);

        combomodule.getItems().addAll(items);
        combomodule.setValue("Boolean");
        // TODO
    }

    @FXML
    public void choose_files() throws IOException {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int choosed = chooser.showOpenDialog(null);
        if (choosed == JFileChooser.APPROVE_OPTION) {
            try {
                f = chooser.getSelectedFile();
                list_of_files = f.listFiles();
                token_from_files = new ArrayList<>();
                for (File list_of_file : list_of_files) {
                    String text = "";
                    try (Scanner sc = new Scanner(list_of_file)) {
                        while (sc.hasNext()) {
                            token_from_files.add(sc.next());

                        }
                    }
                }

                ////////////////////// stemming and normalization /////////////////////////////////////
                Stemming stemming_and_normalization = new Stemming(token_from_files);

                token_from_files = stemming_and_normalization.afetr();

                ////////////////////////////////////////////////////////////////////////////////////////
                /////////////////// clear the stopwords /////////////////
                stopwords = new ArrayList<>();
                BufferedReader stopWordsFile = new BufferedReader(new FileReader("stopWords.txt"));
                String stopWord;
                while ((stopWord = stopWordsFile.readLine()) != null && !stopWord.equals(" ")) {
                    stopwords.add(stopWord);
                }

                for (int y = 0; y < stopwords.size(); y++) {

                    for (int s = 0; s < token_from_files.size(); s++) {
                        if (stopwords.get(y).equals(token_from_files.get(s))) {

                            token_from_files.remove(s);
                        }

                    }

                }

                ///////////////////////// clear reapting ///////////////////
                for (int y = 0; y < token_from_files.size(); y++) {

                    for (int s = y + 1; s < token_from_files.size(); s++) {
                        if (token_from_files.get(y).equals(token_from_files.get(s))) {
                            token_from_files.remove(s);
                        }

                    }

                }

                // System.out.println(token_from_files);
                /////////////////////////////////  texts  of each file as word   ///////////////////////
                files_text = new ArrayList<>();
                for (int i = 0; i < list_of_files.length; i++) {
                    String text = "";
                    Scanner scanner = new Scanner(list_of_files[i]);

                    while (scanner.hasNext()) {
                        text += scanner.next() + " ";
                    }
                    files_text.add(text);
                    scanner.close();

                }

                /////////////////////////  filling the positing_words complete_hash   ////////////////////////////////////
                for (int i = 0; i < token_from_files.size(); i++) {
                    ArrayList<Integer> num = new ArrayList<>();
                    for (int j = 0; j < files_text.size(); j++) {
                        if (files_text.get(j).contains(token_from_files.get(i))) {
                            num.add(j);
                        }
                    }
                    inverted_hash.put(token_from_files.get(i), num);

                }
//                System.out.println(inverted_hash);

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

        }
        String filePath = chooser.getCurrentDirectory().getAbsolutePath();
        folder.setText(filePath);
    }

    @FXML
    public void boolean_search() {
        ArrayList<String> query_steam = new ArrayList<>();
        hashQuery obg = new hashQuery();
        //  ArrayList<Integer> result1=  obg.search(jTextField1.getText(), inverted_hash);

        String txt = queryTextfield.getText().toLowerCase(Locale.ENGLISH);
        query_steam.add(txt);
        Stemming stemming_and_normalization = new Stemming(query_steam);
        query_steam = stemming_and_normalization.afetr();
        String arr[] = new String[query_steam.size()];
        arr = query_steam.get(0).split(" ");
        if (arr.length == 1) {
            ArrayList<Integer> result = obg.multiAnd(arr, inverted_hash);
            String array[] = new String[result.size()];
            for (int i = 0; i < result.size(); i++) {
                array[i] = list_of_files[result.get(i)].getAbsolutePath();
            }
            result obj = new result(array);
            obj.setVisible(true);

        } else if (txt.contains("and") && !txt.contains("or")) {

            ArrayList<Integer> result2 = obg.multiAnd(arr, inverted_hash);
            String[] array1 = new String[result2.size()];
            for (int i = 0; i < result2.size(); i++) {
                array1[i] = list_of_files[result2.get(i)].getAbsolutePath();
            }
            result obj = new result(array1);
            obj.setVisible(true);

        } else if (txt.contains("or") && !txt.contains("and")) {

            ArrayList<Integer> result2 = obg.multiOr(arr, inverted_hash);
            for (int i = 0; i < result2.size(); i++) {
                for (int j = i + 1; j < result2.size(); j++) {

                    if (Objects.equals(result2.get(i), result2.get(j))) {
                        result2.remove(j);
                    }
                }
            }

            String[] array2 = new String[result2.size()];
            for (int i = 0; i < result2.size(); i++) {

                array2[i] = list_of_files[result2.get(i)].getAbsolutePath();

            }
            result obj = new result(array2);
            obj.setVisible(true);
        } else if (txt.contains("and") && txt.contains("or")) {

            String x = txt.substring(0, txt.lastIndexOf("or") - 1);
            String[] q = x.split(" ");
            ArrayList<Integer> result = obg.multiAnd(q, inverted_hash);

            String y = txt.substring(txt.lastIndexOf("or") + 3);

            ArrayList<ArrayList> r = obg.sword(y, inverted_hash);

            for (int i = 0; i < r.size(); i++) {
                for (int j = 0; j < r.get(i).size(); j++) {

                    result.add((Integer) r.get(i).get(j));
                }
            }

////////////////////////   reapte      ////////////////////////////////
            for (int i = 0; i < result.size(); i++) {
                for (int j = i + 1; j < result.size(); j++) {

                    if (Objects.equals(result.get(i), result.get(j))) {
                        result.remove(j);
                    }
                }
            }

            String array[] = new String[result.size()];
            for (int i = 0; i < result.size(); i++) {
                array[i] = list_of_files[result.get(i)].getAbsolutePath();
            }
            result obj = new result(array);
            obj.setVisible(true);
        } else if (txt.contains("or") && txt.contains("and")) {

            String x = txt.substring(txt.lastIndexOf("or") + 3);
            String[] q = x.split(" ");

            ArrayList<Integer> result = obg.multiAnd(q, inverted_hash);
            String y = txt.substring(0, txt.lastIndexOf("or") - 1);

            ArrayList<ArrayList> r = obg.sword(y, inverted_hash);

            for (int i = 0; i < r.size(); i++) {
                for (int j = 0; j < r.get(i).size(); j++) {

                    result.add((Integer) r.get(i).get(j));

                }
            }

////////////////////////   reapte      ////////////////////////////////
            for (int i = 0; i < result.size(); i++) {
                for (int j = i + 1; j < result.get(i); j++) {

                    if (Objects.equals(result.get(i), result.get(j))) {
                        result.remove(j);
                    }
                }
            }

            String[] array_comp = new String[result.size()];
            for (int i = 0; i < result.size(); i++) {
                array_comp[i] = list_of_files[result.get(i)].getAbsolutePath();
            }
            result obj = new result(array_comp);
            obj.setVisible(true);
        }

    }

}
