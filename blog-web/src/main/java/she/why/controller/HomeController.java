package she.why.controller;

import com.alibaba.druid.support.json.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import she.why.bean.BlogArticleVo;
import she.why.entity.BlogArticleEntity;
import she.why.service.BlogArticleService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by xiaojun on 2020/3/31.
 */
@Slf4j
@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    private BlogArticleService blogArticleService;

    @GetMapping(value = {"/","/index"})
    public String view(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        if (session.getAttribute("userInfo") == null){
            return "error";
        }
        return "index";
    }


    @GetMapping(value = "/ajaxGetIndexDetail")
    @ResponseBody
    public List<BlogArticleVo> getIndexDetailVo(String label){
        List<BlogArticleVo> blogArticleVoList = new ArrayList<>();
        try {
           List<BlogArticleEntity> blogArticleEntityList = blogArticleService.getIndexDetailEntity(label);
           if (!CollectionUtils.isEmpty(blogArticleEntityList)) {
               for (BlogArticleEntity blogArticleEntity : blogArticleEntityList) {
                   BlogArticleVo blogArticleVo = new BlogArticleVo();
                   byte[] articleSummary = StringUtils.isEmpty(blogArticleEntity.getArticleSummary()) ? null : blogArticleEntity.getArticleSummary();
                   String article = JSONUtils.toJSONString(new String(articleSummary, "UTF-8"));
                   BeanUtils.copyProperties(blogArticleEntity, blogArticleVo);
                   blogArticleVo.setArticleSummary(article);
                   blogArticleVoList.add(blogArticleVo);
               }
           }
        } catch (Exception ex) {
           log.error("ajaxGetIndexDetail error: {}",ex.getMessage());
            throw new RuntimeException(ex);
        }
        return blogArticleVoList;
    }

        @RequestMapping ("/ajaxGetText")
        @ResponseBody
        public String getText( @RequestParam String usertext ){
                return "";
        }
}
