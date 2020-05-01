package kmitl_60050143.covid19_spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// lombok autogen  getter and setter
@Getter
@Setter
//jackson ignore unKnow or undefine data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Covid19CaseReport {

    //Define Json obj mapping By jackson
    // create list of obj  Covid19CaseDetails
    @JsonProperty("Data")
    private List<Covid19CaseDetails> caseByPerson;
    @JsonProperty("LastData")
    private String lastData;
    @JsonProperty("UpdateDate")
    private String updateDate;
}
