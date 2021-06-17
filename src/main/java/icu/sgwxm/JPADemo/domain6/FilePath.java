package icu.sgwxm.JPADemo.domain6;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "FilePath")
public class FilePath {

@Id
    private String id;
    private String path;
}
