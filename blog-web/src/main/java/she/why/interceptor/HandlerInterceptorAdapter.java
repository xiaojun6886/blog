package she.why.interceptor;

import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by xiaojun on 2020/4/29.
 */

public class HandlerInterceptorAdapter implements AsyncHandlerInterceptor {

    /**
     * 默认是true
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        if(request.getRequestURI().contains("error") || request.getRequestURI().contains("login") || request.getRequestURI().contains("ajaxLoginIndex") ){
            return true;
        }
        if (session.getAttribute("userInfo") == null){
            request.getRequestDispatcher("/error").forward(request,response);
            return false;
        }
        return true;
    }

    /**
     * This implementation is empty.
     */
    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
    }

    /**
     * This implementation is empty.
     */
    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

    /**
     * 不是HandlerInterceptor的接口实现，是AsyncHandlerInterceptor的，AsyncHandlerInterceptor实现了HandlerInterceptor
     */
    @Override
    public void afterConcurrentHandlingStarted(
            HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
    }

}
