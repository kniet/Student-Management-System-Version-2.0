package com.kniet.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class KnietAopExpressions {

    @Pointcut("execution(* com.kniet.service.StudentServiceImpl.saveStudent(..))")
    public void forSaveStudent() {}
}
