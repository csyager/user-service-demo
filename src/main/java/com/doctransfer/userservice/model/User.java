package com.doctransfer.userservice.model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @SequenceGenerator(name="users_id_seq",
                        sequenceName="users_id_seq",
                        allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,
                    generator="users_id_seq")
    @Column(name="id")
    private long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="middle_name")
    private String middleName;

    protected User() {}

    public User(
            long id,
            String firstName,
            String lastName,
            String middleName
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public User(
            String firstName,
            String lastName,
            String middleName
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
