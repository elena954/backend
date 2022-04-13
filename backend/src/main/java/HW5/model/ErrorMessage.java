package HW5.model;

import lombok.*;

@Getter
@Setter
@Data
public class ErrorMessage {
    private Long status;
    private String message;
    private String timestamp;
}
