package uk.gov.ons.ctp.integration.contactcentresvc.representation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import uk.gov.ons.ctp.integration.contactcentresvc.Constants;

@Data
public class UniquePropertyReferenceNumber {

  public UniquePropertyReferenceNumber(String str) {
    if (!StringUtils.isBlank(str)) {
      try {
        Long uprnLong = Long.parseLong(str);
        if (uprnLong.longValue() >= Constants.UPRN_MIN
            && uprnLong.longValue() <= Constants.UPRN_MAX) {
          this.value = uprnLong;
          this.uprn = str;
        } else {
          throw new IllegalArgumentException("String '" + uprnLong + "' is not a valid UPRN");
        }
      } catch (NumberFormatException e) {
        throw new IllegalArgumentException();
      }
    }
  }

  @JsonIgnore private long value;

  // Used as an alt to value so that jackson describes this as a string
  private String uprn;
}
