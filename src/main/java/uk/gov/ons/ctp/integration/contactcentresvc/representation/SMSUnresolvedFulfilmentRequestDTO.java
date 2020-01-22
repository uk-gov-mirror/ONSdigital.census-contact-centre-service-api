package uk.gov.ons.ctp.integration.contactcentresvc.representation;

import com.godaddy.logging.LoggingScope;
import com.godaddy.logging.Scope;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.ons.ctp.integration.contactcentresvc.Constants;

/**
 * The request object when contact centre requests an SMS fulfilment for an unresolved case
 *
 * @author philwhiles
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SMSUnresolvedFulfilmentRequestDTO {

  @NotBlank
  @Pattern(regexp = Constants.UKMOBILEPHONENUMBER_RE)
  @LoggingScope(scope = Scope.SKIP)
  private String telNo;

  @NotBlank
  @Size(max = 60)
  private String addressLine1;

  @Size(max = 60)
  @LoggingScope(scope = Scope.SKIP)
  private String addressLine2;

  @Size(max = 60)
  @LoggingScope(scope = Scope.SKIP)
  private String addressLine3;

  @NotBlank
  @Size(max = 60)
  @LoggingScope(scope = Scope.SKIP)
  private String townName;

  @Pattern(regexp = Constants.REGION_RE)
  private String region;

  @NotNull
  @Pattern(regexp = Constants.POSTCODE_RE)
  private String postcode;

  @NotBlank
  @Size(max = 12)
  private String fulfilmentCode;

  @NotNull private Date dateTime;
}
