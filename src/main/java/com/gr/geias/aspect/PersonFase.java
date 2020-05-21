package com.gr.geias.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020/5/21 10:24 上午
 */
@Aspect
@Component
public class PersonFase {
    private final String POINT_CUT = "execution(* com.gr.geias.mapper.PersonInfoMapper.delPersonById(..))";
    @Pointcut(POINT_CUT)
    private void pointcut(){}

    @After(value = POINT_CUT)
    public void doAfterAdvice(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Integer personId = (Integer)args[0];
        System.out.println("删除"+personId);
    }
}
