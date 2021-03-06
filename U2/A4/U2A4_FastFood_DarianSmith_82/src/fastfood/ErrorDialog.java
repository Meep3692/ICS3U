/*
Author: Darian
Date Modified: March 20, 2017
IDE: Netbeans 8.2
Program: Calculate the cost and change of a fast food order
File: Error handling dialog box
 */
package fastfood;

/**
 *
 * @author Meep3_000
 */
public class ErrorDialog extends javax.swing.JFrame {

    /**
     * Creates new form ErrorDialog
     * @param e Exception to display
     */
    public ErrorDialog(Exception e) {
        initComponents();
        this.setTitle(e.getClass().getName());
        String details = "";
        details += e.getLocalizedMessage() + "\n\n";//Exception message
        details += e.getClass().getTypeName() + ":\n\t";//Excepion type
        StackTraceElement[] stackTrace = e.getStackTrace();
        for(StackTraceElement element : stackTrace){//loop through stacktrace to add to details
            details += element.toString() + "\n\t";
        }
        detailsText.setText(details);//set text in dialogue
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        detailsScrollPane = new javax.swing.JScrollPane();
        detailsText = new javax.swing.JTextArea();
        errorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        detailsText.setColumns(20);
        detailsText.setRows(5);
        detailsScrollPane.setViewportView(detailsText);

        errorLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLabel.setText("An exception has occurred");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(detailsScrollPane))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane detailsScrollPane;
    private javax.swing.JTextArea detailsText;
    private javax.swing.JLabel errorLabel;
    // End of variables declaration//GEN-END:variables
}
