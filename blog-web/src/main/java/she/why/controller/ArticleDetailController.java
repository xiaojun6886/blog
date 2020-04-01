package she.why.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import she.why.bean.ArticleDetailVo;
import she.why.entity.ArticleDetailEntity;
import she.why.service.ArticleDetailService;

import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.util.HashMap;

/**
 * Created by xiaojun on 2020/3/31.
 */
@Controller
@RequestMapping(value = "/article/detail")
public class ArticleDetailController {

    @Autowired
    private ArticleDetailService articleDetailService;

    @GetMapping("/{blogDetailId}")
    public String view(@PathVariable String blogDetailId,Model model) throws UnsupportedEncodingException {
        if (!StringUtils.isNullOrEmpty(blogDetailId)) {
            ArticleDetailEntity articleDetail = articleDetailService.getArticleDetail(blogDetailId);
            ArticleDetailVo articleDetailVo = new ArticleDetailVo();
            BeanUtils.copyProperties(articleDetail, articleDetailVo);
            byte[] content = articleDetail.getContent();
            String contentString = JSONUtils.toJSONString(new String(content, "UTF-8"));
            articleDetailVo.setContent(contentString);
            model.addAttribute("articleDetailVo", articleDetailVo);
        }
        return "article_detail";
    }

}
