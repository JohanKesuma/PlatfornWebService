package pojos;
// Generated Oct 31, 2018 2:37:47 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Pasien generated by hbm2java
 */
@Entity
@Table(name="pasien"
    ,catalog="rsku"
)
public class Pasien  implements java.io.Serializable {


     private String noRm;
     private String nama;
     private String alamat;
     private String nik;
     private Date tanggalLahir;
     private String kelamin;

    public Pasien() {
    }

	
    public Pasien(String noRm) {
        this.noRm = noRm;
    }
    public Pasien(String noRm, String nama, String alamat, String nik, Date tanggalLahir, String kelamin) {
       this.noRm = noRm;
       this.nama = nama;
       this.alamat = alamat;
       this.nik = nik;
       this.tanggalLahir = tanggalLahir;
       this.kelamin = kelamin;
    }
   
     @Id 

    
    @Column(name="noRm", unique=true, nullable=false, length=20)
    public String getNoRm() {
        return this.noRm;
    }
    
    public void setNoRm(String noRm) {
        this.noRm = noRm;
    }

    
    @Column(name="nama", length=25)
    public String getNama() {
        return this.nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }

    
    @Column(name="alamat", length=65535)
    public String getAlamat() {
        return this.alamat;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    
    @Column(name="nik", length=25)
    public String getNik() {
        return this.nik;
    }
    
    public void setNik(String nik) {
        this.nik = nik;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="tanggalLahir", length=10)
    public Date getTanggalLahir() {
        return this.tanggalLahir;
    }
    
    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    
    @Column(name="kelamin", length=10)
    public String getKelamin() {
        return this.kelamin;
    }
    
    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }




}


