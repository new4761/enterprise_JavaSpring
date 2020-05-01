package kmitl_60050143.covid19_spring.service;


import kmitl_60050143.covid19_spring.model.Covid19DailyReport;
import kmitl_60050143.covid19_spring.model.Covid19Timeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//define Service bean
@Service
public class Covid19TimelineService {
    // use key value from application.properties for define url
    @Value("${covid19.api.timeline}")
    private String timelineUrl;
    // use RestTemplate bean
    @Autowired
    private RestTemplate restTemplate;

    //get api to obj mapping by use RestTemplate
    public Covid19Timeline getTimeline () {
        return this.restTemplate.getForObject(timelineUrl, Covid19Timeline.class);
    }

    //find obj by date  use java Stream api and RestTemplate
    public Covid19DailyReport getReportbyDate (String getDate) {
        Covid19Timeline obj = this.getTimeline();
        Covid19DailyReport target = obj.getDataByDate().stream().filter
                (data -> getDate.equals(data.getDateDate())).findFirst().orElse(null);
        return target;
    }

}

