/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitirme.arayuz;

import bitirme.dao.AdminDao;
import bitirme.dao.FotografDao;
import bitirme.dao.KullaniciDao;
import bitirme.model.Admin;
import bitirme.model.Kullanici;
import bitirme.service.PropConfig;
import java.io.File;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author furkanb
 */
public class AdminMain extends javax.swing.JFrame {

   /**
    * Creates new form AdminMain
    */
   AdminDao ad;
   String yeniDatabase;
   PropConfig pc = new PropConfig();
   KullaniciDao kd = new KullaniciDao();
   FotografDao fdao = new FotografDao();

   public AdminMain() {
      ad = new AdminDao();
      initComponents();
      listele();
   }

   public void listele() {
      String col[] = {"Id", "Ad", "Soyad"};
      DefaultTableModel model = new DefaultTableModel(new Object[0][0], col);
      for (Kullanici k : kd.kullaniciListesi()) {
         System.out.println(k.getAd());
         Object[] o = new Object[3];
         o[0] = k.getIdKullanici();
         o[1] = k.getAd();
         o[2] = k.getSoyad();
         model.addRow(o);
      }
      table.setModel(model);
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      dosyaSecici = new javax.swing.JFileChooser();
      dbSecBtn = new javax.swing.JButton();
      jPanel1 = new javax.swing.JPanel();
      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      kadiTxt = new javax.swing.JTextField();
      parolaTxt = new javax.swing.JTextField();
      kayitOlusturBtn = new javax.swing.JButton();
      jScrollPane1 = new javax.swing.JScrollPane();
      table = new javax.swing.JTable();
      olusturBtn = new javax.swing.JButton();
      goruntule = new javax.swing.JButton();
      silBtn = new javax.swing.JButton();
      yenile = new javax.swing.JButton();

      dosyaSecici.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

      dbSecBtn.setText("Fotoğraf(DB) Klasörü");
      dbSecBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            dbSecBtnActionPerformed(evt);
         }
      });

      jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Yeni Admin"));

      jLabel1.setText("Kullanıcı Adı :");

      jLabel2.setText("Parola :");

      kayitOlusturBtn.setText("Kayıt Oluştur");
      kayitOlusturBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            kayitOlusturBtnActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(kayitOlusturBtn)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jLabel1)
                     .addComponent(jLabel2))
                  .addGap(18, 18, 18)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(kadiTxt)
                     .addComponent(parolaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))))
            .addContainerGap(38, Short.MAX_VALUE))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel1)
               .addComponent(kadiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel2)
               .addComponent(parolaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(kayitOlusturBtn)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      table.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
         },
         new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
         }
      ));
      jScrollPane1.setViewportView(table);

      olusturBtn.setText("Kullanıcı Oluştur");
      olusturBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            olusturBtnActionPerformed(evt);
         }
      });

      goruntule.setText("Fotograflari Görüntüle");
      goruntule.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            goruntuleActionPerformed(evt);
         }
      });

      silBtn.setText("Sil");
      silBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            silBtnActionPerformed(evt);
         }
      });

      yenile.setText("Yenile");
      yenile.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            yenileActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(dbSecBtn)
            .addGap(18, 18, 18)
            .addComponent(olusturBtn)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
               .addComponent(goruntule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(silBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(yenile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(26, 26, 26))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(dbSecBtn)
               .addComponent(olusturBtn))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                  .addGroup(layout.createSequentialGroup()
                     .addComponent(yenile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                     .addComponent(silBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                     .addComponent(goruntule, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void kayitOlusturBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kayitOlusturBtnActionPerformed

      Admin admin = new Admin();
      admin.setKAdi(kadiTxt.getText());
      admin.setKParola(parolaTxt.getText());
      ad.kaydet(admin);
   }//GEN-LAST:event_kayitOlusturBtnActionPerformed

   private void dbSecBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbSecBtnActionPerformed
      int returnVal = dosyaSecici.showSaveDialog(this);
      dosyaSecici.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      if (returnVal == JFileChooser.APPROVE_OPTION) {
         System.out.println("aasdasd");
         File file = dosyaSecici.getSelectedFile();

         pc.setDbName(file.getPath());
      } else {
         System.out.println("dosya erişimi");
      }
   }//GEN-LAST:event_dbSecBtnActionPerformed

   private void olusturBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_olusturBtnActionPerformed
      KullaniciOlustur ko = new KullaniciOlustur();
      ko.setVisible(true);
   }//GEN-LAST:event_olusturBtnActionPerformed

   private void goruntuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goruntuleActionPerformed
      Integer row = table.getSelectedRow();
      Integer col = 0;
      System.out.println(table.getValueAt(row, col));
      FotografGoruntule fg = new FotografGoruntule((Integer) table.getValueAt(row, col));
      fg.show();
   }//GEN-LAST:event_goruntuleActionPerformed

   private void silBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silBtnActionPerformed
      Integer idKullanici = (Integer) table.getValueAt(table.getSelectedRow(), 0);
      fdao.localSil(idKullanici);
      fdao.sil(idKullanici);

      kd.sil(idKullanici);
      listele();
   }//GEN-LAST:event_silBtnActionPerformed

   private void yenileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yenileActionPerformed
      listele();
   }//GEN-LAST:event_yenileActionPerformed

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
         java.util.logging.Logger.getLogger(AdminMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(AdminMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(AdminMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(AdminMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new AdminMain().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton dbSecBtn;
   private javax.swing.JFileChooser dosyaSecici;
   private javax.swing.JButton goruntule;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTextField kadiTxt;
   private javax.swing.JButton kayitOlusturBtn;
   private javax.swing.JButton olusturBtn;
   private javax.swing.JTextField parolaTxt;
   private javax.swing.JButton silBtn;
   private javax.swing.JTable table;
   private javax.swing.JButton yenile;
   // End of variables declaration//GEN-END:variables
}