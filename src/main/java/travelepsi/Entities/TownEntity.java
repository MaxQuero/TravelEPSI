package travelepsi.Entities;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "towns", catalog = "TravelEPSI")
public class TownEntity implements Serializable {
    private int id;
    private String name;
    private int cp;
    private String country;
    private String dp;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "CP")
    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "DP")
    public String getDp() {
        return dp;
    }

    public void setDp(String dp) {
        this.dp = dp;
    }

    public TownEntity merge(TownEntity o) {
        if (o.name != null && !this.name.equals(o.name)) this.name = o.name;
        if (o.cp != 0) this.cp = o.cp;
        if (o.country != null && !this.country.equals(o.country)) this.country = o.country;
        if (o.dp != null && !this.dp.equals(o.dp)) this.dp = o.dp;

        return this;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TownEntity that = (TownEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (cp != that.cp) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (dp != null ? !dp.equals(that.dp) : that.dp != null) return false;

        return true;
    }
}
