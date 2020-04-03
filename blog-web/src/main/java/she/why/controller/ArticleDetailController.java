package she.why.controller;

import com.alibaba.druid.support.json.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import she.why.bean.ArticleDetailVo;
import she.why.entity.ArticleDetailEntity;
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

    @GetMapping("/{blogDetailId}")
    public String view(@PathVariable String blogDetailId, Model model){
        model.addAttribute("blogDetailId",blogDetailId);
        return "article_detail";
    }

    @GetMapping("/ajaxGetArticleDetail")
    @ResponseBody
    public ArticleDetailVo getArticleDetail(String blogDetailId) {
        ArticleDetailVo articleDetailVo = new ArticleDetailVo();
        try {
            ArticleDetailEntity articleDetail = articleDetailService.getArticleDetail(blogDetailId);
            BeanUtils.copyProperties(articleDetail, articleDetailVo);
            byte[] content = StringUtils.isEmpty(articleDetail.getContent()) ? null : articleDetail.getContent();
            String contentString = JSONUtils.toJSONString(new String(content, "UTF-8"));
            articleDetailVo.setContent(contentString);
        } catch (Exception e) {
            log.error("ajaxGetArticleDetail error: {}",e.getMessage());
            throw new RuntimeException();
        }
        return articleDetailVo;
    }

}
