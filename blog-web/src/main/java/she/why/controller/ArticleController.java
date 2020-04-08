package she.why.controller;

import com.alibaba.druid.support.json.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import she.why.bean.BlogArticleVo;
import she.why.entity.BlogArticleEntity;
import she.why.service.ArticleService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojun on 2020/3/31.
 */
@Slf4j
@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = {"","/{label}"})
    public String view(@PathVariable(required = false) String label, Model model){
        model.addAttribute("label",label);
        return "article";
    }

    @GetMapping("/ajaxGetBlogArticle")
    @ResponseBody
    public List<BlogArticleVo> getBlogArticle(String label){
        List<BlogArticleVo> blogArticleVoList = new ArrayList<>();
        try {
            List<BlogArticleEntity> blogArticleEntities = articleService.queryArticleList(label);
            if (!CollectionUtils.isEmpty(blogArticleEntities)){
                for (BlogArticleEntity blogArticleEntity : blogArticleEntities) {
                    BlogArticleVo blogArticleVo = new BlogArticleVo();
                    byte[] articleSummary = blogArticleEntity.getArticleSummary();
                    String s = JSONUtils.toJSONString(new String(articleSummary, "UTF-8"));
                    BeanUtils.copyProperties(blogArticleEntity,blogArticleVo);
                    blogArticleVo.setArticleSummary(s);
                    blogArticleVoList.add(blogArticleVo);
                }
            }
        } catch (Exception ex) {
            log.error("ajaxGetBlogArticle error: {}",ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
        return blogArticleVoList;
    }
}
