package icu.sgwxm.JPADemo.dao;


import icu.sgwxm.JPADemo.domain4.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysRoleDao extends JpaRepository<SysRole,Long> , JpaSpecificationExecutor<SysRole> {
}
