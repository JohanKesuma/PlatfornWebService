/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Antrian;
import util.RskuHibernateUtil;

/**
 *
 * @author johan
 */
public class AntrianHelper {
    public List<Antrian> getAntrian(){
        Session session = util.RskuHibernateUtil.getSessionFactory().openSession();
        
        Transaction tx = session.beginTransaction();
        List<Antrian> antrian = null;
        Query q = session.createQuery("from Antrian a");
        antrian = q.list();
        tx.commit();
        session.close();
        return antrian;
    }
    
    public void addAntrian(Date tanggal, String noRm, String nama, String alamat, String namaKlinik){
        Session session = RskuHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        Antrian antrian = new Antrian(tanggal, noRm, nama, alamat, namaKlinik);
        session.saveOrUpdate(antrian);
        transaction.commit();
        session.close();
    }
    
    public List<Antrian> cariAntrian(String tanggal){
        Session session = util.RskuHibernateUtil.getSessionFactory().openSession();
        
        String q = "From Antrian a where a.tanggal=:tanggal";
        
        Query query = session.createQuery(q);
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            Date date = dateFormat.parse(tanggal);
            query.setParameter("tanggal", date);
        } catch (ParseException ex) {
            Logger.getLogger(AntrianHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<Antrian> antrian = query.list();
        
        return antrian;
    }
}
