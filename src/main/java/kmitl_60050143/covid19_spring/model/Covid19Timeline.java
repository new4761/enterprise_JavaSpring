package kmitl_60050143.covid19_spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Covid19Timeline {

    @JsonProperty("UpdateDate")
    private  String  UpdateDate;
    @JsonProperty("Data")
    private List<Covid19DaliyReport> dataByDate;
}
