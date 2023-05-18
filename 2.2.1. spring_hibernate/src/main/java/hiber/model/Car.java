//package hiber.model;
//
//import javax.persistence.*;
//import java.util.Objects;
//
//@Entity
//@Table(name = "cars")
//public class Car {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "series")
//    int series;
//
//    @Column(name = "model")
//    String model;
//
//    public Car() {
//
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//
//    public int getSeries() {
//        return series;
//    }
//
//    public void setSeries(int series) {
//        this.series = series;
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }
//
//    @Override
//    public String toString() {
//        return "Car{" +
//                ", series=" + series +
//                ", model='" + model + '\'' +
//                '}';
//    }
//
//}
