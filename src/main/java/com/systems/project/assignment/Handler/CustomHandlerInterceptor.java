package com.systems.project.assignment.Handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.util.stream.Collectors;

@Component
public class CustomHandlerInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory .getLogger(CustomHandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = Instant.now().toEpochMilli();
        HttpServletRequest cacherequestwrapper =new ContentCachingRequestWrapper(request);
        HttpServletResponse cacheresponsewrapper = new ContentCachingResponseWrapper(response);
        logger.info("Request URL::" + request.getRequestURL().toString() + ":: Start Time=" + Instant.now());
        logger.info("request:"+cacherequestwrapper.getReader());
        //  logger.info("request:"+ cacherequestwrapper.getReader().lines().collect(Collectors.joining()));
        request.setAttribute("startTime", startTime);
        logger.info("response:"+cacheresponsewrapper.getWriter());
        return true;
//        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        long startTime = (Long) request.getAttribute("startTime");

        logger.info("Request URL::" + request.getRequestURL().toString() +
                ":: Time Taken=" + (Instant.now().toEpochMilli() - startTime));

        // super.afterCompletion(request, response, handler, ex);
    }
}
