package com.lzg.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 记录日志类
 * 记录：请求的url
 *      访问者ip
 *      调用方法 classMethod
 *      参数 args
 *      返回的内容
 */

/**
 * @Component 开启组件扫描
 */
@Aspect
@Component
public class LogAspect {

    // 日志
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 定义切面
     * @Pointcut 通过这个注解使方法变为切面
     * execution(* com.lzg.web.*.*(..))"  标注要拦截哪些路径下的类
     */
    @Pointcut("execution(* com.lzg.web.*.*(..))")
    public void log() {}


    /**
     * 传参
     * @param joinPoint
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        // 请求参数
        Object[] args = joinPoint.getArgs();
        //  构造对象
        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
        logger.info("Request : {}", requestLog);
    }

    /**
     * 切面之后执行
     */
    @After("log()")
    public void doAfter() {
//        logger.info("--------doAfter--------");
    }

    /**
     *  方法拦截后
     *  获取返回的类型
     * @param result
     */
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturning(Object result) {
        logger.info("Result : {}", result);
    }


    /**
     * 内部类
     */
    private class RequestLog {
        /**
         *      请求的url
         *      访问者ip
         *      调用方法 classMethod
         *      请求的参数 args
         *      返回的内容
         */
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }

}
