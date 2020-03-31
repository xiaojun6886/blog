package she.why.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by xiaojun on 2020/3/31.
 */
@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    @RequestMapping(method = RequestMethod.GET)
    public String view(){
        return "article";
    }
}
