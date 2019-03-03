/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layer_Presentation;

import java.io.File;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author KGR
 */
public class JFEncryptDecryptDES extends javax.swing.JFrame {

    /**
     * Creates new form JFSecurity
     */
    public JFEncryptDecryptDES() {
        initComponents();
    }
    
    public static String secretKey = "qualityinfosolutions";
    public static String base64EncryptedString = "";
 
    public static String encrypt(String strToEncrypt)
    {
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            
            byte[] plainTextBytes = strToEncrypt.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            
            base64EncryptedString = new String(base64Bytes);
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.getMessage());
        }
        return base64EncryptedString;
    }
    
    public static String decrypt(String strToDecrypt)
    {
        try
        {
            byte[] message = Base64.decodeBase64(strToDecrypt.getBytes("utf-8"));
            
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);
            
            byte[] plainText = decipher.doFinal(message);
            
            base64EncryptedString = new String(plainText, "UTF-8");
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.getMessage());
        }
        return base64EncryptedString;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        buttonGroup_Option = new javax.swing.ButtonGroup();
        jButton_Encrypt = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_FilePath = new javax.swing.JTextArea();
        jButton_Decrypt = new javax.swing.JButton();
        jRadioButton_Encrypt = new javax.swing.JRadioButton();
        jRadioButton_Decrypt = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_Result = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_Decrypt = new javax.swing.JMenu();
        jMenu_Decrypt1 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton_Encrypt.setText("Encrypt");
        jButton_Encrypt.setEnabled(false);
        jButton_Encrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EncryptActionPerformed(evt);
            }
        });

        jLabel2.setText("DES Encryption Decryption");

        jTextArea_FilePath.setColumns(20);
        jTextArea_FilePath.setRows(5);
        jScrollPane1.setViewportView(jTextArea_FilePath);

        jButton_Decrypt.setText("Decryptt");
        jButton_Decrypt.setEnabled(false);
        jButton_Decrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DecryptActionPerformed(evt);
            }
        });

        buttonGroup_Option.add(jRadioButton_Encrypt);
        jRadioButton_Encrypt.setText("Encrypt");
        jRadioButton_Encrypt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton_EncryptMouseClicked(evt);
            }
        });

        buttonGroup_Option.add(jRadioButton_Decrypt);
        jRadioButton_Decrypt.setText("Decrypt");
        jRadioButton_Decrypt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton_DecryptMouseClicked(evt);
            }
        });

        jTextArea_Result.setEditable(false);
        jTextArea_Result.setColumns(20);
        jTextArea_Result.setRows(5);
        jScrollPane2.setViewportView(jTextArea_Result);

        jMenu_Decrypt.setText("Decrypt AES");
        jMenu_Decrypt.setActionCommand("Decrypt AES");
        jMenu_Decrypt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu_DecryptMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu_Decrypt);

        jMenu_Decrypt1.setText("Decrypt DES");
        jMenu_Decrypt1.setActionCommand("Decrypt DES");
        jMenu_Decrypt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu_Decrypt1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu_Decrypt1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton_Encrypt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Decrypt))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jRadioButton_Encrypt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton_Decrypt)))
                        .addGap(0, 120, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton_Encrypt)
                    .addComponent(jRadioButton_Decrypt))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Encrypt)
                    .addComponent(jButton_Decrypt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_EncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EncryptActionPerformed
        // TODO add your handling code here:
        jTextArea_Result.setText(encrypt(jTextArea_FilePath.getText()));
        
        
        //JOptionPane.showMessageDialog(null, "File encrypted Successfully! ", "AA Control - Encryp File", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton_EncryptActionPerformed

    private void jMenu_DecryptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_DecryptMouseClicked
        // TODO add your handling code here:
        JFDecrypt vistaL =  new JFDecrypt();
        this.dispose();
        vistaL.setVisible(true);
        vistaL.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenu_DecryptMouseClicked

    private void jMenu_Decrypt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_Decrypt1MouseClicked
        // TODO add your handling code here:
        JFEncryptDecryptDES vistaL =  new JFEncryptDecryptDES();
        this.dispose();
        vistaL.setVisible(true);
        vistaL.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenu_Decrypt1MouseClicked

    private void jButton_DecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DecryptActionPerformed
        
        jTextArea_Result.setText(decrypt(jTextArea_FilePath.getText()));
        
    }//GEN-LAST:event_jButton_DecryptActionPerformed

    private void jRadioButton_DecryptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton_DecryptMouseClicked
        // TODO add your handling code here:
        jButton_Decrypt.setEnabled(true);
        jButton_Encrypt.setEnabled(false);
    }//GEN-LAST:event_jRadioButton_DecryptMouseClicked

    private void jRadioButton_EncryptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton_EncryptMouseClicked
        // TODO add your handling code here:
        jButton_Encrypt.setEnabled(true);
        jButton_Decrypt.setEnabled(false);
    }//GEN-LAST:event_jRadioButton_EncryptMouseClicked

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
            java.util.logging.Logger.getLogger(JFEncryptDecryptDES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFEncryptDecryptDES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFEncryptDecryptDES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFEncryptDecryptDES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFEncryptDecryptDES().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup_Option;
    private javax.swing.JButton jButton_Decrypt;
    private javax.swing.JButton jButton_Encrypt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenu_Decrypt;
    private javax.swing.JMenu jMenu_Decrypt1;
    private javax.swing.JRadioButton jRadioButton_Decrypt;
    private javax.swing.JRadioButton jRadioButton_Encrypt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea_FilePath;
    private javax.swing.JTextArea jTextArea_Result;
    // End of variables declaration//GEN-END:variables
}
