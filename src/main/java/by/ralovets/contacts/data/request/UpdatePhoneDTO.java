package by.ralovets.contacts.data.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdatePhoneDTO {

    @NotBlank(message = "Phone primary must not be empty")
    @Size(max = 64, message = "Phone primary must not exceed 64 characters")
    @Size(min = 2, message = "Phone primary must be at least 2 characters long")
    private String primary;

    @NotBlank(message = "Phone must not be empty")
    @Size(max = 64, message = "Phone must not exceed 64 characters")
    @Size(min = 2, message = "Phone must be at least 2 characters long")
    private String phone;
}
