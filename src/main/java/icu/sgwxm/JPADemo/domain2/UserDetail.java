package icu.sgwxm.JPADemo.domain2;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 用户信息
 */
@Entity
@Table(name = "UserDetail")
@Getter
@Setter
public class UserDetail {
    @Id
    private Long id;

    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @org.hibernate.annotations.ForeignKey(name = "none")
    @JoinColumn(name = "actorId", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private Actor actor;

    private String truename;

}
