/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitirme.dao;

import bitirme.model.Fotograf;
import bitirme.model.Kullanici;
import bitirme.service.PropConfig;
import bitirme.util.HibernateUtil;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author furkanb
 */
public class FotografDao implements Serializable {

   private static final long serialVersionUID = 1L;

   Session session = null;
   Transaction tx = null;
   PropConfig pc = new PropConfig();
   KullaniciDao kdao = new KullaniciDao();

   public void kaydet(Fotograf o) {
      session = HibernateUtil.getSessionFactory().openSession();
      tx = session.beginTransaction();
      session.save(o);
      tx.commit();
      session.close();
   }

   public List<Fotograf> list(Integer idKullanici) {
      session = HibernateUtil.getSessionFactory().openSession();
      String sorgu = "Select f FROM Fotograf f "
              + "join f.kullaniciidKullanici k "
              + "where k.idKullanici = :idKullanici";
      List<Fotograf> liste = null;

      Query q = session.createQuery(sorgu);
      q.setParameter("idKullanici", idKullanici);

      liste = q.list();
      session.close();
      return liste;
   }

   public boolean sil(Integer idKullanici) {
      session = HibernateUtil.getSessionFactory().openSession();
      String sorgu = "delete Fotograf f where f.kullaniciidKullanici = :idKullanici ";
      Kullanici k = kdao.getwId(idKullanici);
      Query q = session.createQuery(sorgu);
      q.setParameter("idKullanici", k);

      q.executeUpdate();
      session.close();

      return true;
   }

   public boolean localSil(Integer idKullanici) {
//      Session session1 = HibernateUtil.getSessionFactory().openSession();

      List<Fotograf> liste = list(idKullanici);
      for (Fotograf f : liste) {
         try {
            File file = new File(pc.getDbName() + "/" + f.getUrl());
            System.out.println(pc.getDbName()+"/"+f.getUrl());
            boolean bb = file.delete();
//            file.createNewFile();
//            file.delete();
            System.out.println(bb);
         } catch (Exception e) {
            System.out.println(e);
         }
      }

//      session1.close();
      return true;
   }
}
