package test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import pojo.Category;
import pojo.Product;
public class TestHibernate {
    public static void main(String[] args) throws InterruptedException{
    	//OpenSession每次都会得到一个新的Session对象
//    	SessionFactory sf = new Configuration().configure().buildSessionFactory();
//    	  
//        Session s1 = sf.openSession();
//        Session s2 = sf.openSession();
//         
//        System.out.println(s1==s2);
//         
//        s1.close();
//        s2.close();
//        sf.close();
    //相同线程的getCurrentSession
//    	SessionFactory sf = new Configuration().configure().buildSessionFactory();
//    	 
//        Session s1 = sf.getCurrentSession();
//        Session s2 = sf.getCurrentSession();
// 
//        System.out.println(s1 == s2);
// 
//        s1.close();
////      s2.close();
//        sf.close();
    	//不同线程的getCurrentSession
//    	final SessionFactory sf = new Configuration().configure().buildSessionFactory();
//    	 
//        Thread t1 = new Thread() {
//            public void run() {
//                s1 = sf.getCurrentSession();
//            }
//        };
//        t1.start();
// 
//        Thread t2 = new Thread() {
//            public void run() {
//                s2 = sf.getCurrentSession();
//            }
//        };
//        t2.start();
//        t1.join();
//        t2.join();
// 
//        System.out.println(s1 == s2);
    	//openSession查询时候不需要事务
//    	SessionFactory sf = new Configuration().configure().buildSessionFactory();
//    	 
//        Session s1 = sf.openSession();
// 
//        s1.get(Product.class, 5);
// 
//        s1.close();
// 
//        sf.close();
    	//getCurrentSession所有操作都必须放在事务中
//    	SessionFactory sf = new Configuration().configure().buildSessionFactory();
//    	 
//        Session s1 = sf.getCurrentSession();
// 
//        s1.get(Product.class, 5);
// 
//        s1.close();
// 
//        sf.close();
    	//getCurrentSession在提交事务后，session自动关闭
    	SessionFactory sf = new Configuration().configure().buildSessionFactory();
    	 
        Session s1 = sf.getCurrentSession();
 
        s1.beginTransaction();
 
        s1.get(Product.class, 5);
 
        s1.getTransaction().commit();
         
        s1.close();
 
        sf.close();
    }
}