/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitirme.service;

import bitirme.test.NewClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author furkanb
 */
public class PropConfig {

   public String getDbName() {
      Properties prop = new Properties();
      InputStream input = null;

      input = PropConfig.class.getClass().getResourceAsStream("/bitirme/util/config.properties");

      try {
         // load a properties file
         prop.load(input);
         input.close();
      } catch (IOException ex) {

         Logger.getLogger(PropConfig.class.getName()).log(Level.SEVERE, null, ex);
      }

      // get the property value and print it out
      return prop.getProperty("db");
   }

   public void setDbName(String url) {

      File dosya = new File(PropConfig.class.getClass().getResource("/bitirme/util/config.properties").getFile());
      Properties prop = new Properties();

      try {
         prop.load(new FileInputStream(dosya));
         prop.setProperty("db", url);
         
         FileOutputStream out = new FileOutputStream(dosya);
         prop.store(out, "descb");
         
         out.close();
//         prop.save(new FileOutputStream(dosya), "");

      } catch (Exception ex) {
         Logger.getLogger(PropConfig.class.getName()).log(Level.SEVERE, null, ex);
      }

//      Properties prop = new Properties();
//      FileOutputStream output = null;
//      InputStream input = null;
//      try {
//
//         input = PropConfig.class.getClass().getResourceAsStream("/bitirme/util/config.properties");
//         prop.load(input);
//         input.close();
//
//         prop.setProperty("db", url);
//
//         output = new FileOutputStream(PropConfig.class.getClass().getResource("/bitirme/util/config.properties").getFile());
//
//         prop.store(output, "descb");
//         System.out.println(getDbName());
//         output.close();
//         return true;
//      } catch (Exception ex) {
//
//         Logger.getLogger(PropConfig.class.getName()).log(Level.SEVERE, null, ex);
//         return false;
//      }
   }
}
