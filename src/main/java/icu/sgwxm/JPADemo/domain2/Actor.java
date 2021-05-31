package icu.sgwxm.JPADemo.domain2;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色
 */
@Entity
@Table(name = "Actor")
@Getter
@Setter
public class Actor {

    @Id
    private Long id;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @JoinColumn(name = "actorId")
    @org.hibernate.annotations.ForeignKey(name = "none")
    private List<Living> livings = new ArrayList<>();

    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @org.hibernate.annotations.ForeignKey(name = "none")
    @JoinColumn(name = "userDetailId", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private UserDetail userDetail;
}
