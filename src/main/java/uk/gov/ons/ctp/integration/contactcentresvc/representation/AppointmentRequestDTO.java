package uk.gov.ons.ctp.integration.contactcentresvc.representation;

import java.util.Date;
import java.util.UUID;
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
 * The request object when contact centre requests an appointment to be made
 *
 * @author philwhiles
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentRequestDTO {

  public enum AppointmentType {
    FIELD,
    TELEPHONE
  }

  @NotNull private UUID caseId;

  @NotNull private AppointmentType appointmentType;

  @NotBlank
  @Pattern(regexp = Constants.PHONENUMBER_RE)
  private String telNo;

  @NotBlank
  @Size(max = 12)
  private String title;

  @NotBlank
  @Size(max = 60)
  private String forename;

  @NotBlank
  @Size(max = 60)
  private String surname;

  @NotNull private Date dateTime;
}
