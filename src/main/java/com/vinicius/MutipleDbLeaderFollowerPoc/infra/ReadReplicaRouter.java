package com.vinicius.MutipleDbLeaderFollowerPoc.infra;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Aspect
@Component
@Order(0)
public class ReadReplicaRouter {

    @Around("@annotation(transactional)")
    public Object readReplica(
            ProceedingJoinPoint joinPoint,
            Transactional transactional
    ) throws Throwable {

        try {
            if (transactional.readOnly()) {
                DataSourceContextHolder.setDataSourceKey("replica");
            } else {
                DataSourceContextHolder.setDataSourceKey("primary");
            }

            return joinPoint.proceed();
        } finally {
            DataSourceContextHolder.clear();
        }
    }
}
