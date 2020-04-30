package kmitl_60050143.covid19_spring.controller;

import kmitl_60050143.covid19_spring.model.Covid19DaliyReport;
import kmitl_60050143.covid19_spring.model.Covid19Timeline;
import kmitl_60050143.covid19_spring.service.Covid19DaliyService;
import kmitl_60050143.covid19_spring.service.Covid19TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
    
@Controller
public class IndexController {

    @Autowired
    private Covid19DaliyService daliyService;
    @Autowired
    private Covid19TimelineService timelineService;
    @RequestMapping("/")
    public ModelAndView next(Map<String, Object> model) {
        return new ModelAndView("student").addObject("testservice", daliyService);
        //model.put("testservice",this.daliyService);
        // return "student"; }
    }
    @RequestMapping("/test/Daliy")
    public void testDaliy() {
        Covid19DaliyReport obj = daliyService.getReport();
        System.out.println(obj.getConfirmed());
    }
    @RequestMapping("/test/timeline")
    public void timelineService() {
        Covid19Timeline obj = timelineService.getTimeline();
        System.out.println();
    }


}
