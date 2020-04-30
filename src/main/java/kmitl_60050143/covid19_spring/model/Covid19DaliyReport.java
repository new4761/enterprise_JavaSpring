package kmitl_60050143.covid19_spring.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Covid19DaliyReport {
    private  int  confirmed;
    private  int  recovered;
    private  int  hospitalized;
    private  int  deaths;
    private  int  newConfirmed;
    private  int  newRecovered;
    private  int  newHospitalized;
    private  int  newDeaths;
    private  String  updateDate;

}
