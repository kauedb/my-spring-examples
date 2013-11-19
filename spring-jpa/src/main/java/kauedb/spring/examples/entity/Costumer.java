package kauedb.spring.examples.entity;

import javax.persistence.*;

/**
 * User: kauedb
 * Date: 11/15/13
 * Time: 5:54 PM
 */
@Entity
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "costumerSequenceGenerator")
    @SequenceGenerator(name = "costumerSequenceGenerator", sequenceName = "SQ_COSTUMER", allocationSize = 1)
    @Column(name = "ID_COSTUMER")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this)
                .add("id", id)
                .add("firstName", firstName)
                .add("lastName", lastName)
                .toString();
    }
}
