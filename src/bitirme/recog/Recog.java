/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitirme.recog;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.IntBuffer;
import org.bytedeco.javacpp.opencv_core;
import static org.bytedeco.javacpp.opencv_core.CV_32SC1;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.MatVector;
import org.bytedeco.javacpp.opencv_face.FaceRecognizer;
//import org.bytedeco.javacpp.opencv_videoio.VideoCapture;
import static org.bytedeco.javacpp.opencv_face.createFisherFaceRecognizer;
import static org.bytedeco.javacpp.opencv_imgcodecs.CV_LOAD_IMAGE_GRAYSCALE;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;

/**
 *
 * @author furkanb
 */
public class Recog {

   public static void main(String[] args) {
      Recog r = new Recog();
      r.tanimla("/home/furkanb/Pictures/Webcam", "/home/furkanb/Pictures/Webcam/test/test.jpg");
   }

   public int tanimla(String database, String fotografurl) {

      Mat testImage = imread(fotografurl, CV_LOAD_IMAGE_GRAYSCALE);
//      Mat testImage = fotograf;
      File root = new File(database);

      FilenameFilter dosyaFiltre = new FilenameFilter() {
         public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(".jpg");
         }
      };

      File[] imageFiles = root.listFiles(dosyaFiltre);

      MatVector images = new MatVector(imageFiles.length);

      Mat labels = new Mat(imageFiles.length, 1, CV_32SC1);
      IntBuffer labelsBuf = labels.getIntBuffer();

      int counter = 0;

      Mat img;

      for (File image : imageFiles) {
         img = imread(image.getAbsolutePath(), CV_LOAD_IMAGE_GRAYSCALE);
         
         String temp = image.getName();

         int label = Integer.parseInt(temp.charAt(0) + "");

         images.put(counter, img);
         labelsBuf.put(counter, label);

         counter++;
      }

//        IplImage greyTestImage = IplImage.create(testImage.width(), testImage.height(), IPL_DEPTH_8U, 1);
      FaceRecognizer faceRecognizer = createFisherFaceRecognizer();

      faceRecognizer.train(images, labels);
//      System.out.println(testImage.);
      int tahmin = faceRecognizer.predict(testImage);
//
//        cvCvtColor(testImage, greyTestImage, CV_BGR2GRAY);
//
//        int predictedLabel = faceRecognizer.predict(greyTestImage);

//        System.out.println("Predicted label: " + predictedLabel);
      System.out.println("Tahmin edilen ID : " + tahmin);
      return tahmin;
   }

}
