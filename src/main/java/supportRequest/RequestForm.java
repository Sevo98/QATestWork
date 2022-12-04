package supportRequest;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
public class RequestForm {
    private String fullName;
    private String mail;
    private String phone;
    private String comment;
    private String department;
    private String position;
    private String agreement;
}
