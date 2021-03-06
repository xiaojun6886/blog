package she.why.controller;

import com.alibaba.druid.support.json.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import she.why.bean.BlogArticleVo;
import she.why.entity.BlogArticleEntity;
import she.why.service.ArticleDetailService;

/**
 * Created by xiaojun on 2020/3/31.
 */
@Slf4j
@Controller
@RequestMapping(value = "/article/detail")
public class ArticleDetailController {

    @Autowired
    private ArticleDetailService articleDetailService;

    @GetMapping(value = "/{blogDetailId}")
    public String view(@PathVariable String blogDetailId, Model model){
        model.addAttribute("blogDetailId", blogDetailId);
        return "article_detail";
    }

    @GetMapping("/ajaxGetArticleDetail")
    @ResponseBody
    public BlogArticleVo getArticleDetail(String blogDetailId) {
        BlogArticleVo blogArticleVo = new BlogArticleVo();
        try {
            BlogArticleEntity blogArticleEntity = articleDetailService.getArticleDetail(blogDetailId);
            if (blogArticleEntity != null) {
                BeanUtils.copyProperties(blogArticleEntity, blogArticleVo);
                byte[] content = StringUtils.isEmpty(blogArticleEntity.getContent()) ? null : blogArticleEntity.getContent();
                String contentString = JSONUtils.toJSONString(new String(content, "UTF-8"));
                blogArticleVo.setContent(contentString);
            }else {
                blogArticleVo.setTitle("博主努力开发中...");
                blogArticleVo.setContent("      敬请期待...    ");
            }
        } catch (Exception e) {
            log.error("ajaxGetArticleDetail error: {}",e.getMessage());
            throw new RuntimeException(e);
        }
        return blogArticleVo;
    }

}
