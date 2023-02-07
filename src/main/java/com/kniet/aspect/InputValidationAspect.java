package com.kniet.aspect;

import com.kniet.entity.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class InputValidationAspect {

    Logger logger = Logger.getLogger(getClass().getName());

    @Around("com.kniet.aspect.KnietAopExpressions.forSaveStudent()")
    public void aroundSaveStudent(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        int i = 0;
        logger.info("Executing @Around on method: " + proceedingJoinPoint
                .getSignature().toShortString());
        Object[] modifiedArgs = proceedingJoinPoint.getArgs();
        for (Object arg : modifiedArgs) {
            if (arg instanceof Student) {
                ((Student) arg).setFirstName(Character.
                        toUpperCase(((Student) arg).getFirstName().charAt(0))
                        + ((Student) arg).getFirstName().substring(1).toLowerCase());

                ((Student) arg).setLastName(Character.
                        toUpperCase(((Student) arg).getLastName().charAt(0))
                                + ((Student) arg).getLastName().substring(1).toLowerCase());

                ((Student) arg).setClassGroup(((Student) arg).getClassGroup().toUpperCase());

                modifiedArgs[i] = arg;
            }
            i++;
        }
        proceedingJoinPoint.proceed(modifiedArgs);
    }
}
