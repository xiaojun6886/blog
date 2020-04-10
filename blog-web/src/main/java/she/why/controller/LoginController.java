package she.why.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import she.why.bean.UserBlogVo;
import she.why.entity.UserBlogEntity;
import she.why.resultUtils.BaseResult;
import she.why.resultUtils.ResultUtils;
import she.why.service.LoginService;

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
    public void ajaxGetFullName(String fullName) {

    }

    @RequestMapping(value = "/ajaxRegisterBlog")
    @ResponseBody
    public BaseResult ajaxRegisterBlog(@RequestParam Map<String,String> params) {
        try {
            UserBlogEntity userBlogEntity = new UserBlogEntity();
            userBlogEntity.setUserName(StringUtils.isEmpty(params.get("fullName")) ? "" : params.get("fullName"));
            userBlogEntity.setEmail(StringUtils.isEmpty(params.get("email")) ? "" : params.get("email"));
            userBlogEntity.setPassword(StringUtils.isEmpty(params.get("password")) ? "" : params.get("password"));
            int count = loginService.registerBlog(userBlogEntity);
            if (count == 1) {
                return ResultUtils.success();
            }
            return ResultUtils.error();
        } catch (Exception ex) {
            log.error("ajaxRegisterBlog err: ",ex);
            throw new RuntimeException(ex);
        }
    }
}
