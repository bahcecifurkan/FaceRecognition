/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitirme.dao;

import bitirme.model.Admin;
import bitirme.util.HibernateUtil;
import java.io.Serializable;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author furkanb
 */
public class AdminDao implements Serializable {

   private static final long serialVersionUID = 1L;

   Session session = null;

   public boolean kaydet(Admin admin) {
      try {
         session = HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();

         session.save(admin);

         session.getTransaction().commit();
         session.close();
         return true;
      } catch (Exception e) {
         System.out.println("HATA : " + e);
         return false;
      }

   }
   
   public Admin girisKontrol(Admin admin){
      session = HibernateUtil.getSessionFactory().openSession();
      String sorgu = "Select a from Admin a WHERE k_adi = :k_adi AND k_parola= :k_parola";
      try {
         Query q = session.createQuery(sorgu);
         q.setParameter("k_adi", admin.getKAdi());
         q.setParameter("k_parola", admin.getKParola());

         Admin u = (Admin) q.uniqueResult();

         session.close();
         return u;
      } catch (Exception e) {
         session.close();
         return null;
      }
   }
   
}
