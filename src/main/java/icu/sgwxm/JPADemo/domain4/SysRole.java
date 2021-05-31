package icu.sgwxm.JPADemo.domain4;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色数据模型
 */
@Entity
@Table(name = "sys_role")
@Getter
@Setter
public class SysRole implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="role_id")
    private Long roleId;
    @Column(name="role_name")
    private String roleName;
    @Column(name="role_memo")
    private String roleMemo;

    //多对多关系映射
    @ManyToMany
    @JoinTable(name = "user_role_rel",//中间表的名字
                //中间表  关键sys_role表的主键字段role_id
                joinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "role_id")},
                //中间表的字段关联sys_user表的主键user_id
                inverseJoinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "user_id")}
    )
    private Set<SysUser> users = new HashSet<>(0);

}
