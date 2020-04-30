package kmitl_60050143.covid19_spring.controller;



import kmitl_60050143.covid19_spring.model.Covid19DaliyReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("api/covid19")
public class Covid19Controller {
	@Value("${covid19.api.daliy}")
	private  String daliyUrl;
	@Value("${covid19.api.timeline}")
	private  String timelineUrl;
	@Value("${covid19.api.cases}")
	private  String casesUrl;
	@Value("${covid19.api.cases.sums}")
	private  String sumsUrl;
	@Value("${covid19.api.area}")
	private  String areaUrl;
	@Autowired
	RestTemplate restTemplate;
	@GetMapping(path="/daliy", produces = "application/json")
	public String daliyCase() {
		return restTemplate.getForObject(daliyUrl, String.class);
	}
	@GetMapping(path="/timeline", produces = "application/json")
	public String timeline() {
		return restTemplate.getForObject(timelineUrl, String.class);
	}
	@GetMapping(path="/cases", produces = "application/json")
	public String cases() {
		return restTemplate.getForObject(casesUrl, String.class);
	}
	@GetMapping(path="/cases/sums", produces = "application/json")
	public String sumsCase() {
		return restTemplate.getForObject(sumsUrl, String.class);
	}
	@GetMapping(path="/area", produces = "application/json")
	public String area() {
		return restTemplate.getForObject(areaUrl, String.class);
	}
}