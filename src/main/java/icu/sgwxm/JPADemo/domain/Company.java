package icu.sgwxm.JPADemo.domain;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Company")
@Data
public class Company {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "employeesNumber")
    private int employeesNumber;

}
