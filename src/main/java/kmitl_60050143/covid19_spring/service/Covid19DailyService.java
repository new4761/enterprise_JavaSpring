package kmitl_60050143.covid19_spring.service;

import kmitl_60050143.covid19_spring.model.Covid19DailyReport;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//define Service bean
@Service
public class Covid19DailyService {

    // use key value from application.properties for define url
    @Value("${covid19.api.daliy}")
    private String dailyUrl;
    // use RestTemplate bean
    @Autowired
    private RestTemplate restTemplate;

    //get api to obj mapping by use RestTemplate
    public Covid19DailyReport getReport () {
        return this.restTemplate.getForObject(dailyUrl, Covid19DailyReport.class);
    }
}
