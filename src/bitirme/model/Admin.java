/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitirme.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author furkanb
 */
@Entity
@Table(name = "Admin")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a"),
   @NamedQuery(name = "Admin.findByIdAdmin", query = "SELECT a FROM Admin a WHERE a.idAdmin = :idAdmin"),
   @NamedQuery(name = "Admin.findByKAdi", query = "SELECT a FROM Admin a WHERE a.kAdi = :kAdi"),
   @NamedQuery(name = "Admin.findByKParola", query = "SELECT a FROM Admin a WHERE a.kParola = :kParola")})
public class Admin implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "idAdmin")
   private Integer idAdmin;
   @Basic(optional = false)
   @Column(name = "k_adi")
   private String kAdi;
   @Basic(optional = false)
   @Column(name = "k_parola")
   private String kParola;

   public Admin() {
   }

   public Admin(Integer idAdmin) {
      this.idAdmin = idAdmin;
   }

   public Admin(Integer idAdmin, String kAdi, String kParola) {
      this.idAdmin = idAdmin;
      this.kAdi = kAdi;
      this.kParola = kParola;
   }

   public Integer getIdAdmin() {
      return idAdmin;
   }

   public void setIdAdmin(Integer idAdmin) {
      this.idAdmin = idAdmin;
   }

   public String getKAdi() {
      return kAdi;
   }

   public void setKAdi(String kAdi) {
      this.kAdi = kAdi;
   }

   public String getKParola() {
      return kParola;
   }

   public void setKParola(String kParola) {
      this.kParola = kParola;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (idAdmin != null ? idAdmin.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Admin)) {
         return false;
      }
      Admin other = (Admin) object;
      if ((this.idAdmin == null && other.idAdmin != null) || (this.idAdmin != null && !this.idAdmin.equals(other.idAdmin))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "bitirme.model.Admin[ idAdmin=" + idAdmin + " ]";
   }
   
}
