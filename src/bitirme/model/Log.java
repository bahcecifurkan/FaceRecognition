/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitirme.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author furkanb
 */
@Entity
@Table(name = "Log")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l"),
   @NamedQuery(name = "Log.findByIdLog", query = "SELECT l FROM Log l WHERE l.idLog = :idLog"),
   @NamedQuery(name = "Log.findByGirissaati", query = "SELECT l FROM Log l WHERE l.girissaati = :girissaati")})
public class Log implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @Basic(optional = false)
   @Column(name = "idLog")
   private Integer idLog;
   @Basic(optional = false)
   @Column(name = "girissaati")
   @Temporal(TemporalType.TIMESTAMP)
   private Date girissaati;
   @JoinColumn(name = "Kullanici_idKullanici", referencedColumnName = "idKullanici")
   @ManyToOne(optional = false)
   private Kullanici kullaniciidKullanici;

   public Log() {
   }

   public Log(Integer idLog) {
      this.idLog = idLog;
   }

   public Log(Integer idLog, Date girissaati) {
      this.idLog = idLog;
      this.girissaati = girissaati;
   }

   public Integer getIdLog() {
      return idLog;
   }

   public void setIdLog(Integer idLog) {
      this.idLog = idLog;
   }

   public Date getGirissaati() {
      return girissaati;
   }

   public void setGirissaati(Date girissaati) {
      this.girissaati = girissaati;
   }

   public Kullanici getKullaniciidKullanici() {
      return kullaniciidKullanici;
   }

   public void setKullaniciidKullanici(Kullanici kullaniciidKullanici) {
      this.kullaniciidKullanici = kullaniciidKullanici;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (idLog != null ? idLog.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Log)) {
         return false;
      }
      Log other = (Log) object;
      if ((this.idLog == null && other.idLog != null) || (this.idLog != null && !this.idLog.equals(other.idLog))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "bitirme.model.Log[ idLog=" + idLog + " ]";
   }
   
}
