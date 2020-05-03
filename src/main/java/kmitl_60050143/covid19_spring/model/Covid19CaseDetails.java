package kmitl_60050143.covid19_spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;


// lombok autogen  getter and setter
@Getter
@Setter
public class Covid19CaseDetails {
    //Define Json obj mapping By jackson
    @JsonProperty("ConfirmDate")
    private String confirmDate;
    @JsonProperty("No")
    private int no;
    @JsonProperty("Age")
    private int age;
    @JsonProperty("Gender")
    private String gender;
    @JsonProperty("GenderEn")
    private String genderEn;
    @JsonProperty("Nation")
    private String nation;
    @JsonProperty("NationEn")
    private String nationEn;
    @JsonProperty("Province")
    private String province;
    @JsonProperty("ProvinceId")
    private int provinceId;
    @JsonProperty("District")
    private String district;
    @JsonProperty("ProvinceEn")
    private String provinceEn;
    @JsonProperty("Deatail")
    private String deatail;

}
