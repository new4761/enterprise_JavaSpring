package kmitl_60050143.covid19_spring.controller;


import kmitl_60050143.covid19_spring.model.*;
import kmitl_60050143.covid19_spring.service.Covid19CaseService;
import kmitl_60050143.covid19_spring.service.Covid19CaseSummaryService;
import kmitl_60050143.covid19_spring.service.Covid19DailyService;
import kmitl_60050143.covid19_spring.service.Covid19TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;


// define bean to be  RestController
@RestController
//  Mapping path to /api/covid19
@RequestMapping("api/covid19")
public class Covid19Controller {

    //use Covid19DaliyService bean
    @Autowired
    private Covid19DailyService dailyService;
    //use Covid19TimelineService bean
    @Autowired
    private Covid19TimelineService timelineService;
    //use Covid19CaseService bean
    @Autowired
    private Covid19CaseService caseService;
    //use Covid19CaseSummaryService bean
    @Autowired
    private Covid19CaseSummaryService caseSummaryService;

    /* ***********  unused api (no data) ***********
    @Value("${covid19.api.area}")
    private String areaUrl;
    */


    //use RestTemplate bean
    @Autowired
    RestTemplate restTemplate;

    //************************************************
    // start define restful path for dailyReport

    //Get DailyReport
    @GetMapping(path = "/daily", produces = "application/json")
    public Covid19DailyReport daily () {
        return dailyService.getReport();
    }

    // start define restful path for timelineReport
    //Get allTimelineReport
    @GetMapping(path = "/timeline", produces = "application/json")
    public Covid19Timeline timeline () {
        return timelineService.getTimeline();
    }

    //Get Timeline report  by date  => using query parameter (date)
    @GetMapping(path = "/timeline/report", produces = "application/json")
    public Covid19DailyReport timelineByDate (@RequestParam("date") String date) {
        //System.out.println(date);
        return timelineService.getReportbyDate(date);
    }

    //************************************************
    // start define restful path for CaseReport

    //Get allCaseReport
    @GetMapping(path = "/cases", produces = "application/json")
    public Covid19CaseReport cases () {
        return caseService.getCaseReport();
    }

    //Get CaseReport report  by Number  => using query parameter (no)
    @GetMapping(path = "/cases/no/{no}", produces = "application/json")
    public Covid19CaseDetails findCasesById (@PathVariable("no") int no) {
        return caseService.findCaseById(no);
    }

    //Get CaseReport report  by condition  => using query parameter (age,gender,province,nation)
    @GetMapping(path = "/cases/filter", produces = "application/json")
    public Map findCasesByfilter
    (@RequestParam(required = false, name = "age") Integer age, @RequestParam(required = false, name = "gender") String gender, @RequestParam(required = false, name = "province") String province, @RequestParam(required = false, name = "nation") String nation) {
        Map data = new HashMap<>();
        data.put("Data",caseService.findCaseByFilter(age, gender, province, nation));
        data.put("UpdateDate",caseService.getCaseReport().getUpdateDate());
        return data;
    }

    //Get CaseReport report  by Age  between max and min)  => using query parameter (max,min)
    @GetMapping(path = "/cases/age/range", produces = "application/json")
    public Map findCasesByAge (@RequestParam("max") int max, @RequestParam("min") int min) {
        Map data = new HashMap<>();
        data.put("Data",caseService.findCaseByAge(max, min));
        data.put("UpdateDate",caseService.getCaseReport().getUpdateDate());
        return data;

    }

    //Get CaseReport report  by Gender    => using query parameter (sex)
    @GetMapping(path = "/cases/gender", produces = "application/json")
    public Map findCasesByGender (@RequestParam("sex") String sex) {
        Map data = new HashMap<>();
        data.put("Data", caseService.findCaseByGender(sex));
        data.put("UpdateDate",caseService.getCaseReport().getUpdateDate());
        return data;
    }

    //Get CaseReport report  by Province (use format ProvinceEn) => using query parameter (name)
    @GetMapping(path = "/cases/province", produces = "application/json")
    public Map findCaseByProvince (@RequestParam("name") String name) {
        Map data = new HashMap<>();
        data.put("Data", caseService.findCaseByProvince(name));
        data.put("UpdateDate",caseService.getCaseReport().getUpdateDate());
        return data;
    }

    //Get CaseReport report  by Nation  (use format NationEn) => using query parameter (name)
    @GetMapping(path = "/cases/nation", produces = "application/json")
    public Map findCaseByNation (@RequestParam("name") String name) {
        Map data = new HashMap<>();
        data.put("Data", caseService.findCaseByNation(name));
        data.put("UpdateDate",caseService.getCaseReport().getUpdateDate());
        return data;
    }

    //************************************************
    // start define restful path for CaseSummaryReport

    //Get CaseSummaryCaseReport
    @GetMapping(path = "/cases/sums", produces = "application/json")
    public Covid19CaseSummary sumsCase () {
        return caseSummaryService.getCaseSummaryReport();
    }

    //Get CaseSummaryCaseReport only Gender
    @GetMapping(path = "/cases/sums/gender", produces = "application/json")
    public Map sumsCaseGender () {
        Map data = new HashMap<>();
        data.put("Gender", caseSummaryService.getCaseSummaryGender());
        data.put("UpdateDate",caseSummaryService.getCaseSummaryReport().getUpdateDate());
        return data;
    }

    //Get CaseSummaryCaseReport only Gender BySpecify sex => using query parameter (sex)
    @GetMapping(path = "/cases/sums/gender/select", produces = "application/json", params = "sex")
    public Map MapsumsCaseGenderBySex (@RequestParam("sex") String sex) {
        Map data = new HashMap<>();
        data.put(sex, caseSummaryService.getCaseSummaryGenderBySex(sex));
        data.put("UpdateDate",caseSummaryService.getCaseSummaryReport().getUpdateDate());
        return data;
    }

    //Get CaseSummaryCaseReport  only Gender key data
    @GetMapping(path = "/cases/sums/gender/keys", produces = "application/json")
    public Set<String> sumsCaseGenderGetkey () {
        return caseSummaryService.getCaseSummaryGenderGetkey();
    }

    //Get CaseSummaryCaseReport only Nation
    @GetMapping(path = "/cases/sums/nation", produces = "application/json")
    public Map sumsCaseNation () {
        Map data = new HashMap<>();
        data.put("Nation", caseSummaryService.getCaseSummaryNation());
        data.put("UpdateDate",caseSummaryService.getCaseSummaryReport().getUpdateDate());
        return data;
    }

    //Get CaseSummaryCaseReport only Nation BySpecify name (use format NationEn)  => using query parameter (name)
    @GetMapping(path = "/cases/sums/nation/select", produces = "application/json", params = "name")
    public Map sumsCaseNationByName (@RequestParam("name") String name) {
        Map data = new HashMap<>();
        data.put(name, caseSummaryService.getCaseSummaryNationByName(name));
        data.put("UpdateDate",caseSummaryService.getCaseSummaryReport().getUpdateDate());
        return data;
    }

    //Get CaseSummaryCaseReport  only Nation key data
    @GetMapping(path = "/cases/sums/nation/keys", produces = "application/json")
    public Set<String> sumsCaseNationGetkey () {
        return caseSummaryService.getCaseSummaryNationGetkey();
    }

    //Get CaseSummaryCaseReport only Province
    @GetMapping(path = "/cases/sums/province", produces = "application/json")
    public Map sumsCaseProvince () {
        Map data = new HashMap<>();
        data.put("Province", caseSummaryService.getCaseSummaryProvince());
        data.put("UpdateDate",caseSummaryService.getCaseSummaryReport().getUpdateDate());
        return data;
    }

    //Get CaseSummaryCaseReport only Province BySpecify name (use format ProvinceEn)  => using query parameter (name)
    @GetMapping(path = "/cases/sums/province/select", produces = "application/json", params = "name")
    public Map sumsCaseProvinceByName (@RequestParam("name") String name) {
        Map data = new HashMap<>();
        //map return value for know data meaning
        data.put(name, caseSummaryService.getCaseSummaryProvinceByName(name));
        data.put("UpdateDate",caseSummaryService.getCaseSummaryReport().getUpdateDate());
        return data;
    }

    //Get CaseSummaryCaseReport  only Province key data
    @GetMapping(path = "/cases/sums/province/keys", produces = "application/json")
    public Set<String> sumsCaseProvinceGetKey () {
        return caseSummaryService.getCaseSummaryProvinceGetkey();
    }


   /* @GetMapping(path = "/area", produces = "application/json")
    public String area () {
        return restTemplate.getForObject(areaUrl, String.class);
    } */


   /* @GetMapping(path = "/test", produces = "application/json")
    public testJson testCase () {
        String url = "https://jsonplaceholder.typicode.com/todos/1";
        return restTemplate.getForObject(url, testJson.class);
    }*/

}