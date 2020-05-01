package kmitl_60050143.covid19_spring.service;

import kmitl_60050143.covid19_spring.model.Covid19CaseDetails;
import kmitl_60050143.covid19_spring.model.Covid19CaseReport;
import kmitl_60050143.covid19_spring.model.Covid19Timeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

//define Service bean
@Service
public class Covid19CaseService {

    // use key value from application.properties for define url
    @Value("${covid19.api.cases}")
    private String caseUrl;

    // use RestTemplate bean
    @Autowired
    private RestTemplate restTemplate;

    //get api to obj mapping by use RestTemplate
    public Covid19CaseReport getCaseReport () {
        return this.restTemplate.getForObject(caseUrl, Covid19CaseReport.class);
    }

    //find obj by number use java stream api
    public Covid19CaseDetails findCaseById (int no) {
        Covid19CaseReport obj = this.getCaseReport();
        Covid19CaseDetails target = obj.getCaseByPerson().stream().filter
                (data -> no == data.getNo()).findFirst().orElse(null);
        return target;
    }

    //find obj list by  use java Stream api and RestTemplate for handle condition filter
    public List<Covid19CaseDetails> findCaseByFilter (Integer age, String gender, String province, String nation) {
        Covid19CaseReport obj = this.getCaseReport();
        List<Covid19CaseDetails> target = obj.getCaseByPerson().stream()
                .filter(age == null ? data -> true : data -> (age == data.getAge()))
                .filter(gender == null ? data -> true : data -> gender.equals(data.getGenderEn()))
                .filter(province == null ? data -> true : data -> province.equals(data.getProvinceEn()))
                .filter(nation == null ? data -> true : data -> nation.equals(data.getNationEn()))
                .collect(Collectors.toList());
        return target;
    }

    //find obj list by Age  use java Stream api from condition max and min
    public List<Covid19CaseDetails> findCaseByAge (int max, int min) {
        Covid19CaseReport obj = this.getCaseReport();
        List<Covid19CaseDetails> target = obj.getCaseByPerson().stream().filter
                (data -> (max >= data.getAge() && data.getAge() >= min)).collect(Collectors.toList());
        return target;
    }

    //find obj list by Gender  use java Stream api from condition gender name
    public List<Covid19CaseDetails> findCaseByGender (String gender) {
        Covid19CaseReport obj = this.getCaseReport();
        List<Covid19CaseDetails> target = obj.getCaseByPerson().stream().filter
                (data -> gender.equals(data.getGenderEn())).collect(Collectors.toList());
        return target;
    }

    //find obj list by Province  use java Stream api from condition province name
    public List<Covid19CaseDetails> findCaseByProvince (String province) {
        Covid19CaseReport obj = this.getCaseReport();
        List<Covid19CaseDetails> target = obj.getCaseByPerson().stream().filter
                (data -> province.equals(data.getProvinceEn())).collect(Collectors.toList());
        return target;
    }

    //find obj list by Nation  use java Stream api from condition nation name
    public List<Covid19CaseDetails> findCaseByNation (String nation) {
        Covid19CaseReport obj = this.getCaseReport();
        List<Covid19CaseDetails> target = obj.getCaseByPerson().stream().filter
                (data -> nation.equals(data.getNationEn())).collect(Collectors.toList());
        return target;
    }
}
