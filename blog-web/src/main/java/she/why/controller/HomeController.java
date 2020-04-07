package she.why.controller;

import com.alibaba.druid.support.json.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import she.why.bean.IndexDetailVo;
import she.why.entity.IndexDetailEntity;
import she.why.resultUtils.BaseResult;
import she.why.resultUtils.ResultUtils;
import she.why.service.CommentService;
import she.why.service.IndexDetailService;

import java.lang.ref.PhantomReference;
import java.util.*;

/**
 * Created by xiaojun on 2020/3/31.
 */
@Slf4j
@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    private IndexDetailService indexDetailService;

    @GetMapping(value = {"/","/index"})
    public String view(){
        return "index";
    }


    @GetMapping(value = "/ajaxGetIndexDetail")
    @ResponseBody
    public List<IndexDetailVo> getIndexDetailVo(){
        List<IndexDetailVo> indexDetailVoList = new ArrayList<>();
        try {
           List<IndexDetailEntity> indexDetailEntityList = indexDetailService.getIndexDetailEntity();
           if (!CollectionUtils.isEmpty(indexDetailEntityList)) {
               for (IndexDetailEntity indexDetailEntity : indexDetailEntityList) {
                   IndexDetailVo indexDetailVo = new IndexDetailVo();
                   byte[] articleZhai = StringUtils.isEmpty(indexDetailEntity.getArticleZhai()) ? null : indexDetailEntity.getArticleZhai();
                   String article = JSONUtils.toJSONString(new String(articleZhai, "UTF-8"));
                   BeanUtils.copyProperties(indexDetailEntity, indexDetailVo);
                   indexDetailVo.setArticleZhai(article);
                   indexDetailVoList.add(indexDetailVo);
               }
           }
        } catch (Exception ex) {
           log.error("ajaxGetIndexDetail error: {}",ex.getMessage());
            throw new RuntimeException();
        }
        return indexDetailVoList;
    }
}
