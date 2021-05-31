package icu.sgwxm.JPADemo.domain4;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户数据模型
 */
@Entity
@Table(name = "sys_user")
@Getter
@Setter
public class SysUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private Long userId;
    @Column(name="user_code")
    private String userCode;
    @Column(name="user_name")
    private String userName;
    @Column(name="user_password")
    private String userPassword;
    @Column(name="user_state")
    private String userState;

    //多对多关系映射
    @ManyToMany(mappedBy = "users") //避免中间包冗余
//    @ManyToMany(targetEntity = SysRole.class)
    private Set<SysRole> roles = new HashSet<SysRole>(0);


}
