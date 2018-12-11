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
import pojos.Klinik;
import util.RskuHibernateUtil;

/**
 *
 * @author admin
 */
public class KlinikHelper {
    public List<Klinik> getKlinik(){
        Session session = util.RskuHibernateUtil.getSessionFactory().openSession();
        
        Transaction tx = session.beginTransaction();
        List<Klinik> klinik = null;
        Query q = session.createQuery("from Klinik k");
        klinik = q.list();
        tx.commit();
        session.close();
        return klinik;
    }
    
    public void addNewKlinik(
            String idKlinik,
            String nama,
            String spesialis) {
        Session session = RskuHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Klinik klinik = new Klinik(idKlinik, nama, spesialis);
        session.saveOrUpdate(klinik);
        transaction.commit();
        session.close();
    }
}
