package kmitl_60050143.covid19_spring.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


// lombok autogen  getter and setter
@Getter
@Setter
//jackson ignore unKnow or undefine data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Covid19DailyReport {

    //Define Json obj mapping By jackson
    @JsonProperty("Confirmed")
    private int Confirmed;
    @JsonProperty("Recovered")
    private int Recovered;
    @JsonProperty("Hospitalized")
    private int Hospitalized;
    @JsonProperty("Deaths")
    private int Deaths;
    @JsonProperty("NewConfirmed")
    private int NewConfirmed;
    @JsonProperty("NewRecovered")
    private int NewRecovered;
    @JsonProperty("NewHospitalized")
    private int NewHospitalized;
    @JsonProperty("NewDeaths")
    private int NewDeaths;
    @JsonProperty("UpdateDate")
    //Define Json Alias name for obj mapping By jackson
    @JsonAlias("Date")
    private String dateDate;

}
