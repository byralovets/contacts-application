package by.ralovets.contacts.data.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateEmailDTO {

    @NotBlank(message = "Email must not be blank")
    @Size(min = 3, max = 64, message = "Email size must be between 3 and 64 characters")
    @Email(message = "Email has invalid format")
    private String email;
}
