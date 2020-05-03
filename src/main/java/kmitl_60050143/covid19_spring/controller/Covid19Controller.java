package kmitl_60050143.covid19_spring.controller;


import io.swagger.annotations.*;
import kmitl_60050143.covid19_spring.model.*;
import kmitl_60050143.covid19_spring.service.Covid19CaseService;
import kmitl_60050143.covid19_spring.service.Covid19CaseSummaryService;
import kmitl_60050143.covid19_spring.service.Covid19DailyService;
import kmitl_60050143.covid19_spring.service.Covid19TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@CrossOrigin
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
    @ApiOperation( value  = "Covid19Daliy Report",response  =   Covid19DailyReport.class)
    public Covid19DailyReport daily () {
        return dailyService.getReport();
    }

    // start define restful path for timelineReport
    //Get allTimelineReport
    @ApiOperation( value  = "Covid19 Timeline Report start 01/01/2020" )
    @GetMapping(path = "/timeline", produces = "application/json")
    public Covid19Timeline timeline () {
        return timelineService.getTimeline();
    }

    //Get Timeline report  by date  => using query parameter (date)
    @ApiOperation( value  = "Covid19 Select Timeline By date" )
    @GetMapping(path = "/timeline/report", produces = "application/json")
    public Covid19DailyReport timelineByDate ( @ApiParam(required = true,example = "01/01/2020")@RequestParam("date") String date) {
        //System.out.println(date);
        return timelineService.getReportbyDate(date);
    }

    //************************************************
    // start define restful path for CaseReport

    //Get allCaseReport
    @ApiOperation( value  = "Covid19 AllCaseReport")
    @GetMapping(path = "/cases", produces = "application/json")
    public Covid19CaseReport cases () {
        return caseService.getCaseReport();
    }

    //Get CaseReport report  by Number  => using query parameter (no)
    @ApiOperation( value  = "Covid19 Find case by case id")
    @GetMapping(path = "/cases/no/{no}", produces = "application/json")
    public Covid19CaseDetails findCasesById (@ApiParam(required = true,example = "50")@PathVariable("no") int no) {
        return caseService.findCaseById(no);
    }

    //Get CaseReport report  by condition  => using query parameter (age,gender,province,nation)
    @ApiOperation( value  = "Covid19 Find case by filter data")
    @GetMapping(path = "/cases/filter", produces = "application/json")
    public Map findCasesByfilter
    (@ApiParam(required = false,example = "20")@RequestParam(required = false, name = "age") Integer age,@ApiParam(required = false,example = "Male") @RequestParam(required = false, name = "gender") String gender, @ApiParam(required = false,example = "Bangkok")@RequestParam(required = false, name = "province") String province,@ApiParam(required = false,example = "Thai") @RequestParam(required = false, name = "nation") String nation) {
        Map data = new HashMap<>();
        data.put("Data", caseService.findCaseByFilter(age, gender, province, nation));
        data.put("UpdateDate", caseService.getCaseReport().getUpdateDate());
        return data;
    }

    //Get CaseReport report  by Age  between max and min)  => using query parameter (max,min)
    @ApiOperation( value  = "Covid19 Find case by age range" ,response = Covid19CaseDetails.class)
    @GetMapping(path = "/cases/age/range", produces = "application/json")
    public Map findCasesByAge (  @ApiParam(required = true,example = "60")@RequestParam("max") int max, @ApiParam(required = true,example = "20")@RequestParam("min") int min) {
        Map data = new HashMap<>();
        data.put("Data", caseService.findCaseByAge(max, min));
        data.put("UpdateDate", caseService.getCaseReport().getUpdateDate());
        return data;

    }

    //Get CaseReport report  by Gender    => using query parameter (sex)
    @ApiOperation( value  = "Covid19 Find case by gender type")
    @GetMapping(path = "/cases/gender", produces = "application/json")
    public Map findCasesByGender (@ApiParam(required = true,example = "Male")@RequestParam("sex") String sex) {
        Map data = new HashMap<>();
        data.put("Data", caseService.findCaseByGender(sex));
        data.put("UpdateDate", caseService.getCaseReport().getUpdateDate());
        return data;
    }

    //Get CaseReport report  by Province (use format ProvinceEn) => using query parameter (name)
    @ApiOperation( value  = "Covid19 Find case by Province name")
    @GetMapping(path = "/cases/province", produces = "application/json")
    public Map findCaseByProvince (@ApiParam(required = true,example = "Bangkok")@RequestParam("name") String name) {
        Map data = new HashMap<>();
        data.put("Data", caseService.findCaseByProvince(name));
        data.put("UpdateDate", caseService.getCaseReport().getUpdateDate());
        return data;
    }

    //Get CaseReport report  by Nation  (use format NationEn) => using query parameter (name)
    @ApiOperation( value  = "Covid19 Find case by Nation name")
    @GetMapping(path = "/cases/nation", produces = "application/json")
    public Map findCaseByNation (@ApiParam(required = true,example = "Thai")@RequestParam("name") String name) {
        Map data = new HashMap<>();
        data.put("Data", caseService.findCaseByNation(name));
        data.put("UpdateDate", caseService.getCaseReport().getUpdateDate());
        return data;
    }

    //************************************************
    // start define restful path for CaseSummaryReport

    //Get CaseSummaryCaseReport
    @ApiOperation( value  = "Covid19 Summary data")
    @GetMapping(path = "/cases/sums", produces = "application/json")
    public Covid19CaseSummary sumsCase () {
        return caseSummaryService.getCaseSummaryReport();
    }

    //Get CaseSummaryCaseReport only Gender
    @ApiOperation( value  = "Covid19 Summary data only gender"  )
    @GetMapping(path = "/cases/sums/gender", produces = "application/json")
    public Map sumsCaseGender () {
        Map data = new HashMap<>();
        data.put("Gender", caseSummaryService.getCaseSummaryGender());
        data.put("UpdateDate", caseSummaryService.getCaseSummaryReport().getUpdateDate());
        return data;
    }

    //Get CaseSummaryCaseReport only Gender BySpecify sex => using query parameter (sex)
    @ApiOperation( value  = "Covid19 Summary data selected gender"  )
    @GetMapping(path = "/cases/sums/gender/select", produces = "application/json", params = "sex")
    public Map MapsumsCaseGenderBySex (@ApiParam(required = true,example = "Female")@RequestParam("sex") String sex) {
        Map data = new HashMap<>();
        data.put(sex, caseSummaryService.getCaseSummaryGenderBySex(sex));
        data.put("UpdateDate", caseSummaryService.getCaseSummaryReport().getUpdateDate());
        return data;
    }

    //Get CaseSummaryCaseReport  only Gender key data
    @ApiOperation( value  = "Show data keys of Gender"  )
    @GetMapping(path = "/cases/sums/gender/keys", produces = "application/json")
    public Set<String> sumsCaseGenderGetkey () {
        return caseSummaryService.getCaseSummaryGenderGetkey();
    }

    //Get CaseSummaryCaseReport only Nation
    @ApiOperation( value  = "Covid19 Summary data only Nation"  )
    @GetMapping(path = "/cases/sums/nation", produces = "application/json")
    public Map sumsCaseNation () {
        Map data = new HashMap<>();
        data.put("Nation", caseSummaryService.getCaseSummaryNation());
        data.put("UpdateDate", caseSummaryService.getCaseSummaryReport().getUpdateDate());
        return data;
    }

    //Get CaseSummaryCaseReport only Nation BySpecify name (use format NationEn)  => using query parameter (name)
    @ApiOperation( value  = "Covid19 Summary data selected nation by name"  )
    @GetMapping(path = "/cases/sums/nation/select", produces = "application/json", params = "name")
    public Map sumsCaseNationByName (@ApiParam(required = true,example = "Thai")@RequestParam("name") String name) {
        Map data = new HashMap<>();
        data.put(name, caseSummaryService.getCaseSummaryNationByName(name));
        data.put("UpdateDate", caseSummaryService.getCaseSummaryReport().getUpdateDate());
        return data;
    }

    //Get CaseSummaryCaseReport  only Nation key data
    @ApiOperation( value  = "Show data keys of Nation"  )
    @GetMapping(path = "/cases/sums/nation/keys", produces = "application/json")
    public Set<String> sumsCaseNationGetkey () {
        return caseSummaryService.getCaseSummaryNationGetkey();
    }

    //Get CaseSummaryCaseReport only Province
    @ApiOperation( value  = "Covid19 Summary data only Province"  )
    @GetMapping(path = "/cases/sums/province", produces = "application/json")
    public Map sumsCaseProvince () {
        Map data = new HashMap<>();
        data.put("Province", caseSummaryService.getCaseSummaryProvince());
        data.put("UpdateDate", caseSummaryService.getCaseSummaryReport().getUpdateDate());
        return data;
    }

    //Get CaseSummaryCaseReport only Province BySpecify name (use format ProvinceEn)  => using query parameter (name)
    @ApiOperation( value  = "Covid19 Summary data selected province by name"  )
    @GetMapping(path = "/cases/sums/province/select", produces = "application/json", params = "name")
    public Map sumsCaseProvinceByName (@ApiParam(required = true,example = "Bangkok")@RequestParam("name") String name) {
        Map data = new HashMap<>();
        //map return value for know data meaning
        data.put(name, caseSummaryService.getCaseSummaryProvinceByName(name));
        data.put("UpdateDate", caseSummaryService.getCaseSummaryReport().getUpdateDate());
        return data;
    }

    //Get CaseSummaryCaseReport  only Province key data
    @ApiOperation( value  = "Show data keys of Provinc"  )
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