package travelepsi.Entities;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by benjaminsenechal on 06/06/15.
 */


@Entity
@Table(name = "orders", catalog = "TravelEPSI")
public class OrderEntity implements Serializable {
    private int id;
    private Integer package_id;
    private Integer service_id;
    private Integer period_id;
    private PackageEntity pckage;
    private ServiceEntity service;
    private PeriodEntity period;
    private int nb_total_place;
    private int nb_remaining_place;
    private int price;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "nb_total_place")
    public int getNb_total_place() {
        return nb_total_place;
    }

    public void setNb_total_place(int nb_total_place) {
        this.nb_total_place = nb_total_place;
    }

    @Column(name = "nb_remaining_place")
    public int getNb_remaining_place() {
        return nb_remaining_place;
    }

    public void setNb_remaining_place(int nb_remaining_place) {
        this.nb_remaining_place = nb_remaining_place;
    }

    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Column(name = "package_id", insertable=false, updatable=false)
    public Integer getPackage_id() {
        return package_id;
    }
    public void setPackage_id(Integer package_id) {
        this.package_id = package_id;
    }

    @Column(name = "period_id", insertable=false, updatable=false)
    public Integer getPeriod_id() {
        return period_id;
    }

    public void setPeriod_id(Integer period_id) {
        this.period_id = period_id;
    }

    @Column(name = "service_id", insertable=false, updatable=false)
    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "package_id")
    public PackageEntity getPckage() {
        return this.pckage;
    }

    public void setPckage(PackageEntity pckage) {
        this.pckage = pckage;
    }

    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "service_id")
    public ServiceEntity getService() {
        return this.service;
    }

    public void setService(ServiceEntity service) {
        this.service = service;
    }

    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "period_id")
    public PeriodEntity getPeriod() {
        return this.period;
    }

    public void setPeriod(PeriodEntity period) {
        this.period = period;
    }
}
