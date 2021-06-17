package com.example.demo.domain;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/getUser")
    public ApiResultTO<UserTO> getUser(){
        //查询返回
        return ApiResultTO.buildSuccess(new UserTO());
    }

    public ApiResultTO<UserTO> getUser1(){
        //参数校验失败
        if(StringUtils.isEmpty("")){
// 也可以把常见的错误信息抽取到ErrorCodeEnum并传入（参考小册《枚举的应用》）
            return ApiResultTO.buildFailed(ExceptionEnum.USER_NOT_FOUND);
        }
        return null;
    }
}
