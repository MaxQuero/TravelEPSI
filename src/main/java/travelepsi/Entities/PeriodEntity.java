package travelepsi.Entities;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by benjaminsenechal on 28/05/15.
 */
@Entity
@Table(name = "periods", catalog = "TravelEPSI")
public class PeriodEntity implements Serializable {
    private int id;
    private Date startDT;
    private Date endDT;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "startDT")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="CET")
    public Date getStartDT() {
        return startDT;
    }
    public void setStartDT(Date startDT) {
        this.startDT = startDT;
    }

    @Column(name = "endDT")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="CET")
    public Date getEndDT() {
        return endDT;
    }
    public void setEndDT(Date endDT) {
        this.endDT = endDT;
    }
}
