package she.why.controller;

import com.alibaba.druid.support.json.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import she.why.bean.BlogArticleVo;
import she.why.entity.BlogArticleEntity;
import she.why.service.BlogArticleService;

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
        return "index";
    }


    @GetMapping(value = "/ajaxGetIndexDetail")
    @ResponseBody
    public List<BlogArticleVo> getIndexDetailVo(){
        List<BlogArticleVo> blogArticleVoList = new ArrayList<>();
        try {
           List<BlogArticleEntity> blogArticleEntityList = blogArticleService.getIndexDetailEntity();
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
            throw new RuntimeException();
        }
        return blogArticleVoList;
    }

        @RequestMapping ("/ajaxGetText")
        @ResponseBody
        public String getText( @RequestParam String usertext ){
                return "";
        }
}
