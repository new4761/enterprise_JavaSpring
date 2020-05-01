package kmitl_60050143.covid19_spring.controller;

import kmitl_60050143.covid19_spring.model.Covid19DailyReport;
import kmitl_60050143.covid19_spring.model.Covid19Timeline;
import kmitl_60050143.covid19_spring.service.Covid19DailyService;
import kmitl_60050143.covid19_spring.service.Covid19TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class TestJspAndServletController {


// not used in project for teaching only

    @Autowired
    private Covid19DailyService daliyService;
    @Autowired
    private Covid19TimelineService timelineService;

    @RequestMapping("/test")
    public ModelAndView next (Map<String, Object> model) {
        ModelAndView obj = new ModelAndView();
        obj.addObject("testservice", daliyService);
        obj.setViewName("student");
        return obj;
        //model.put("testservice",this.daliyService);
        // return "student"; }
    }

    @RequestMapping("/test/Daliy")
    public void testDaliy () {
        Covid19DailyReport obj = daliyService.getReport();
        System.out.println(obj.getConfirmed());
    }

    @RequestMapping("/test/timeline")
    public void timelineService () {
        Covid19Timeline obj = timelineService.getTimeline();
        System.out.println();
    }


}
