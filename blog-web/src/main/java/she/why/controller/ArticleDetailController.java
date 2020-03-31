package she.why.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xiaojun on 2020/3/31.
 */
@Controller
@RequestMapping(value = "/article/detail")
public class ArticleDetailController {

    @GetMapping
    public String view(){
        return "article_detail";
    }
}
