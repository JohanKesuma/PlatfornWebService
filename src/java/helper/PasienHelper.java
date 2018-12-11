/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Pasien;
import util.RskuHibernateUtil;

/**
 *
 * @author admin
 */
public class PasienHelper {

    public List<Pasien> getAllPasien() {
        List<Pasien> result = null;
        Session session = RskuHibernateUtil.getSessionFactory().openSession();
        String query = "from Pasien p";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }

    public void addNewPasien(
            String noRm,
            String nama,
            String alamat,
            String nik,
            Date tanggalLahir,
            String kelamin) {
        Session session = RskuHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Pasien pasien = new Pasien(noRm, nama, alamat, noRm, tanggalLahir, kelamin);
        session.saveOrUpdate(pasien);
        transaction.commit();
        session.close();
    }

    public Pasien cariPasien(String nik){
        Session session = util.RskuHibernateUtil.getSessionFactory().openSession();
        
        String q = "From Pasien p where p.nik=:nik";
        
        Query query = session.createQuery(q);
        query.setParameter("nik", nik);
        
        return (Pasien) query.uniqueResult();
    }
}
