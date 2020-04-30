package kmitl_60050143.covid19_spring.service;



import kmitl_60050143.covid19_spring.model.Covid19DaliyReport;
import kmitl_60050143.covid19_spring.model.Covid19Timeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Covid19TimelineService {
    @Value("${covid19.api.timeline}")
    private  String timelineUrl;
    @Autowired
    private RestTemplate restTemplate;
    public Covid19Timeline getTimeline(){
        return this.restTemplate.getForObject(timelineUrl, Covid19Timeline.class);
    }
    public Covid19DaliyReport getReportbyDate(){
        Covid19Timeline obj = this.getTimeline();
        Covid19DaliyReport target =  obj.getDataByDate().stream().filter(data ->"01/01/2020".equals(data.getDateDate())).findFirst().orElse(null);
        return  target;
    }
}
