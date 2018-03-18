package sql;

import crops.Crop;
import org.hibernate.Session;
import org.hibernate.Transaction;
import users.Customer;
import users.Farmer;
import users.Person;

public class DBManager extends Main {

    private static DBManager instance;
    private Transaction transaction = null;
    private Session session;



    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    public static void setInstance(DBManager instance) {
        DBManager.instance = instance;
    }

    public void add(Object p){
         session = getSession();

        try{
            transaction = session.beginTransaction();
            session.save(p);
            transaction.commit();

        }catch (RuntimeException e){
            if(transaction!=null)
                transaction.rollback();
        }
        finally {
            if(transaction!=null && transaction.isActive())
                session.flush();
            session.close();
        }
    }

    public void update(Object a) {
         session = getSession();
        try {
            transaction = session.beginTransaction();
            session.update(a);
            transaction.commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }

        } finally {
            if (transaction != null && transaction.isActive()) {
                session.flush();
            }
            session.close();
        }

    }



    public Farmer getFarmer(String id) {
        session = getSession();
        Farmer farmer = null;

        try {
            farmer =(Farmer) session.get(Farmer.class, id);
        } catch (RuntimeException e) {
            e.printStackTrace();

        } finally {
            session.close();
        }
        return farmer;
    }

    public Customer getCustomer(String id) {
        session = getSession();
        Customer customer = null;

        try {
            customer = (Customer) session.get(Customer.class, id);
        } catch (RuntimeException e) {
            e.printStackTrace();

        } finally {
            session.close();
        }
        return customer;
    }

    public Crop getCrop(String id) {
        Session session = getSession();
        Crop crop = null;

        try {
            crop = session.find(Crop.class, id);
        } catch (RuntimeException e) {
            e.printStackTrace();

        } finally {
            session.close();
        }
        return crop;
    }


    public int checkPresent(String email, String pass){
        session = getSession();
        try {
            Farmer f = getFarmer(email);
            Customer c = getCustomer(email);
            if(f!=null)
            if (f.getPassword().compareToIgnoreCase(pass) == 0)
                return 1;
            if(c!=null)
            if (c.getPassword().compareToIgnoreCase(pass) == 0)
                return 2;
            else return 0;
        }catch(org.hibernate.UnknownEntityTypeException e){

        }catch (RuntimeException e){

        }
        return 0;
    }

}
