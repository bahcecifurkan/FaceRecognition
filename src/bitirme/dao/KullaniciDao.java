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
public class KullaniciDao implements Serializable {

   private static final long serialVersionUID = 1L;

   Session session = null;
   Transaction tx = null;
   PropConfig pc = new PropConfig();

   public Kullanici kaydet(Kullanici o) {
      o.setIdKullanici(sonId());
      session = HibernateUtil.getSessionFactory().openSession();
      tx = session.beginTransaction();
      System.out.println("             "+o.getIdKullanici());
      session.save(o);
      tx.commit();
      session.close();

      return o;
   }

   public List<Kullanici> kullaniciListesi() {
      session = HibernateUtil.getSessionFactory().openSession();
      tx = session.beginTransaction();
      List<Kullanici> list = session.createCriteria(Kullanici.class)
              .list();
      tx.commit();
      session.close();

      return list;
   }

   public int sonId() {
      session = HibernateUtil.getSessionFactory().openSession();
      tx = session.beginTransaction();
      List<Kullanici> list = session.createCriteria(Kullanici.class)
              .list();
      tx.commit();
      session.close();

      if (list.isEmpty()) {
         return 1;
      }
      return list.size() + 1;
   }

   public Kullanici getwId(Integer id) {
      System.out.println("getwid");
      session = HibernateUtil.getSessionFactory().openSession();
      Kullanici kullanici = (Kullanici) session.get(Kullanici.class, id);

      session.close();
      return kullanici;
   }

   public boolean sil(Integer idKullanici) {
      session = HibernateUtil.getSessionFactory().openSession();
      Object o = session.get(Kullanici.class, idKullanici);
      tx = session.getTransaction();
      session.beginTransaction();
      session.delete(o);
      tx.commit();
      session.close();
      return true;
   }

//   public boolean sil(Integer id) {
//      session = HibernateUtil.getSessionFactory().openSession();
//      Object o = session.get(Kullanici.class, id);
//      tx = session.getTransaction();
//      session.beginTransaction();
//      session.delete(o);
//      tx.commit();
//      
//      
//      String sorgu = "delete Fotograf f where f.kullanici = :idKullanici ";
//      Kullanici k = getwId(id);
//      Query q = session.createQuery(sorgu);
//      q.setParameter("idKullanici", k);
//
//      q.executeUpdate();
//      
//      List<Fotograf> liste = fdao.list(id);
//
//      for (Fotograf f : liste) {
//         File file = new File(pc.getDbName()+"/"+f.getUrl());
//         file.delete();
//      }
//
//      
//      
//      session.close();
//      return true;
//   }
}
