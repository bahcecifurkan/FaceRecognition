/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitirme.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author furkanb
 */
public class NewClass {

   public static void main(String[] args) throws FileNotFoundException, IOException {
      Properties prop = new Properties();
      InputStream input = null;

      input = NewClass.class.getClass().getResourceAsStream("/bitirme/util/config.properties");

      // load a properties file
      prop.load(input);

      // get the property value and print it out
      System.out.println(prop.getProperty("db"));
   }
}
