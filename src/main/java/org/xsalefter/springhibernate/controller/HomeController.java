package org.xsalefter.springhibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author xsalefter (xsalefter@gmail.com)
 */
@Controller
public class HomeController {

    @RequestMapping(value="/index.html")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
}
