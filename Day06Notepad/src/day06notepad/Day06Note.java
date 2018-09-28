/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day06notepad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author 0639300
 */
public class Day06Note extends javax.swing.JFrame {

    File currentFile;
    /**
     * Creates new form Day06Note
     */
    public Day06Note() {
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

        FileChooser = new javax.swing.JFileChooser();
        lblStatus = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDocument = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miFileOpen = new javax.swing.JMenuItem();
        miFileSave = new javax.swing.JMenuItem();
        miFileSaveAs = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miFileExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblStatus.setText("No File");
        lblStatus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(lblStatus, java.awt.BorderLayout.PAGE_END);

        taDocument.setColumns(20);
        taDocument.setRows(5);
        jScrollPane1.setViewportView(taDocument);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        miFileOpen.setText("Open ...");
        miFileOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFileOpenActionPerformed(evt);
            }
        });
        jMenu1.add(miFileOpen);

        miFileSave.setText("Save");
        miFileSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFileSaveActionPerformed(evt);
            }
        });
        jMenu1.add(miFileSave);

        miFileSaveAs.setText("Save As ...");
        miFileSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFileSaveAsActionPerformed(evt);
            }
        });
        jMenu1.add(miFileSaveAs);
        jMenu1.add(jSeparator1);

        miFileExit.setText("Exit");
        jMenu1.add(miFileExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miFileSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFileSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miFileSaveActionPerformed

    private void miFileSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFileSaveAsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miFileSaveAsActionPerformed

    private void miFileOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFileOpenActionPerformed
        if (FileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                currentFile = FileChooser.getSelectedFile();
                String content = new Scanner(currentFile).useDelimiter("\\Z").next();
                taDocument.setText(content);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                    "Error reading from file: "+ex.getMessage(),
                    "File access error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_miFileOpenActionPerformed

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
            java.util.logging.Logger.getLogger(Day06Note.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Day06Note.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Day06Note.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Day06Note.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Day06Note().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser FileChooser;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JMenuItem miFileExit;
    private javax.swing.JMenuItem miFileOpen;
    private javax.swing.JMenuItem miFileSave;
    private javax.swing.JMenuItem miFileSaveAs;
    private javax.swing.JTextArea taDocument;
    // End of variables declaration//GEN-END:variables
}