/*
Author: Darian
Date Modified: March 2, 2017
Program: User inputs name and birthday. When the button is pressed, it outputs [NAME]'s birthday is on [BIRTHDAY]
File: GUI: the part the user sees and also the part that does the logic
*/
package birthday;

import java.awt.Toolkit;

public class GUI extends javax.swing.JFrame {
    
    /**
     * Creates new form GUI
     */
    public GUI() {
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

        BirthdayLabel = new javax.swing.JLabel();
        NameLabel = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        BirthdayField = new javax.swing.JTextField();
        OutputLabel = new javax.swing.JLabel();
        SubmitButton = new javax.swing.JButton();
        BGImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Birthday-matic 9000");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/res/Portal_Cake.png")));
        setPreferredSize(new java.awt.Dimension(500, 300));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BirthdayLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        BirthdayLabel.setText("Enter Your Birthday:");
        BirthdayLabel.setAlignmentX(1.0F);
        BirthdayLabel.setMaximumSize(new java.awt.Dimension(100, 14));
        BirthdayLabel.setMinimumSize(new java.awt.Dimension(100, 14));
        BirthdayLabel.setPreferredSize(new java.awt.Dimension(100, 14));
        getContentPane().add(BirthdayLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 170, 30));

        NameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NameLabel.setText("Enter Your Name:");
        NameLabel.setAlignmentX(1.0F);
        getContentPane().add(NameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 170, 30));

        Title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Title.png"))); // NOI18N
        getContentPane().add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, -1));

        NameField.setText("Fred Durst");
        NameField.setPreferredSize(new java.awt.Dimension(35, 20));
        getContentPane().add(NameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 150, 30));

        BirthdayField.setText("August 20th");
        BirthdayField.setPreferredSize(new java.awt.Dimension(35, 20));
        getContentPane().add(BirthdayField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 150, 30));

        OutputLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OutputLabel.setText("Fred Durst's birthday is on August 20th");
        OutputLabel.setAlignmentX(0.5F);
        OutputLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(OutputLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 500, 20));

        SubmitButton.setText("Enter");
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(SubmitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, -1, -1));

        BGImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Portal_Cake.png"))); // NOI18N
        getContentPane().add(BGImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Set the output text when the enter button is pressed
    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
        String name = NameField.getText();
        String birthday = BirthdayField.getText();
        OutputLabel.setText(name + "'s birthday is on " + birthday);
    }//GEN-LAST:event_SubmitButtonActionPerformed
    
   
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGImage;
    private javax.swing.JTextField BirthdayField;
    private javax.swing.JLabel BirthdayLabel;
    private javax.swing.JTextField NameField;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JLabel OutputLabel;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JLabel Title;
    // End of variables declaration//GEN-END:variables
}
