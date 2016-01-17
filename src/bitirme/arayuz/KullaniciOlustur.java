/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitirme.arayuz;

import bitirme.dao.FotografDao;
import bitirme.dao.KullaniciDao;
import bitirme.model.Fotograf;
import bitirme.model.Kullanici;
import bitirme.service.PropConfig;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

/**
 *
 * @author Furkan
 */
public class KullaniciOlustur extends javax.swing.JFrame {

   Integer fotografkayitSayisi = 0;
   VideoCapture kamera = null;
   CanliThread th = null;
   PropConfig pc = new PropConfig();

   Mat fotograf = new Mat();
   List<Mat> liste = new ArrayList<>();

   MatOfByte fotografBytes = new MatOfByte(); // fotoğraf datası
   MatOfRect yuzler = new MatOfRect(); // birden fazla yüz dizi içinde tutuluyor

   String database = null;
   List<String> talimat = new ArrayList<>();

   KullaniciDao kd = new KullaniciDao();
   FotografDao fd = new FotografDao();

   List<String> fileNames = new ArrayList<>();

   public void talimatlar() {
      talimat.add("Kameraya Düz Bakınız");
      talimat.add("Düşük Açıyla SAĞA Doğru Bakınız");
      talimat.add("Düşük Açıyla SOLA Doğru Bakınız");
      talimat.add("İşlem Tamam. Kaydı Sonlandırın.");
   }

   class CanliThread implements Runnable {

      boolean calismaDurumu = false;

      @Override
      public void run() {

         while (calismaDurumu) {
            System.out.println("asd");
            if (kamera.grab()) {
               try {
                  kamera.retrieve(fotograf);
//
                  Imgcodecs.imencode(".jpg", fotograf, fotografBytes);
                  Image im = ImageIO.read(new ByteArrayInputStream(fotografBytes.toArray()));
                  BufferedImage buff = (BufferedImage) im;
                  Graphics g = panel.getGraphics();
                  if (g.drawImage(buff, 0, 0, 400, 300, 0, 0, buff.getWidth(), buff.getHeight(), null)) {
                     if (calismaDurumu == false) {
                        System.out.println("durduruldu()");
                     }
                  }
               } catch (Exception e) {
               }
            }
         }
      }
   }

   public KullaniciOlustur() {

      System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
      talimatlar();

      initComponents();
      talimatTxt.setText(talimat.get(fotografkayitSayisi));
      fotografSayisiTxt.setText("0");
      tamamlaBtn.setEnabled(false);
   }

   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      dosyaSecici = new javax.swing.JFileChooser();
      klasorSecici = new javax.swing.JFileChooser();
      jLabel1 = new javax.swing.JLabel();
      jPanel1 = new javax.swing.JPanel();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      adTxt = new javax.swing.JTextField();
      soyadTxt = new javax.swing.JTextField();
      talimatTxt = new javax.swing.JLabel();
      fotografSayisiTxt = new javax.swing.JLabel();
      tamamlaBtn = new javax.swing.JButton();
      panel = new javax.swing.JPanel();
      jLabel4 = new javax.swing.JLabel();
      fotografBtn1 = new javax.swing.JButton();
      baslatBtn = new javax.swing.JButton();
      tamamlandi = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

      jLabel1.setText("Kaydedilmiş Fotoğraf Sayısı :");

      jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Kullanici Bilgileri"));

      jLabel2.setText("Ad :");

      jLabel3.setText("Soyad :");

      adTxt.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            adTxtActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jLabel3)
               .addComponent(jLabel2))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(adTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
               .addComponent(soyadTxt))
            .addContainerGap())
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel2)
               .addComponent(adTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel3)
               .addComponent(soyadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      talimatTxt.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
      talimatTxt.setText("jLabel5");

      fotografSayisiTxt.setText("jLabel5");

      tamamlaBtn.setText("Kaydı Tamamla");
      tamamlaBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            tamamlaBtnActionPerformed(evt);
         }
      });

      panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

      javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
      panel.setLayout(panelLayout);
      panelLayout.setHorizontalGroup(
         panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 399, Short.MAX_VALUE)
      );
      panelLayout.setVerticalGroup(
         panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 300, Short.MAX_VALUE)
      );

      jLabel4.setText("-TALİMAT- ");

      fotografBtn1.setText("Fotoğraf Çek");
      fotografBtn1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            fotografBtn1ActionPerformed(evt);
         }
      });

      baslatBtn.setText("Baslat");
      baslatBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            baslatBtnActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(44, 44, 44)
            .addComponent(baslatBtn)
            .addGap(46, 46, 46)
            .addComponent(jLabel4)
            .addGap(41, 41, 41)
            .addComponent(fotografBtn1)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(tamamlaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(tamamlandi))))
               .addGroup(layout.createSequentialGroup()
                  .addGap(33, 33, 33)
                  .addComponent(jLabel1)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(fotografSayisiTxt))
               .addGroup(layout.createSequentialGroup()
                  .addGap(56, 56, 56)
                  .addComponent(talimatTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(0, 0, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(23, 23, 23)
                  .addComponent(tamamlaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(21, 21, 21)
                  .addComponent(tamamlandi)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel4)
               .addComponent(fotografBtn1)
               .addComponent(baslatBtn))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(talimatTxt)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel1)
               .addComponent(fotografSayisiTxt))
            .addContainerGap())
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

  private void baslatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baslatBtnActionPerformed

     kamera = new VideoCapture(0);
     //sistemdeki kameraları 0,1,2

     th = new CanliThread();
     Thread t = new Thread(th);
     t.setDaemon(true);
     //threadi çalıştır
     th.calismaDurumu = true;

     t.start();
//     baslatBtn.setEnabled(false);  //start button
//     duraklatBtn.setEnabled(true);  // stop button
  }//GEN-LAST:event_baslatBtnActionPerformed

   private void adTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adTxtActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_adTxtActionPerformed

   private void tamamlaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamamlaBtnActionPerformed
      Kullanici k = new Kullanici();
      k.setAd(adTxt.getText());
      k.setSoyad(soyadTxt.getText());

      Kullanici k2 = kd.kaydet(k);

      for (int i = 0; i < 3; i++) {
         Fotograf f = new Fotograf();
         
         f.setKullaniciidKullanici(k2);
         f.setUrl(fileNames.get(i));
         fd.kaydet(f);
      }

      tamamlaBtn.setEnabled(false);
      tamamlandi.setText("Kayıt Başarılı");
      th.calismaDurumu = false;
      baslatBtn.setEnabled(false);

      kamera.release();
   }//GEN-LAST:event_tamamlaBtnActionPerformed

   private void fotografBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fotografBtn1ActionPerformed
      if (fotografkayitSayisi < 3) {
         talimatTxt.setText(talimat.get(fotografkayitSayisi + 1));
      }
      fotografkayitSayisi += 1;
      fotografSayisiTxt.setText(fotografkayitSayisi.toString());

      if (fotografkayitSayisi == 3) {
         fotografBtn1.setEnabled(false);
         tamamlaBtn.setEnabled(true);
      }

      String fileName = kd.sonId() + "-" + adTxt.getText() + soyadTxt.getText() + "_" + fotografkayitSayisi + ".jpg";
      fileNames.add(fileName);

      Imgcodecs.imwrite(pc.getDbName() + "/" + fileName, fotograf);

   }//GEN-LAST:event_fotografBtn1ActionPerformed

   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
      System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
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
         java.util.logging.Logger.getLogger(KullaniciOlustur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(KullaniciOlustur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(KullaniciOlustur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(KullaniciOlustur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new KullaniciOlustur().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JTextField adTxt;
   private javax.swing.JButton baslatBtn;
   private javax.swing.JFileChooser dosyaSecici;
   private javax.swing.JButton fotografBtn1;
   private javax.swing.JLabel fotografSayisiTxt;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JFileChooser klasorSecici;
   private javax.swing.JPanel panel;
   private javax.swing.JTextField soyadTxt;
   private javax.swing.JLabel talimatTxt;
   private javax.swing.JButton tamamlaBtn;
   private javax.swing.JLabel tamamlandi;
   // End of variables declaration//GEN-END:variables
}
