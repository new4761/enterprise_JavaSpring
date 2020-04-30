package kmitl_60050143.covid19_spring.service;

import kmitl_60050143.covid19_spring.model.Covid19DaliyReport;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Covid19DaliyService {

    @Value("${covid19.api.daliy}")
    private  String daliyUrl;
    @Autowired
    private  RestTemplate restTemplate;

    public Covid19DaliyReport getReport(){
        return this.restTemplate.getForObject(daliyUrl, Covid19DaliyReport.class);
    }
}
