package icu.sgwxm.JPADemo.dao;

import icu.sgwxm.JPADemo.domain.Labor;
import icu.sgwxm.JPADemo.domain2.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface User1Dao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>{
}
