package she.why.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import she.why.bean.UserBlogVo;
import she.why.resultUtils.BaseResult;
import she.why.resultUtils.ResultUtils;
import she.why.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by xiaojun on 2020/4/9.
 */

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * 异步查询用户名是否存在
     * @param fullName
     */
    @RequestMapping(value = "/ajaxGetFullName")
    @ResponseBody
    public BaseResult ajaxGetFullName(String fullName) {
        try {
            int count = loginService.queryUser(fullName);
            if (count>0){
                return ResultUtils.success();
            }
            return ResultUtils.error();
        }catch (Exception ex) {
            log.error("ajaxGetFullName err: ",ex);
            throw new RuntimeException(ex);
        }

    }

    @RequestMapping(value = "/ajaxRegisterBlog")
    @ResponseBody
    public BaseResult ajaxRegisterBlog(@RequestParam Map<String,String> params) {
        try {
            int count = loginService.registerBlog(params);
            if (count == 1) {
                return ResultUtils.success();
            }
            return ResultUtils.error();
        } catch (Exception ex) {
            log.error("ajaxRegisterBlog err: ",ex);
            throw new RuntimeException(ex);
        }
    }

    @RequestMapping(value = "/ajaxLoginIndex")
    @ResponseBody
    public BaseResult ajaxLoginIndex(String userName, String password) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();

        try {
            BaseResult baseResult = loginService.loginUser(userName, password);
            if ("200".equals(baseResult.getCode())) {
                Object model = baseResult.getModel();
                session.setAttribute("userInfo",model);
                return ResultUtils.success();
            }
            return ResultUtils.error(baseResult);
        }catch (Exception ex) {
            log.error("ajaxLoginIndex err: ",ex);
            throw new RuntimeException(ex);
        }
    }
}
