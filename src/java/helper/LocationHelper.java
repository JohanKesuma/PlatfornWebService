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
import pojos.Location;

/**
 *
 * @author basisb20
 */
public class LocationHelper {
    public List<Location> getLocation(){
        Session session = util.RskuHibernateUtil.getSessionFactory().openSession();
        
        Transaction tx = session.beginTransaction();
        List<Location> listLocation = null;
        Query q = session.createQuery("from Location l");
        listLocation = q.list();
        tx.commit();
        session.close();
        return listLocation;
    }
    
    public static String toJson(){
        LocationHelper rsku = new LocationHelper();
        List<Location> listLocation = rsku.getLocation();
        
        String json = "[";
        for (int i = 0; i < listLocation.size(); i++) {
            if (i == listLocation.size() - 1) {
                json+=listLocation.get(i).toJson()+"\n";
            } else{
                json+=listLocation.get(i).toJson()+",\n";
            }
            
        }
        json+="]";
        return json;
    }
}
