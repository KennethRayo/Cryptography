/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layer_Presentation;

import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author KGR
 */
public class JFEncrypt extends javax.swing.JFrame {

    /**
     * Creates new form JFSecurity
     */
    public JFEncrypt() {
        initComponents();
    }
    
    private static String secretKey = "boooooooooom!!!!";
    private static String salt = "ssshhhhhhhhhhh!!!!";
 
    public static String encrypt(String strToEncrypt, String secret)
    {
        try
        {
            byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
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
        jLabel1 = new javax.swing.JLabel();
        jButton_Encrypt = new javax.swing.JButton();
        jTextField_Encrypted = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton_Clear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Encryption = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_Decrypt = new javax.swing.JMenu();
        jMenu_EncryptFile = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("AES 256 Encrypted");

        jButton_Encrypt.setText("Encrypt");
        jButton_Encrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EncryptActionPerformed(evt);
            }
        });

        jTextField_Encrypted.setEditable(false);

        jLabel2.setText("AES 256 Encryption");

        jButton_Clear.setText("Clear");
        jButton_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ClearActionPerformed(evt);
            }
        });

        jTextArea_Encryption.setColumns(20);
        jTextArea_Encryption.setRows(5);
        jScrollPane1.setViewportView(jTextArea_Encryption);

        jMenu_Decrypt.setText("Decrypt AES");
        jMenu_Decrypt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu_DecryptMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu_Decrypt);

        jMenu_EncryptFile.setText("Decrypt DES");
        jMenu_EncryptFile.setToolTipText("");
        jMenu_EncryptFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu_EncryptFileMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu_EncryptFile);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButton_Encrypt)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField_Encrypted)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jButton_Clear)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_Encrypt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField_Encrypted, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Clear)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_EncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EncryptActionPerformed
        // TODO add your handling code here:
        
        jTextField_Encrypted.setText(encrypt(jTextArea_Encryption.getText(),"hola"));
    }//GEN-LAST:event_jButton_EncryptActionPerformed

    private void jButton_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ClearActionPerformed
        // TODO add your handling code here:
        jTextField_Encrypted.setText("");
    }//GEN-LAST:event_jButton_ClearActionPerformed

    private void jMenu_DecryptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_DecryptMouseClicked
        // TODO add your handling code here:
        JFDecrypt vistaL =  new JFDecrypt();
        this.dispose();
        vistaL.setVisible(true);
        vistaL.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenu_DecryptMouseClicked

    private void jMenu_EncryptFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_EncryptFileMouseClicked
        // TODO add your handling code here:
        JFEncryptDecryptDES vistaL =  new JFEncryptDecryptDES();
        this.dispose();
        vistaL.setVisible(true);
        vistaL.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenu_EncryptFileMouseClicked

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
            java.util.logging.Logger.getLogger(JFEncrypt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFEncrypt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFEncrypt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFEncrypt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFEncrypt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Clear;
    private javax.swing.JButton jButton_Encrypt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenu_Decrypt;
    private javax.swing.JMenu jMenu_EncryptFile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea_Encryption;
    private javax.swing.JTextField jTextField_Encrypted;
    // End of variables declaration//GEN-END:variables
}
