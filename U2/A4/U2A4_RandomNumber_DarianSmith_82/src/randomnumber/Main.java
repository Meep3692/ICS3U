/*
Author: Darian
Date Modified: March 21, 2017
IDE: Netbeans 8.2
Program: Generates a random number based on a user-provided minimum and maximum value
File:GUI and most logic
 */
package randomnumber;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author John
 */
public class Main extends javax.swing.JFrame {
    
    private float min, max;
    private int precision;
    private DecimalFormat format;
    private WaveFile music;
    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        leftAmpBar.setMaximum(65535);//Set bars to display properly
        rightAmpBar.setMaximum(65535);
    }
    
    public void start(){
        Thread t;
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();//Record start and end times and initialize current time
                long currentTime = 0;
                long endTime = startTime + 21000;
                music.play();
                while(System.currentTimeMillis() < endTime){
                    currentTime = System.currentTimeMillis() - startTime;//Find time elapsed
                    int samplePos = (int)(((float)currentTime / 1000) * music.getSampleRate());//Find to position of the currently playing sample
                    if(samplePos % 2 == 0){//Check if it's in the left channel
                        leftAmpBar.setValue(music.getSampleInt(samplePos));//Set left bar to amplitude
                    }else{//Must be in right channel
                        rightAmpBar.setValue(music.getSampleInt(samplePos));//Set right bar to amplitude
                    }
                    if(currentTime % 100 < 20){//About every 100 milliseconds
                        float rand = (float) (Math.random() * (max - min) + min);//Find random number
                        outputLabel.setText(format.format(rand));//Update output
                    }
                    try {
                        Thread.sleep(10);//A bit of delay so it doesn't completely freak out
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                leftAmpBar.setValue(0);//Reset bars to 0
                rightAmpBar.setValue(0);
            }
        });
        t.start();
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

        titleLabel = new javax.swing.JLabel();
        leftAmpBar = new javax.swing.JProgressBar();
        rightAmpBar = new javax.swing.JProgressBar();
        conentPanel = new javax.swing.JPanel();
        minLabel = new javax.swing.JLabel();
        minField = new javax.swing.JTextField();
        maxLabel = new javax.swing.JLabel();
        maxField = new javax.swing.JTextField();
        precisionLabel = new javax.swing.JLabel();
        precisionField = new javax.swing.JTextField();
        confirmButton = new javax.swing.JButton();
        outputLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Randulator");

        titleLabel.setFont(new java.awt.Font("Felix Titling", 0, 36)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Randulator");

        leftAmpBar.setOrientation(1);

        rightAmpBar.setOrientation(1);

        java.awt.GridBagLayout conentPanelLayout = new java.awt.GridBagLayout();
        conentPanelLayout.columnWidths = new int[] {70, 70};
        conentPanelLayout.rowHeights = new int[] {30, 30, 30, 30, 30};
        conentPanel.setLayout(conentPanelLayout);

        minLabel.setText("Minimum");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        conentPanel.add(minLabel, gridBagConstraints);

        minField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        minField.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        conentPanel.add(minField, gridBagConstraints);

        maxLabel.setText("Maximum");
        maxLabel.setAlignmentX(1.0F);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        conentPanel.add(maxLabel, gridBagConstraints);

        maxField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        maxField.setText("1");
        maxField.setAlignmentX(1.0F);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        conentPanel.add(maxField, gridBagConstraints);

        precisionLabel.setText("Places after Decimal:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        conentPanel.add(precisionLabel, gridBagConstraints);

        precisionField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        precisionField.setText("3");
        precisionField.setMinimumSize(new java.awt.Dimension(6, 30));
        precisionField.setPreferredSize(new java.awt.Dimension(70, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        conentPanel.add(precisionField, gridBagConstraints);

        confirmButton.setText("Randulate!");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        conentPanel.add(confirmButton, gridBagConstraints);

        outputLabel.setFont(new java.awt.Font("Felix Titling", 0, 36)); // NOI18N
        outputLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        outputLabel.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(leftAmpBar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(conentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(outputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rightAmpBar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftAmpBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rightAmpBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(conentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        try {
            music = new WaveFile("/res/sound/Danse Macabre - Finale.aiff");//Load audio file
        } catch (UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        min = Float.parseFloat(minField.getText());//Parse min and max values
        max = Float.parseFloat(maxField.getText());
        precision = Integer.parseInt(precisionField.getText());//Pase precision
        String formatString = "0";
        if(precision > 0){
            formatString += ".";
            for(int i = 0; i < precision; i++){//Setup format string
                formatString += "0";
            }
        }
        format = new DecimalFormat(formatString);//Set the decimal format to use the apropriate number of decimal places
        start();//Start the thread for fanfare and random numbers
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
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel conentPanel;
    private javax.swing.JButton confirmButton;
    private javax.swing.JProgressBar leftAmpBar;
    private javax.swing.JTextField maxField;
    private javax.swing.JLabel maxLabel;
    private javax.swing.JTextField minField;
    private javax.swing.JLabel minLabel;
    private javax.swing.JLabel outputLabel;
    private javax.swing.JTextField precisionField;
    private javax.swing.JLabel precisionLabel;
    private javax.swing.JProgressBar rightAmpBar;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
