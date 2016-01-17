/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitirme.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author furkanb
 */
@Entity
@Table(name = "Kullanici")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Kullanici.findAll", query = "SELECT k FROM Kullanici k"),
   @NamedQuery(name = "Kullanici.findByIdKullanici", query = "SELECT k FROM Kullanici k WHERE k.idKullanici = :idKullanici"),
   @NamedQuery(name = "Kullanici.findByAd", query = "SELECT k FROM Kullanici k WHERE k.ad = :ad"),
   @NamedQuery(name = "Kullanici.findBySoyad", query = "SELECT k FROM Kullanici k WHERE k.soyad = :soyad"),
   @NamedQuery(name = "Kullanici.findBySilinme", query = "SELECT k FROM Kullanici k WHERE k.silinme = :silinme")})
public class Kullanici implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @Basic(optional = false)
   @Column(name = "idKullanici")
   private Integer idKullanici;
   @Column(name = "Ad")
   private String ad;
   @Column(name = "Soyad")
   private String soyad;
   @Column(name = "silinme")
   private String silinme;
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "kullaniciidKullanici")
   private List<Fotograf> fotografList;
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "kullaniciidKullanici")
   private List<Log> logList;

   public Kullanici() {
   }

   public Kullanici(Integer idKullanici) {
      this.idKullanici = idKullanici;
   }

   public Integer getIdKullanici() {
      return idKullanici;
   }

   public void setIdKullanici(Integer idKullanici) {
      this.idKullanici = idKullanici;
   }

   public String getAd() {
      return ad;
   }

   public void setAd(String ad) {
      this.ad = ad;
   }

   public String getSoyad() {
      return soyad;
   }

   public void setSoyad(String soyad) {
      this.soyad = soyad;
   }

   public String getSilinme() {
      return silinme;
   }

   public void setSilinme(String silinme) {
      this.silinme = silinme;
   }

   @XmlTransient
   public List<Fotograf> getFotografList() {
      return fotografList;
   }

   public void setFotografList(List<Fotograf> fotografList) {
      this.fotografList = fotografList;
   }

   @XmlTransient
   public List<Log> getLogList() {
      return logList;
   }

   public void setLogList(List<Log> logList) {
      this.logList = logList;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (idKullanici != null ? idKullanici.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Kullanici)) {
         return false;
      }
      Kullanici other = (Kullanici) object;
      if ((this.idKullanici == null && other.idKullanici != null) || (this.idKullanici != null && !this.idKullanici.equals(other.idKullanici))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "bitirme.model.Kullanici[ idKullanici=" + idKullanici + " ]";
   }
   
}
