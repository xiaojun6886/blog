package she.why.controller;

import com.alibaba.druid.support.json.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import she.why.bean.ArticleDetailVo;
import she.why.bean.IndexDetailVo;
import she.why.entity.ArticleDetailEntity;
import she.why.entity.IndexDetailEntity;
import she.why.service.ArticleDetailService;

import java.awt.*;
import java.lang.reflect.Type;
import java.net.URLDecoder;

/**
 * Created by xiaojun on 2020/3/31.
 */
@Slf4j
@Controller
@RequestMapping(value = "/article/detail")
public class ArticleDetailController {

    @Autowired
    private ArticleDetailService articleDetailService;

    @GetMapping(value = "/{pathId}/{param}")
    public String view(@PathVariable String pathId,@PathVariable String param, Model model){
        if ("blogDetailId".equals(pathId)) {
            model.addAttribute("blogDetailId", param);
        }else {
            model.addAttribute("label", param);
        }
        return "article_detail";
    }

    @GetMapping("/ajaxGetArticleDetail")
    @ResponseBody
    public IndexDetailVo getArticleDetail(String blogDetailId,String label) {
        IndexDetailVo indexDetailVo = new IndexDetailVo();
        try {
            IndexDetailEntity indexDetailEntity = articleDetailService.getArticleDetail(blogDetailId, label);
            if (indexDetailEntity != null) {
                BeanUtils.copyProperties(indexDetailEntity, indexDetailVo);
                byte[] content = StringUtils.isEmpty(indexDetailEntity.getContent()) ? null : indexDetailEntity.getContent();
                String contentString = JSONUtils.toJSONString(new String(content, "UTF-8"));
                indexDetailVo.setContent(contentString);
            }else {
                indexDetailVo.setTitle("博主努力开发中...");
                indexDetailVo.setContent("      敬请期待...    ");
            }
        } catch (Exception e) {
            log.error("ajaxGetArticleDetail error: {}",e.getMessage());
            throw new RuntimeException();
        }
        return indexDetailVo;
    }

}
