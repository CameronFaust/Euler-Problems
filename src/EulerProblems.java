
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import problems.DoProblems;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EulerProblems.java
 *
 * Created on Dec 3, 2011, 1:55:11 PM
 */
/**
 *
 * @author Cameron
 */
public class EulerProblems extends javax.swing.JFrame {

     private static DoProblems doProblem;
     private int selectedProblem;
     private String[] problemInfo = new String[300];

     /** Creates new form EulerProblems */
     public EulerProblems() {
          initComponents();
          this.pack();
          this.setLocationRelativeTo(null);
          updateProblemList();
          doProblem = new DoProblems();
          selectedProblem = 3;
          problemSelectionJSpinner.getModel().addChangeListener(new ChangeListener() {

               @Override
               public void stateChanged(ChangeEvent e) {
                    selectedProblem = Integer.parseInt(problemSelectionJSpinner.getModel().getValue().toString());
                    outputJTextArea.setText(problemInfo[selectedProblem]);
               }
          });
     }

     /** This method is called from within the constructor to
      * initialize the form.
      * WARNING: Do NOT modify this code. The content of this method is
      * always regenerated by the Form Editor.
      */
     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        outputJTextArea = new javax.swing.JTextArea();
        quitJButton = new javax.swing.JButton();
        doProblemJButton = new javax.swing.JButton();
        problemSelectionJSpinner = new javax.swing.JSpinner();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(400, 200), new java.awt.Dimension(400, 200), new java.awt.Dimension(400, 200));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Euler Problems");
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        outputJTextArea.setColumns(20);
        outputJTextArea.setEditable(false);
        outputJTextArea.setFont(new java.awt.Font("Lucida Console", 0, 12));
        outputJTextArea.setLineWrap(true);
        outputJTextArea.setRows(5);
        outputJTextArea.setText("Euler Problems Solved by Cameron Faust");
        outputJTextArea.setPreferredSize(new java.awt.Dimension(300, 150));
        jScrollPane1.setViewportView(outputJTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 3, 6);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        quitJButton.setFont(new java.awt.Font("Lucida Console", 0, 12));
        quitJButton.setText("Quit");
        quitJButton.setPreferredSize(new java.awt.Dimension(75, 21));
        quitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 6, 6);
        getContentPane().add(quitJButton, gridBagConstraints);

        doProblemJButton.setFont(new java.awt.Font("Lucida Console", 0, 12));
        doProblemJButton.setText("Do Problem");
        doProblemJButton.setPreferredSize(new java.awt.Dimension(115, 21));
        doProblemJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doProblemJButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 6, 3);
        getContentPane().add(doProblemJButton, gridBagConstraints);

        problemSelectionJSpinner.setFont(new java.awt.Font("Lucida Console", 0, 12));
        problemSelectionJSpinner.setModel(new javax.swing.SpinnerNumberModel(3, 3, 100, 1));
        problemSelectionJSpinner.setPreferredSize(new java.awt.Dimension(50, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 6, 6, 3);
        getContentPane().add(problemSelectionJSpinner, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        getContentPane().add(filler1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void updateProblemList() {
          final File problemList = new File("src/problems.txt");
          int currProblem = 0;
          String line = "";
          try {
               FileReader fileReader = new FileReader(problemList);
               BufferedReader bufferedReader = new BufferedReader(fileReader);
               while ((line = bufferedReader.readLine()) != null) {
                    if (line.startsWith("#")) {
                         currProblem = Integer.parseInt(line.substring(1));
                         line = bufferedReader.readLine();
                    }
                    problemInfo[currProblem] = line;
               }
               fileReader.close();
               bufferedReader.close();
          } catch (IOException ex) {
               outputJTextArea.setText("Error reading " + problemList.getPath() + ".");
          }
     }

     private void doProblemJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doProblemJButtonActionPerformed
          outputJTextArea.setText("");
          switch (selectedProblem) {
               case 3:
                    outputJTextArea.setText("The largest prime factor of 600851475143 is: " + doProblem.problemThree());
                    break;
               case 4:
                    outputJTextArea.setText(doProblem.problemFour());
                    break;
               case 5:
                    outputJTextArea.setText(doProblem.problemFive());
                    break;
               case 6:
                    outputJTextArea.setText(doProblem.problemSix());
                    break;
               case 7:
                    outputJTextArea.setText(doProblem.problemSeven());
                    break;
               case 8:
                    outputJTextArea.setText(doProblem.problemEight());
                    break;
               case 9:
                    outputJTextArea.setText(doProblem.problemNine());
                    break;
               case 10:
                    outputJTextArea.setText(doProblem.problemTen());
                    break;
               case 11:
                    outputJTextArea.setText(doProblem.problemEleven());
                    break;

          }
     }//GEN-LAST:event_doProblemJButtonActionPerformed

     private void quitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitJButtonActionPerformed
          System.exit(0); //Quit
     }//GEN-LAST:event_quitJButtonActionPerformed

     /**
      * @param args the command line arguments
      */
     public static void main(String args[]) {

          /* Create and display the form */
          java.awt.EventQueue.invokeLater(new Runnable() {

               public void run() {
                    new EulerProblems().setVisible(true);
               }
          });
     }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton doProblemJButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea outputJTextArea;
    private javax.swing.JSpinner problemSelectionJSpinner;
    private javax.swing.JButton quitJButton;
    // End of variables declaration//GEN-END:variables
}
