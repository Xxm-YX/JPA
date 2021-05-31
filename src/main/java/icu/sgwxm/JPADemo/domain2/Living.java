package icu.sgwxm.JPADemo.domain2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 生活的城市
 */
@Entity
@Table(name = "Living")
@Getter
@Setter
public class Living {

    @Id
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "actorId",foreignKey = @ForeignKey(name = "none",value = ConstraintMode.NO_CONSTRAINT))//这里的意思是不创建外键
    public Actor actor;


    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @org.hibernate.annotations.ForeignKey(name = "none")
    @JoinColumn(name = "userDetailId", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private UserDetail userDetail;

    @Column(nullable = false)
    @Enumerated(value = EnumType.ORDINAL)
    private  ActorType actorType = ActorType.A;


    public enum ActorType{
        A,B,C
    }
}
