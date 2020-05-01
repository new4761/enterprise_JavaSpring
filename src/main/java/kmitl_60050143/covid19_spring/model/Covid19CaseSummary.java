package kmitl_60050143.covid19_spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


import java.util.Map;

// lombok autogen  getter and setter
@Getter
@Setter
//jackson ignore unKnow or undefine data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Covid19CaseSummary {
    //Define Json obj mapping By jackson
    //Use java hash map for  mapping obj
    @JsonProperty("Province")
    private Map<String, Integer> province;
    @JsonProperty("Gender")
    private Map<String, Integer> gender;
    @JsonProperty("Nation")
    private Map<String, Integer> nation;
    @JsonProperty("LastData")
    private String lastData;
    @JsonProperty("UpdateDate")
    private String updateDate;
}
