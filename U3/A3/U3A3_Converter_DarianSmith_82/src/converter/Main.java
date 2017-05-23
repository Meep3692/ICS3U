/*
Author: Darian
Date Modified: April 18, 2017
IDE: Netbeans 8.2
Program: Convert between linear measurment units
File: GUI and logic
 */
package converter;

import java.text.DecimalFormat;
import javax.swing.DefaultComboBoxModel;

/**
 *Main GUI and other gubbons
 * @author Meep3_000
 */
public class Main extends javax.swing.JFrame {
    /**
     * Get the proper abbreviation of a unit
     * @param unit Unit to get abbreviation of
     * @return Abbreviation of given unit
     */
    private String getUnitPrettyShort(Units unit){
        switch(unit){
            case CENTIMETRES:
                return "cm";
            case METRES:
                return "m";
            case KILOMETRES:
                return "km";
            case INCHES:
                return "\"";
            case FEET:
                return "'";
            case YARDS:
                return "yd";
            case MILES:
                return "mi";
            default:
                return "";
        }
    }
    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
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

        titleLabel = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        convertLabel = new javax.swing.JLabel();
        intoLabel = new javax.swing.JLabel();
        inputField = new javax.swing.JTextField();
        fromUnitComboBox = new javax.swing.JComboBox<>();
        toUnitComboBox = new javax.swing.JComboBox<>();
        confirmButton = new javax.swing.JButton();
        outputLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Edwardian Script ITC", 0, 48)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Unit Converter");

        java.awt.GridBagLayout contentPanelLayout = new java.awt.GridBagLayout();
        contentPanelLayout.columnWidths = new int[] {70, 70, 70};
        contentPanel.setLayout(contentPanelLayout);

        convertLabel.setText("Convert");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        contentPanel.add(convertLabel, gridBagConstraints);

        intoLabel.setText("into");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        contentPanel.add(intoLabel, gridBagConstraints);

        inputField.setToolTipText("Units");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        contentPanel.add(inputField, gridBagConstraints);

        fromUnitComboBox.setModel(new DefaultComboBoxModel(Units.values()));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        contentPanel.add(fromUnitComboBox, gridBagConstraints);

        toUnitComboBox.setModel(new DefaultComboBoxModel(Units.values()));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        contentPanel.add(toUnitComboBox, gridBagConstraints);

        confirmButton.setText("Convert");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        contentPanel.add(confirmButton, gridBagConstraints);

        outputLabel.setText("0 cm is 0 cm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        contentPanel.add(outputLabel, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Occurs when the convert button is pressed
     * @param evt Action event args (not actually used)
     */
    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        Units from, to;//Declare vars
        double inValue, outValue;
        Converter converter;
        DecimalFormat formater;
        
        from = (Units)fromUnitComboBox.getSelectedItem();//Get selection from clever enum modeled combo boxes
        to = (Units)toUnitComboBox.getSelectedItem();
        
        converter = new Converter(from, to);//Create new unit converter
        formater = new DecimalFormat("#.####");//Create new decimal formater
        
        inValue = Double.parseDouble(inputField.getText());//Get input value
        outValue = converter.convert(inValue);//Convert to get output
        outputLabel.setText(formater.format(inValue) + getUnitPrettyShort(from) + " is " + formater.format(outValue) + getUnitPrettyShort(to));//Set output
    }//GEN-LAST:event_confirmButtonActionPerformed

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
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmButton;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel convertLabel;
    private javax.swing.JComboBox<String> fromUnitComboBox;
    private javax.swing.JTextField inputField;
    private javax.swing.JLabel intoLabel;
    private javax.swing.JLabel outputLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JComboBox<String> toUnitComboBox;
    // End of variables declaration//GEN-END:variables
}
