package icu.sgwxm.JPADemo.domain6;

import icu.sgwxm.JPADemo.domain3.Customer;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * 联系人的实体类（数据模型）   从表！！！
 */
@Entity
@Table(name="cst_path")
@Getter
@Setter
public class Path implements Serializable {
    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name="lkm_id")
    private UUID lkmId;
    @Column(name="lkm_path")
    private String path;


    @ManyToOne(targetEntity= Model.class)
    @JoinColumn(name="lkm_cust_id",foreignKey =  @ForeignKey(name = "none",value = ConstraintMode.NO_CONSTRAINT))
    private Model model;

    @Override
    public String toString() {
        return "Path{" +
                "lkmId=" + lkmId +
                ", path='" + path + '\'' +

                '}';
    }
}
