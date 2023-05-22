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
   public void add(Car car) {
      sessionFactory.getCurrentSession().save(car);
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
   public void getUserByCarId(int id){
      Session session = sessionFactory.openSession();
      Transaction transaction = session.beginTransaction();
      Car car = session.get(Car.class, id);
      System.out.println(car.getUser());
      transaction.commit();
      session.close();
   }


   @Override
//   public void getUserByCar(String carModel, int carSeries){
//
//      Session session = sessionFactory.openSession();
//      Transaction transaction = session.beginTransaction();
//      String selectCarModel = "FROM Car where model = :paramModel";
//      Query queryCarModel = session.createQuery(selectCarModel);
//      queryCarModel.setParameter("paramModel", carModel);
//      List<Car> car = queryCarModel.getResultList();
//
//      System.out.println(car);
//      transaction.commit();
//      session.close();
//   }

   public void getUserByCar(String carModel, int carSeries){

      Session session = sessionFactory.openSession();
      Transaction transaction = session.beginTransaction();
//      String selectCarModel = "FROM Car where model = :paramModel";
      String selectCarModel = "FROM Car car LEFT OUTER JOIN FETCH car.user WHERE car.model=:paramModel";
      Query queryCarModel = session.createQuery(selectCarModel, Car.class);
      queryCarModel.setParameter("paramModel", carModel);
      List<Car> car = queryCarModel.getResultList();
      for (Car cars : car) {
         System.out.println(cars.getUser());
      }
      transaction.commit();
      session.close();
   }
}
