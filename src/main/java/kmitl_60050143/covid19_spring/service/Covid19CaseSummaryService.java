package kmitl_60050143.covid19_spring.service;

import kmitl_60050143.covid19_spring.model.Covid19CaseReport;
import kmitl_60050143.covid19_spring.model.Covid19CaseSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Set;

//define Service bean
@Service
public class Covid19CaseSummaryService {

    // use key value from application.properties for define url
    @Value("${covid19.api.cases.sums}")
    private String sumsUrl;
    // use RestTemplate bean
    @Autowired
    private RestTemplate restTemplate;

    //get api to obj mapping by use RestTemplate
    public Covid19CaseSummary getCaseSummaryReport () {
        return this.restTemplate.getForObject(sumsUrl, Covid19CaseSummary.class);
    }

    //get obj only Gender by use java hash map
    public Map<String, Integer> getCaseSummaryGender () {
        Covid19CaseSummary obj = this.getCaseSummaryReport();
        return obj.getGender();
    }

    //get obj only Gender key by use java hash map
    public Set<String> getCaseSummaryGenderGetkey () {
        Covid19CaseSummary obj = this.getCaseSummaryReport();
        return obj.getGender().keySet();
    }

    //find value of Gender sex  by use java hash map
    public int getCaseSummaryGenderBySex (String sex) {
        Covid19CaseSummary obj = this.getCaseSummaryReport();
        return obj.getGender().get(sex);
    }

    //get obj only Nation by use java hash map
    public Map<String, Integer> getCaseSummaryNation () {
        Covid19CaseSummary obj = this.getCaseSummaryReport();
        return obj.getNation();
    }

    //find value  of Nation name  by use java hash map
    public int getCaseSummaryNationByName (String name) {
        Covid19CaseSummary obj = this.getCaseSummaryReport();
        return obj.getNation().get(name);
    }

    //get obj only Nation key by use java hash map
    public Set<String> getCaseSummaryNationGetkey () {
        Covid19CaseSummary obj = this.getCaseSummaryReport();
        return obj.getNation().keySet();
    }

    //get obj only Province by use java hash map
    public Map<String, Integer> getCaseSummaryProvince () {
        Covid19CaseSummary obj = this.getCaseSummaryReport();
        return obj.getProvince();
    }

    //find value of Province name  by use java hash map
    public int getCaseSummaryProvinceByName (String name) {
        Covid19CaseSummary obj = this.getCaseSummaryReport();
        return obj.getProvince().get(name);
    }

    //get obj only Province key by use java hash map
    public Set<String> getCaseSummaryProvinceGetkey () {
        Covid19CaseSummary obj = this.getCaseSummaryReport();
        return obj.getProvince().keySet();
    }
}
