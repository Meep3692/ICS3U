/*
Author: Darian
Date Modified: March 27, 2017
IDE: Netbeans 8.2
Program: Guessing game, generates random number and lets the use guess
File: GUI and logic
 */
package guess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author Meep3_000
 */
public class Main extends javax.swing.JFrame {
    
    int randValue;//The value to guess
    int minValue = 0;//Min and max values
    int maxValue = 100;
    int guesses = 0;//Current number of guesses
    
    DefaultTableModel historyModel;//This has "addRow" but jTable doesn't
    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        historyModel=new DefaultTableModel(new Object[]{"Guess", "High/Low", "Heat"}, 0){//Create a new DefaultTableModel to use for our history
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; //Prevent editing the cells
            }
        };
        historyTable.setModel(historyModel);//Set the table to use our new table model
        newGame();//Start a new game
        setHelpTopic("General");
    }
    
    private void newGame(){
        randValue = (int) Math.round(Math.random() * (double)(maxValue - minValue) + minValue);//Reset number
        guesses = 0;//Reset score
        
        while(historyModel.getRowCount() > 0){
            historyModel.removeRow(0);//Remove all the rows from the history
        }
        highLowLabel.setText("Too not yet started!");//Reset the labels and bar
        heatLabel.setText("Very cold and lonely");
        heatBar.setValue(0);
    }
    
    private void setHelpTopic(String name){
        try {
            BufferedReader fileReader;//Create the stream we will need to load the help file
            String fileString = "";//The string to store the text data from the file
            InputStreamReader tempReader;//Java really likes you converting streams
            tempReader = new InputStreamReader(this.getClass().getResourceAsStream("/res/html/" + name + ".html"), "ASCII");//Put the input stream into the reader
            fileReader = new BufferedReader(tempReader);//Put the reader into a buffered reader
            for(String line = ""; line != null; line = fileReader.readLine()){//Read all lines
                fileString += line;//Append lines to string
            }
            fileString = fileString.substring(fileString.indexOf("<html>"));//Remove erroneous leading characters
            fileString = fileString.replace("/res/", this.getClass().getResource("/res/").toString());//Fix image urls
            helpContentLabel.setText(fileString);//Set the label
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        optionsFrame = new javax.swing.JFrame();
        contentPanel = new javax.swing.JPanel();
        minLabel = new javax.swing.JLabel();
        maxLabel = new javax.swing.JLabel();
        minField = new javax.swing.JTextField();
        maxField = new javax.swing.JTextField();
        buttonsPanel = new javax.swing.JPanel();
        applyButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        helpFrame = new javax.swing.JFrame();
        topicsScrollPane = new javax.swing.JScrollPane();
        topicsTree = new javax.swing.JTree();
        helpTopicScrollPane = new javax.swing.JScrollPane();
        helpContentLabel = new javax.swing.JLabel();
        historyScrollPane = new javax.swing.JScrollPane();
        historyTable = new javax.swing.JTable();
        guessLabel = new javax.swing.JLabel();
        guessField = new javax.swing.JTextField();
        guessButton = new javax.swing.JButton();
        highLowLabel = new javax.swing.JLabel();
        heatTitleLabel = new javax.swing.JLabel();
        heatBar = new javax.swing.JProgressBar();
        heatLabel = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        gameMenu = new javax.swing.JMenu();
        newGameMenuButton = new javax.swing.JMenuItem();
        optionsMenuButton = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenu();
        helpMenuButton = new javax.swing.JMenuItem();

        optionsFrame.setTitle("Options");
        optionsFrame.setMinimumSize(new java.awt.Dimension(300, 200));

        java.awt.GridBagLayout contentPanelLayout = new java.awt.GridBagLayout();
        contentPanelLayout.columnWidths = new int[] {70, 70};
        contentPanel.setLayout(contentPanelLayout);

        minLabel.setText("Min Value:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        contentPanel.add(minLabel, gridBagConstraints);

        maxLabel.setText("Max Value:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        contentPanel.add(maxLabel, gridBagConstraints);

        minField.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        contentPanel.add(minField, gridBagConstraints);

        maxField.setText("100");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        contentPanel.add(maxField, gridBagConstraints);

        buttonsPanel.setLayout(new java.awt.GridBagLayout());

        applyButton.setText("Apply");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(applyButton, new java.awt.GridBagConstraints());

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(cancelButton, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        contentPanel.add(buttonsPanel, gridBagConstraints);

        javax.swing.GroupLayout optionsFrameLayout = new javax.swing.GroupLayout(optionsFrame.getContentPane());
        optionsFrame.getContentPane().setLayout(optionsFrameLayout);
        optionsFrameLayout.setHorizontalGroup(
            optionsFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        optionsFrameLayout.setVerticalGroup(
            optionsFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        helpFrame.setTitle("Help");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Help Topics");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("How to play");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("General");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Heat Meanings");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("User interface");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("History");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Controls");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        topicsTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        topicsTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                topicsTreeMouseReleased(evt);
            }
        });
        topicsScrollPane.setViewportView(topicsTree);

        helpContentLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        helpContentLabel.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        helpTopicScrollPane.setViewportView(helpContentLabel);

        javax.swing.GroupLayout helpFrameLayout = new javax.swing.GroupLayout(helpFrame.getContentPane());
        helpFrame.getContentPane().setLayout(helpFrameLayout);
        helpFrameLayout.setHorizontalGroup(
            helpFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(helpFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(topicsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(helpTopicScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );
        helpFrameLayout.setVerticalGroup(
            helpFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(helpFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(helpFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(helpFrameLayout.createSequentialGroup()
                        .addComponent(helpTopicScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(helpFrameLayout.createSequentialGroup()
                        .addComponent(topicsScrollPane)
                        .addGap(14, 14, 14))))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Guessing Game");

        historyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Guess", "High/Low", "Amount"
            }
        ));
        historyScrollPane.setViewportView(historyTable);

        guessLabel.setText("Guess:");

        guessField.setText("0");

        guessButton.setText("Guess!");
        guessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessButtonActionPerformed(evt);
            }
        });

        highLowLabel.setText("Too not yet started!");

        heatTitleLabel.setText("Heat:");

        heatBar.setMaximum(6);

        heatLabel.setText("Very cold and lonely");

        gameMenu.setText("Game");

        newGameMenuButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newGameMenuButton.setText("New Game");
        newGameMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameMenuButtonActionPerformed(evt);
            }
        });
        gameMenu.add(newGameMenuButton);

        optionsMenuButton.setText("Options");
        optionsMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionsMenuButtonActionPerformed(evt);
            }
        });
        gameMenu.add(optionsMenuButton);

        MenuBar.add(gameMenu);

        aboutMenu.setText("About");

        helpMenuButton.setText("Help");
        helpMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuButtonActionPerformed(evt);
            }
        });
        aboutMenu.add(helpMenuButton);

        MenuBar.add(aboutMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(historyScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(guessLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(guessField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(guessButton))
                    .addComponent(highLowLabel)
                    .addComponent(heatTitleLabel)
                    .addComponent(heatBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(heatLabel))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(historyScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guessLabel)
                    .addComponent(guessField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guessButton)
                .addGap(18, 18, 18)
                .addComponent(highLowLabel)
                .addGap(18, 18, 18)
                .addComponent(heatTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(heatBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(heatLabel)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newGameMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameMenuButtonActionPerformed
        newGame();//Start new game
    }//GEN-LAST:event_newGameMenuButtonActionPerformed

    private void optionsMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionsMenuButtonActionPerformed
        minField.setText(Integer.toString(minValue));//Set the fields to display the current options
        maxField.setText(Integer.toString(maxValue));
        optionsFrame.setVisible(true);//Show options
    }//GEN-LAST:event_optionsMenuButtonActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        minValue = Integer.parseInt(minField.getText());//Set the values to the new settings
        maxValue = Integer.parseInt(maxField.getText());
        optionsFrame.setVisible(false);//Hide the options
    }//GEN-LAST:event_applyButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        optionsFrame.setVisible(false);//Hide options without setting them
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void guessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guessButtonActionPerformed
        int guess;//Value of guess
        int diff;//How much they were off by
        guess = Integer.parseInt(guessField.getText());
        if(guess == randValue){
            highLowLabel.setText("Perfect!");
            heatLabel.setText("Plasmatic!");
            heatBar.setValue(6);
        }else{
            if(guess > randValue){
                highLowLabel.setText("Too high!");
            }else{
                highLowLabel.setText("Too low!");
            }
            diff = (int) Math.abs(randValue - guess);
            if(diff > 50){
                heatLabel.setText("Freezing!");
                heatBar.setValue(0);
            }else if(diff > 25){
                heatLabel.setText("Cold!");
                heatBar.setValue(1);
            }else if(diff > 15){
                heatLabel.setText("Cool!");
                heatBar.setValue(2);
            }else if(diff > 10){
                heatLabel.setText("Warm!");
                heatBar.setValue(3);
            }else if(diff > 5){
                heatLabel.setText("Hot!");
                heatBar.setValue(4);
            }else{
                heatLabel.setText("Boiling!");
                heatBar.setValue(5);
            }
        }
        historyModel.addRow(new Object[]{Integer.toString(guess), highLowLabel.getText(), heatLabel.getText()});//Add row with history
    }//GEN-LAST:event_guessButtonActionPerformed

    private void helpMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuButtonActionPerformed
        helpFrame.setSize(400, 300);
        helpFrame.setVisible(true);
    }//GEN-LAST:event_helpMenuButtonActionPerformed

    private void topicsTreeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topicsTreeMouseReleased
        TreePath selectionPath = topicsTree.getSelectionPath();//Get the path to the currently selected node
        setHelpTopic(selectionPath.getLastPathComponent().toString());//Set the help topic to the currently selected node
        //helpContentLabel.setText("<html><head></head><body><b>Wobble</b></body></html>");
    }//GEN-LAST:event_topicsTreeMouseReleased

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JButton applyButton;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JMenu gameMenu;
    private javax.swing.JButton guessButton;
    private javax.swing.JTextField guessField;
    private javax.swing.JLabel guessLabel;
    private javax.swing.JProgressBar heatBar;
    private javax.swing.JLabel heatLabel;
    private javax.swing.JLabel heatTitleLabel;
    private javax.swing.JLabel helpContentLabel;
    private javax.swing.JFrame helpFrame;
    private javax.swing.JMenuItem helpMenuButton;
    private javax.swing.JScrollPane helpTopicScrollPane;
    private javax.swing.JLabel highLowLabel;
    private javax.swing.JScrollPane historyScrollPane;
    private javax.swing.JTable historyTable;
    private javax.swing.JTextField maxField;
    private javax.swing.JLabel maxLabel;
    private javax.swing.JTextField minField;
    private javax.swing.JLabel minLabel;
    private javax.swing.JMenuItem newGameMenuButton;
    private javax.swing.JFrame optionsFrame;
    private javax.swing.JMenuItem optionsMenuButton;
    private javax.swing.JScrollPane topicsScrollPane;
    private javax.swing.JTree topicsTree;
    // End of variables declaration//GEN-END:variables
}
