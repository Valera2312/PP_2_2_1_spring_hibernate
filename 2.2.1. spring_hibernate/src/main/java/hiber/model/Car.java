package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    public Car() {
    }

    public Car(String model, String series) {
        this.model = model;
        this.series = series;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "model", nullable = false, length = 30)
    private String model;

    @Column(name = "series", nullable = false, length = 30)
    private String series;


    @OneToOne(mappedBy = "car")
    private User user;

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}