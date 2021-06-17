package icu.sgwxm.JPADemo.dao;

import icu.sgwxm.JPADemo.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ModelDao extends JpaRepository<Role,Long>, JpaSpecificationExecutor<Role> {


}
