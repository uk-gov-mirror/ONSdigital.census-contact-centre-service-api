package uk.gov.ons.ctp.integration.contactcentresvc.representation;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.ons.ctp.integration.contactcentresvc.Constants;

/**
 * The request object when contact centre requests an SMS fulfilment for a given case
 *
 * @author philwhiles
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SMSFulfilmentRequestDTO implements Serializable {

  @NotNull private UUID caseId;

  @NotNull
  @Size(max = 20)
  @Pattern(regexp = Constants.PHONENUMBER_RE)
  private String telNo;

  @NotNull
  @Size(max = 12)
  private String productCode;

  @NotNull private Date dateTime;
}
