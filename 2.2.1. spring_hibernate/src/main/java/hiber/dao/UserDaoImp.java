package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;


   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }


   @Override
   public void removeUserById(Long id) {
      Session session = sessionFactory.openSession();
      Transaction transaction = session.beginTransaction();
      try {
         session.delete(session.get(User.class, id));
         transaction.commit();
         System.out.println("User удален");
      } catch (HibernateException | IllegalArgumentException e) {
         System.err.println("Не удалось удалить Usera");
         if (transaction != null) {
            transaction.rollback();
         }
      } finally {
         session.close();
      }
   }
   @Override
   public User getUserById(Long id){
      User user = null;
      Session session = sessionFactory.openSession();
      Transaction transaction = session.beginTransaction();
      try {
         user = session.get(User.class, id);
         transaction.commit();
         System.out.println("User получен");
      } catch (HibernateException | IllegalArgumentException e) {
         System.err.println("Не удалось получить Usera");
         if (transaction != null) {
            transaction.rollback();
         }
      } finally {
         session.close();
      }
      return user;
   }
   @Override
   public void getUserByCarId(int carId){
      Session session = sessionFactory.openSession();
      Transaction transaction = session.beginTransaction();
      String user = null;
      String hql = "SELECT cars.*, users.`name` as `user_name`\n" +
                 "FROM cars INNER JOIN users ON (cars.`id`=users.`id`)\n" +
                 "WHERE cars.`id`= " + carId;
      try {
//         user = (User) session.createQuery(hql, Car.class);
//         car = session.createQuery(hql, Car.class).setParameter("addrId", 1).uniqueResult();
         Query query = session.createQuery(hql, Car.class);
         user = query.toString();
         transaction.commit();
      } catch (HibernateException | IllegalArgumentException e) {
         System.err.println("Не удалось получить UserByCarId");
         if (transaction != null) {
            transaction.rollback();
         }
      } finally {
         session.close();
      }
   }
}
