/*
Author: Darian
Date Modified: March 9, 2017
IDE: Netbeans 8.2
Program: Calculates pizza price based on size
File: GUI and logic
 */
package pizza;

import java.text.DecimalFormat;

/**
 *
 * @author Meep3_000
 */
public class Main extends javax.swing.JFrame {
    
    DecimalFormat moneyFormat;
    float labourCost = 1.00f;
    float storeCost = 1.50f;
    float materialMultiplier = 0.50f;
    
    /**
     * Creates new form Main
     */
    public Main() {
        moneyFormat = new DecimalFormat("$#0.00");
        initComponents();
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

        errorDialogue = new javax.swing.JDialog();
        errorLabel = new javax.swing.JLabel();
        detailsScrollPane = new javax.swing.JScrollPane();
        detailsText = new javax.swing.JTextArea();
        titleLabel = new javax.swing.JLabel();
        controlsPanel = new javax.swing.JPanel();
        sizeLabel = new javax.swing.JLabel();
        sizeField = new javax.swing.JTextField();
        calculateButton = new javax.swing.JButton();
        outputLabel = new javax.swing.JLabel();

        errorDialogue.setMinimumSize(new java.awt.Dimension(400, 200));
        errorDialogue.setModal(true);
        errorDialogue.setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        errorDialogue.setPreferredSize(new java.awt.Dimension(400, 200));
        errorDialogue.setType(java.awt.Window.Type.POPUP);

        errorLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLabel.setText("Error in parsing size:");

        detailsText.setColumns(20);
        detailsText.setRows(5);
        detailsScrollPane.setViewportView(detailsText);

        javax.swing.GroupLayout errorDialogueLayout = new javax.swing.GroupLayout(errorDialogue.getContentPane());
        errorDialogue.getContentPane().setLayout(errorDialogueLayout);
        errorDialogueLayout.setHorizontalGroup(
            errorDialogueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(errorDialogueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(detailsScrollPane)
                .addContainerGap())
        );
        errorDialogueLayout.setVerticalGroup(
            errorDialogueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(errorDialogueLayout.createSequentialGroup()
                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Edwardian Script ITC", 0, 48)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Pizza Price Calculator");

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {100, 100};
        jPanel1Layout.columnWeights = new double[] {0.5, 0.5};
        controlsPanel.setLayout(jPanel1Layout);

        sizeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sizeLabel.setText("Diameter of Pizza in Inches:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        controlsPanel.add(sizeLabel, gridBagConstraints);

        sizeField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        sizeField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sizeField.setPreferredSize(new java.awt.Dimension(50, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        controlsPanel.add(sizeField, gridBagConstraints);

        calculateButton.setText("Calculate");
        calculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        controlsPanel.add(calculateButton, gridBagConstraints);

        outputLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        outputLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
            .addComponent(controlsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(outputLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addGap(26, 26, 26)
                .addComponent(controlsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(outputLabel)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateButtonActionPerformed
        float diameter;
        try{//Try to parse diameter
            diameter = Float.parseFloat(sizeField.getText());
        }catch(NumberFormatException e){//Catch error and display as dialogue box with stack trace
            String details = "";
            details += e.getLocalizedMessage() + "\n\n";//Exception message
            details += e.getClass().getTypeName() + ":\n\t";//Excepion type
            StackTraceElement[] stackTrace = e.getStackTrace();
            for(StackTraceElement element : stackTrace){//loop through stacktrace to add to details
                details += element.toString() + "\n\t";
            }
            detailsText.setText(details);//set text in dialogue
            errorDialogue.setVisible(true);//show dialogue
            return;//stop doing things
        }
        float cost = labourCost + storeCost + (diameter * materialMultiplier);//Calculate cost
        outputLabel.setText("The cost of the pizza is " + moneyFormat.format(cost));//Format and display cost
    }//GEN-LAST:event_calculateButtonActionPerformed

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
    private javax.swing.JButton calculateButton;
    private javax.swing.JPanel controlsPanel;
    private javax.swing.JScrollPane detailsScrollPane;
    private javax.swing.JTextArea detailsText;
    private javax.swing.JDialog errorDialogue;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel outputLabel;
    private javax.swing.JTextField sizeField;
    private javax.swing.JLabel sizeLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
