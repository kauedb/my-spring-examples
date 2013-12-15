package kauedb.spring.examples.entity;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Date;

/**
 * User: kauedb
 * Date: 11/15/13
 * Time: 7:42 PM
 */
@Entity
public class Account {

    @Id
    @Column(name = "ID_ACCOUNT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountSequenceGenerator")
    @SequenceGenerator(name = "accountSequenceGenerator", sequenceName = "SQ_ACCOUNT")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_COSTUMER")
    private Costumer costumer;

    @Column(name = "EXPIRED_DATE")
    private Date expiredDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("costumer", costumer)
                .add("expiredDate", expiredDate)
                .toString();
    }
}
