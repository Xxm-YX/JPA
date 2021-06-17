package icu.sgwxm.JPADemo.domain2;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user1")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uid",nullable = false)
    private Long uid;

    @Column(name = "uname",nullable = true)
    private String uname;

    @Column(name = "utel",nullable = true)
    private String utel;

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", utel='" + utel + '\'' +
                '}';
    }
}
