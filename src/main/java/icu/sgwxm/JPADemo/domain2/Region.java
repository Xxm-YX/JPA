package icu.sgwxm.JPADemo.domain2;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * 地区
 */
@Entity
@Table(name = "Region")
@Getter
@Setter
public class Region {
    @Id
    private Long id;

    private String name;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @JoinColumn(name = "regionId")
    @org.hibernate.annotations.ForeignKey(name = "none")
    private List<Living> Livings;
}