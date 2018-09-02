package irproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class Project_gui extends javax.swing.JFrame {

    File f;
    File list_of_files[];
    ArrayList<String> token_from_files;
    ArrayList<String> files_text;
    ArrayList<String> r_tokens = new ArrayList<>();
    ArrayList<String> stopwords;
    //private ArrayList<positings> inverted_hash = new ArrayList<positings>();
    Hashtable<String, ArrayList<Integer>> inverted_hash = new Hashtable<>();

    public Project_gui() {
        initComponents();
        setTitle("inverted index");
        setLocationRelativeTo(null);
        setSize(770, 470);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator4 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Traditional Arabic", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Boolean");
        jLabel1.setMaximumSize(new java.awt.Dimension(66, 29));
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 60, 160, 37);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1);
        jTextField1.setBounds(230, 50, 240, 50);

        jButton1.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(540, 50, 100, 50);

        jLabel2.setFont(new java.awt.Font("Traditional Arabic", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("choose folder");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 310, 160, 38);

        jButton2.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jButton2.setText("Brose");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(290, 310, 90, 50);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField2);
        jTextField2.setBounds(230, 140, 240, 50);

        jButton3.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(540, 140, 100, 50);

        jLabel5.setFont(new java.awt.Font("Traditional Arabic", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Phrase");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 150, 110, 37);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(0, 270, 630, 0);
        jPanel2.add(jLabel7);
        jLabel7.setBounds(860, 170, 150, 190);
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(480, 240, 50, 10);
        jPanel2.add(jSeparator3);
        jSeparator3.setBounds(0, 240, 690, 10);
        jPanel2.add(jSeparator5);
        jSeparator5.setBounds(0, 250, 690, 10);
        jPanel2.add(jSeparator6);
        jSeparator6.setBounds(0, 260, 690, 50);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 98, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        biword();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            choose_files();
        } catch (IOException ex) {
            Logger.getLogger(Project_gui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        boolean_search();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Project_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Project_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Project_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Project_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Project_gui s = new Project_gui();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Project_gui().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

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

    }

    public void boolean_search() {
        ArrayList<String> query_steam = new ArrayList<>();
        hashQuery obg = new hashQuery();
        //  ArrayList<Integer> result1=  obg.search(jTextField1.getText(), inverted_hash);

        String txt = jTextField1.getText().toLowerCase(Locale.ENGLISH);
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

    public void biword() {
        String txt = jTextField2.getText();
        String arr[] = new String[jTextField2.getText().length()];
        arr = txt.split(" ");

        /////////////////////////////////////////////////////////////////////////////////
        for (int x = 0; x < list_of_files.length; x++) {
            try {
                String text = "";
                Scanner sc = new Scanner(list_of_files[x]);

                while (sc.hasNext()) {
                    r_tokens.add(sc.next());
                }
                sc.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

        }

        //////////////***********************************************//////////
        ///////////////////////  getting biwords ////////////////////////
        biword_index obj = new biword_index(arr, r_tokens);
        ArrayList<String> biTerm = new ArrayList<>();
        ArrayList<String> biQyery = new ArrayList<>();
        biTerm = obj.get_Term();
        biQyery = obj.get_Query();
        //////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////// clear reapting ///////////////////
        for (int y = 0; y < biQyery.size(); y++) {

            for (int e = y + 1; e < biQyery.size(); e++) {
                if (biQyery.get(y).equals(biQyery.get(e))) {
                    biQyery.remove(e);
                }

            }

        }

//        System.out.println(biTerm);
//        System.out.println(biQyery);
//        
        ///////////////////////////////////**********************************/////////////////
        /////////////////////////  filling the positing_words complete_hash   ////////////////////////////////////
        Hashtable<String, ArrayList<Integer>> hash = new Hashtable<>();

        for (int i = 0; i < biTerm.size(); i++) {
            ArrayList<Integer> num = new ArrayList<>();
            for (int j = 0; j < files_text.size(); j++) {
                if (files_text.get(j).contains(biTerm.get(i))) {
                    num.add(j);

                }
            }

            if (num.size() != 0) {
                hash.put(biTerm.get(i), num);
            }

        }
        //////////////////////////////////////////////////////////////////////////////////////////
        hashQuery obg = new hashQuery();
        String[] newquery = new String[biQyery.size()];
        for (int i = 0; i < biQyery.size(); i++) {
            newquery[i] = biQyery.get(i);
        }
        ArrayList<Integer> result = obg.multiAnd(newquery, hash);

        //System.out.println(result2);
        String array[] = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = list_of_files[result.get(i)].getAbsolutePath();
        }
        result obj2 = new result(array);
        obj2.setVisible(true);
    }


    }


