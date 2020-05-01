package kmitl_60050143.covid19_spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// lombok autogen  getter and setter
@Getter
@Setter
public class Covid19Timeline {
    //Define Json obj mapping By jackson
    @JsonProperty("UpdateDate")
    private String UpdateDate;
    // create list of obj  Covid19DaliyReport
    @JsonProperty("Data")
    private List<Covid19DailyReport> dataByDate;

}
