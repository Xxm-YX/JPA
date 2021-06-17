package icu.sgwxm.JPADemo.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

@Data
public class PageParam<T> {
    private Integer pageSize = 2;  //页面大小
    private Integer pageNumber = 0;// 初始页数
    private String searchName; //查找名字
    private String searchMobile;    //查找手机号
    private String searchId;    //查找ID

}
