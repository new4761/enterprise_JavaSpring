package kmitl_60050143.covid19_spring.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Covid19DaliyReport {
    @JsonProperty("Confirmed")
    private  int  Confirmed;
    @JsonProperty("Recovered")
    private  int  Recovered;
    @JsonProperty("Hospitalized")
    private  int  Hospitalized;
    @JsonProperty("Deaths")
    private  int  Deaths;
    @JsonProperty("NewConfirmed")
    private  int  NewConfirmed;
    @JsonProperty("NewRecovered")
    private  int  NewRecovered;
    @JsonProperty("NewHospitalized")
    private  int  NewHospitalized;
    @JsonProperty("NewDeaths")
    private  int  NewDeaths;
    @JsonProperty("UpdateDate")
    @JsonAlias("Date")
    private  String  dateDate;

}
