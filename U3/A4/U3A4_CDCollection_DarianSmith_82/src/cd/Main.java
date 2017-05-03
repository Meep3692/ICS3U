/*
Author: Darian
Date Modified: May 2, 2017
IDE: Netbeans 8.2
Program: Store, display, and modify a cd collection
File: GUI and logic
 */
package cd;

import csv.CSVTable;
import csv.TableEntry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Meep3_000
 */
public class Main extends javax.swing.JFrame {
    
    private ArrayList<CD> cds;
    
    private SortMethods sort = SortMethods.NONE;
    
    private boolean selectorRemove = false;
    private String currentPath;
    
    private void addCD(CD cd){
        cds.add(cd);
    }
    
    private void removeCD(CD cd){
        cds.remove(cd);
    }
    
    private void refreshTable(){
        CDTableModel model = (CDTableModel) collectionTable.getModel();
        switch(sort){
            case NONE:
                model.setCDs(cds);
                break;
            case TITLE:
                Collections.sort(cds, new CDTitleComparator());
                model.setCDs(cds);
                break;
            case ARTIST:
                Collections.sort(cds, new CDArtistComparator());
                model.setCDs(cds);
                break;
        }
    }
    
    private void save(String path){
        CSVTable table = new CSVTable(2);
        cds.forEach((cd) -> {
            table.addEntry(new TableEntry(new String[]{cd.artist, cd.title}));
        });
        try {
            table.save(path);
            currentPath = path;
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setTitle(path + " - CD Collection");
    }
    
    private void load(String path){
        cds = new ArrayList();
        try {
            CSVTable table = CSVTable.load(path);
            for(int i = 0; i < table.getWidth(); i++){
                cds.add(new CD(table.getCell(1, i), table.getCell(0, i)));
            }
            currentPath = path;
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshTable();
        this.setTitle(path + " - CD Collection");
    }
    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        collectionTable.setModel(new CDTableModel());
        cds = new ArrayList<>();
    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        fileChooser = new javax.swing.JFileChooser();
        sortButtonGroup = new javax.swing.ButtonGroup();
        cdSelectorFrame = new javax.swing.JFrame();
        artistSelectorLabel = new javax.swing.JLabel();
        artistSelectorField = new javax.swing.JTextField();
        titleSelectorLabel = new javax.swing.JLabel();
        titleSelectorField = new javax.swing.JTextField();
        confirmSelectorButton = new javax.swing.JButton();
        collectionScrollPane = new javax.swing.JScrollPane();
        collectionTable = new javax.swing.JTable();
        MenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newMenuItem = new javax.swing.JMenuItem();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        addMenuItem = new javax.swing.JMenuItem();
        removeMenuItem = new javax.swing.JMenuItem();
        sortMenu = new javax.swing.JMenu();
        sortNoneRadioButton = new javax.swing.JRadioButtonMenuItem();
        sortTitleRadioButton = new javax.swing.JRadioButtonMenuItem();
        sortArtistRadioButton = new javax.swing.JRadioButtonMenuItem();

        fileChooser.setCurrentDirectory(new java.io.File("C:\\Program Files\\NetBeans 8.2\\%homepath%"));
        fileChooser.setDialogTitle("Select File");
        fileChooser.setFileFilter(new FileNameExtensionFilter("CD Collection","cdc"));

        cdSelectorFrame.setMinimumSize(new java.awt.Dimension(300, 200));
        java.awt.GridBagLayout cdSelectorFrameLayout = new java.awt.GridBagLayout();
        cdSelectorFrameLayout.columnWeights = new double[] {0.0, 1.0};
        cdSelectorFrame.getContentPane().setLayout(cdSelectorFrameLayout);

        artistSelectorLabel.setText("Artist");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        cdSelectorFrame.getContentPane().add(artistSelectorLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        cdSelectorFrame.getContentPane().add(artistSelectorField, gridBagConstraints);

        titleSelectorLabel.setText("Title");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        cdSelectorFrame.getContentPane().add(titleSelectorLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        cdSelectorFrame.getContentPane().add(titleSelectorField, gridBagConstraints);

        confirmSelectorButton.setText("Add");
        confirmSelectorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmSelectorButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        cdSelectorFrame.getContentPane().add(confirmSelectorButton, gridBagConstraints);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CD Collection");

        collectionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        collectionScrollPane.setViewportView(collectionTable);

        fileMenu.setText("File");

        newMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newMenuItem.setText("New");
        newMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(newMenuItem);

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenuItem.setText("Open");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenuItem.setText("Save");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveAsMenuItem.setText("Save As");
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenuItem);

        addMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        addMenuItem.setText("Add CD");
        addMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(addMenuItem);

        removeMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        removeMenuItem.setText("Remove CD");
        removeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(removeMenuItem);

        MenuBar.add(fileMenu);

        sortMenu.setText("Sort");

        sortButtonGroup.add(sortNoneRadioButton);
        sortNoneRadioButton.setSelected(true);
        sortNoneRadioButton.setText("None");
        sortNoneRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortNoneRadioButtonActionPerformed(evt);
            }
        });
        sortMenu.add(sortNoneRadioButton);

        sortButtonGroup.add(sortTitleRadioButton);
        sortTitleRadioButton.setText("Title");
        sortTitleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortTitleRadioButtonActionPerformed(evt);
            }
        });
        sortMenu.add(sortTitleRadioButton);

        sortButtonGroup.add(sortArtistRadioButton);
        sortArtistRadioButton.setText("Artist");
        sortArtistRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortArtistRadioButtonActionPerformed(evt);
            }
        });
        sortMenu.add(sortArtistRadioButton);

        MenuBar.add(sortMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(collectionScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(collectionScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenuItemActionPerformed
        selectorRemove = false;
        cdSelectorFrame.setTitle("Add CD");
        confirmSelectorButton.setText("Add");
        artistSelectorField.setText("");
        titleSelectorField.setText("");
        cdSelectorFrame.setVisible(true);
    }//GEN-LAST:event_addMenuItemActionPerformed

    private void removeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeMenuItemActionPerformed
        selectorRemove = true;
        cdSelectorFrame.setTitle("Remove CD");
        confirmSelectorButton.setText("Remove");
        artistSelectorField.setText("");
        titleSelectorField.setText("");
        cdSelectorFrame.setVisible(true);
    }//GEN-LAST:event_removeMenuItemActionPerformed

    private void confirmSelectorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmSelectorButtonActionPerformed
        CD cd = new CD(titleSelectorField.getText(), artistSelectorField.getText());//Declare new cd
        if(selectorRemove)//If we were removing
            removeCD(cd);//Remove CD
        else//We were adding
            addCD(cd);//Add cd
        refreshTable();//Refresh
        cdSelectorFrame.setVisible(false);//Close cd selector
    }//GEN-LAST:event_confirmSelectorButtonActionPerformed

    private void sortNoneRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortNoneRadioButtonActionPerformed
        sort = SortMethods.NONE;//Set sort method
        refreshTable();//Refesh so it takes effect
    }//GEN-LAST:event_sortNoneRadioButtonActionPerformed

    private void sortTitleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortTitleRadioButtonActionPerformed
        sort = SortMethods.TITLE;//Set sort method
        refreshTable();//Refresh so it takes effect
    }//GEN-LAST:event_sortTitleRadioButtonActionPerformed

    private void sortArtistRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortArtistRadioButtonActionPerformed
        sort = SortMethods.ARTIST;//Set sort method
        refreshTable();//Refresh to allow it to take effect
    }//GEN-LAST:event_sortArtistRadioButtonActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        int returnVal = fileChooser.showDialog(this, "Open");//Open the file chooser
        if(returnVal == JFileChooser.APPROVE_OPTION){//If they hit save
            load(fileChooser.getSelectedFile().getAbsolutePath());//Open the file selected by the file chooser
        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
        int returnVal = fileChooser.showDialog(this, "Save");//Open the file chooser
        if(returnVal == JFileChooser.APPROVE_OPTION){//If they hit save
            save(fileChooser.getSelectedFile().getAbsolutePath());//save to the path given by the file chooser
        }
    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        if(!"".equals(currentPath))//Make sure there's a path
            save(currentPath);//Save to the open file
        else
            saveAsMenuItemActionPerformed(evt);//Pretend we pressed the Save As button
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void newMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMenuItemActionPerformed
        cds = new ArrayList();
        currentPath = "";
        refreshTable();
        this.setTitle("CD Collection");
    }//GEN-LAST:event_newMenuItemActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem addMenuItem;
    private javax.swing.JTextField artistSelectorField;
    private javax.swing.JLabel artistSelectorLabel;
    private javax.swing.JFrame cdSelectorFrame;
    private javax.swing.JScrollPane collectionScrollPane;
    private javax.swing.JTable collectionTable;
    private javax.swing.JButton confirmSelectorButton;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem newMenuItem;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem removeMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JRadioButtonMenuItem sortArtistRadioButton;
    private javax.swing.ButtonGroup sortButtonGroup;
    private javax.swing.JMenu sortMenu;
    private javax.swing.JRadioButtonMenuItem sortNoneRadioButton;
    private javax.swing.JRadioButtonMenuItem sortTitleRadioButton;
    private javax.swing.JTextField titleSelectorField;
    private javax.swing.JLabel titleSelectorLabel;
    // End of variables declaration//GEN-END:variables
}
