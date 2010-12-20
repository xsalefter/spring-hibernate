package org.xsalefter.springhibernate.controller;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.xsalefter.springhibernate.service.ApplicationLogService;

/**
 * @author xsalefter (xsalefter@gmail.com)
 */
@Controller
public class ApplicationLogController {

    @Inject private ApplicationLogService applicationLogService;

    @RequestMapping(value="/application-log/index.html")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("logs", this.applicationLogService.selectAll());
        mav.addObject("logsDTO", this.applicationLogService.selectAllWithDTO());
        mav.setViewName("log/index");
        return mav;
    }
}
