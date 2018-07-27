package com.brilliance.pubhealth.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;

import com.brilliance.pubhealth.pojo.User;
import com.brilliance.pubhealth.service.IUserService;


@Controller
@RequestMapping("/hello")
public class HelloController {
	String message = "Welcome to Spring MVC!";
	@Resource  
    private IUserService userService; 
    @RequestMapping("/getUser")
    public ModelAndView showMessage(@RequestParam(value = "id", required = false, defaultValue = "Spring") int id) {
 
        ModelAndView mv = new ModelAndView("hellospring");//指定视图
        mv.addObject("message", message);
        User user = this.userService.getUserById(id);  
        mv.addObject("user", user);  
        return mv;
    }
    @RequestMapping("/insertUser")
    public ModelAndView insertUser(@RequestParam(value = "id", required = false, defaultValue = "Spring") int id,
    		@RequestParam(value = "username", required = false, defaultValue = "Spring") String username
    		) {
 
        ModelAndView mv = new ModelAndView("insertspring");//指定视图
        mv.addObject("message", message);
        User user = new User();
        user.setId(id);
        user.setUserName(username);
        int count = userService.insert(user);
        mv.addObject("count", count);  
        return mv;
    }
}
