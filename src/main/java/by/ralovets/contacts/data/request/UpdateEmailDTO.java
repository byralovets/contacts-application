package by.ralovets.contacts.data.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateEmailDTO {

    @NotBlank(message = "Email must not be empty")
    @Size(max = 64, message = "Email must not exceed 64 characters")
    @Size(min = 2, message = "Email must be at least 2 characters long")
    @Email(message = "Email has invalid format")
    private String email;
}
