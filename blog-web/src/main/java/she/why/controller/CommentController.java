package she.why.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import she.why.resultUtils.BaseResult;
import she.why.resultUtils.ResultUtils;
import she.why.service.CommentService;

/**
 * Created by xiaojun on 2020/3/31.
 */
@Controller
@RequestMapping(value = "/comment")
public class CommentController {


    @Autowired
    private CommentService commentService;

    @GetMapping
    public String view(){
        return "comment";
    }

    @RequestMapping ("/ajaxGetText")
    @ResponseBody
    public BaseResult getText(@RequestParam String usertext ){
        BaseResult result;
        int i = commentService.insertMessage(usertext);
        if (i==1){
            return ResultUtils.success();
        }
        return ResultUtils.error();
    }



}
