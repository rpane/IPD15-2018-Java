/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz2travel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author 0639300
 */
public class Quiz2Travel extends javax.swing.JFrame {

    DefaultListModel<Travel> modelTravelList = new DefaultListModel<>();
    File currentFile;
    boolean isDocModified = false;
    DateFormat format = new SimpleDateFormat("YYYY/MM/DD");
    final static String FILE_NAME = "travel.txt";

    public Quiz2Travel() {
        initComponents();
        FileFilter textFileFilter = new FileNameExtensionFilter(
                "Data files (*.dat)", "dat");
        fileChooser.setFileFilter(textFileFilter);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        fileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstTravel = new javax.swing.JList<>();
        lblName = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        lblTransport = new javax.swing.JLabel();
        btnPlane = new javax.swing.JRadioButton();
        btnCar = new javax.swing.JRadioButton();
        btnOther = new javax.swing.JRadioButton();
        lblDestination = new javax.swing.JLabel();
        tfDestination = new javax.swing.JTextField();
        lblDate = new javax.swing.JLabel();
        tfDate = new javax.swing.JTextField();
        btnAddTravel = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miOpen = new javax.swing.JMenuItem();
        miSaveAs = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miExit = new javax.swing.JMenuItem();
        menDelete = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lstTravel.setModel(modelTravelList);
        lstTravel.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lstTravel);

        lblName.setText("Name:");

        lblTransport.setText("Transport");

        buttonGroup1.add(btnPlane);
        btnPlane.setSelected(true);
        btnPlane.setText("Plane");

        buttonGroup1.add(btnCar);
        btnCar.setText("Car");

        buttonGroup1.add(btnOther);
        btnOther.setText("Other");

        lblDestination.setText("Destination:");

        lblDate.setText("Dep. Date");

        btnAddTravel.setText("Add Travel");
        btnAddTravel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTravelActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        miOpen.setText("Open...");
        miOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOpenActionPerformed(evt);
            }
        });
        jMenu1.add(miOpen);

        miSaveAs.setText("Save as");
        miSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSaveAsActionPerformed(evt);
            }
        });
        jMenu1.add(miSaveAs);
        jMenu1.add(jSeparator1);

        miExit.setText("Exit");
        miExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExitActionPerformed(evt);
            }
        });
        jMenu1.add(miExit);

        jMenuBar1.add(jMenu1);

        menDelete.setText("Delete Selected");
        jMenuBar1.add(menDelete);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTransport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPlane)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOther))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDestination)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddTravel)
                            .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName)
                            .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPlane)
                            .addComponent(lblTransport)
                            .addComponent(btnCar)
                            .addComponent(btnOther))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDestination)
                            .addComponent(tfDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDate)
                            .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(btnAddTravel)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddTravelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTravelActionPerformed
        String name = tfName.getText();
        String transport;
        if (btnCar.isSelected()) {
            transport = "drives";
        } else if (btnPlane.isSelected()) {
            transport = "flies";
        } else if (btnOther.isSelected()){
            transport = "takes other route";
        }else
        {
            transport ="error";
        }
        String destination = tfDestination.getText();

        try {

            Date date = format.parse(tfDate.getText());
            Travel one = new Travel(name, transport, destination, date);
            modelTravelList.addElement(one); //Check                
           

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Input error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (InvalidParameterException ex) {
            Logger.getLogger(Quiz2Travel.class.getName()).log(Level.SEVERE, null, ex);
        }
        tfName.setText("");
        btnCar.setSelected(false);
        btnOther.setSelected(false);
        btnPlane.setSelected(true);
        tfDestination.setText("");
        tfDate.setText("");

    }//GEN-LAST:event_btnAddTravelActionPerformed

    private void miOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOpenActionPerformed
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            try (Scanner sc = new Scanner(currentFile)) {
                while (sc.hasNextLine()) {

                    String name = sc.nextLine();
                    //modelTravelList.addElement(name);
                }

                isDocModified = false;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                        "Error reading from file: " + ex.getMessage(),
                        "File access error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_miOpenActionPerformed

    private void miExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExitActionPerformed
        if (isDocModified) {
            Object[] options = {"Save", "Don't save", "Cancel"};
            int choice = JOptionPane.showOptionDialog(this,
                    "Would you like to save changes?",
                    "Document modified",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (choice == JOptionPane.YES_OPTION) {
                miSaveAsActionPerformed(evt);
                // DO NOT dispose(); because you'll lose data if user cancelled save
                return;
            } else if (choice == JOptionPane.CANCEL_OPTION) {
                return;
            }
        }
        dispose();
    }//GEN-LAST:event_miExitActionPerformed

    private void miSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSaveAsActionPerformed
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            String fileName = currentFile.getName();
            if (!fileName.matches(".+\\.[^\\.]+")) {

                String filePath = currentFile.getAbsolutePath();
                // FIXME: what if filePath ends with "." ?
                currentFile = new File(filePath + ".dat");
            }
            String content = modelTravelList.toString();
            try (PrintWriter pw = new PrintWriter(currentFile)) {
                pw.print(content);
                isDocModified = false;

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this,
                        "Unable to save file: " + ex.getMessage(),
                        "File access error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_miSaveAsActionPerformed

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
            java.util.logging.Logger.getLogger(Quiz2Travel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quiz2Travel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quiz2Travel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quiz2Travel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quiz2Travel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTravel;
    private javax.swing.JRadioButton btnCar;
    private javax.swing.JRadioButton btnOther;
    private javax.swing.JRadioButton btnPlane;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDestination;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblTransport;
    private javax.swing.JList<Travel> lstTravel;
    private javax.swing.JMenu menDelete;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JMenuItem miOpen;
    private javax.swing.JMenuItem miSaveAs;
    private javax.swing.JTextField tfDate;
    private javax.swing.JTextField tfDestination;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}
