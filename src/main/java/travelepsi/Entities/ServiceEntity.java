package travelepsi.Entities;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by benjaminsenechal on 29/05/15.
 */

@Entity
@Table(name = "services", catalog = "TravelEPSI")
public class ServiceEntity implements Serializable {
    private int id;
    private String wording;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "wording")
    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

}
