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
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(Car car) {
      sessionFactory.getCurrentSession().save(car);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<Car> listCars() {
      TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car");
      return query.getResultList();
   }

   @Override
   public void removeCarById(Long id) {
      Session session = sessionFactory.openSession();
      Transaction transaction = session.beginTransaction();
      try {
         session.delete(session.get(Car.class, id));
         transaction.commit();
         System.out.println("Car удален");
      } catch (HibernateException | IllegalArgumentException e) {
         System.err.println("Не удалось удалить Car");
         if (transaction != null) {
            transaction.rollback();
         }
      } finally {
         session.close();
      }
   }

   @Override
   public Car getCarById(Long id) {
      Car car = null;
      Session session = sessionFactory.openSession();
      Transaction transaction = session.beginTransaction();
      try {
         car = session.get(Car.class, id);
         transaction.commit();
         System.out.println("Car получен");
      } catch (HibernateException | IllegalArgumentException e) {
         System.err.println("Не удалось получить Car");
         if (transaction != null) {
            transaction.rollback();
         }
      } finally {
         session.close();
      }
      return car;
   }



}
