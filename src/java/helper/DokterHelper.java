/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Dokter;
import util.RskuHibernateUtil;

/**
 *
 * @author admin
 */
public class DokterHelper {
    public List<Dokter> getDokter(){
        Session session = util.RskuHibernateUtil.getSessionFactory().openSession();
        
        Transaction tx = session.beginTransaction();
        List<Dokter> dokter = null;
        Query q = session.createQuery("from Dokter d");
        dokter = q.list();
        tx.commit();
        session.close();
        return dokter;
    }
    
    public void addNewDokter(
            String nama,
            String spesialis) {
        Session session = RskuHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Dokter dokter = new Dokter(nama, spesialis);
        session.saveOrUpdate(dokter);
        transaction.commit();
        session.close();
    }
    
    public void updateDokter(int id,
            String nama,
            String spesialis) {
        Session session = RskuHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Dokter dokter = new Dokter(id, nama, spesialis);
        session.saveOrUpdate(dokter);
        transaction.commit();
        session.close();
    }
}
