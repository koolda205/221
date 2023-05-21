package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Column(name = "model")
   private String model;

   @Column(name = "series")
   private int series;

   @OneToOne (mappedBy = "car",
   cascade = CascadeType.ALL)
   private User user;

    public Car() {}

   public Car(String model, int series) {
      this.model = model;
      this.series = series;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getId() {
      return id;
   }

   public String getModel() {
      return model;
   }

   public void setSeries(int series) {
      this.series = series;
   }

   public int getSeries() {
      return series;
   }

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }

   @Override
   public String toString() {
      return "Car{" +
              "id=" + id +
              ", model='" + model + '\'' +
              ", series=" + series +
              '}';
   }
}
