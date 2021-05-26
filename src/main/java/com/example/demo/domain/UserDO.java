package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

//@Proxy(lazy = false)
@Entity
@Table(name = "AUTH_USER")
@Data
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class UserDO implements Serializable {

    @Id
    private Long id;
    @Column(length = 32)
    private String name;
    @Column(length = 32)
    private String account;
    @Column(length = 64)
    private String pwd;
}
