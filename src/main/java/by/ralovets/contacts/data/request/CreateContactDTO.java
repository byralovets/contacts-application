package by.ralovets.contacts.data.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class CreateContactDTO {

    @NotBlank(message = "First name must not be empty")
    @Size(max = 64, message = "First name must not exceed 64 characters")
    @Size(min = 2, message = "First name must be at least 2 characters long")
    private String firstName;

    @NotBlank(message = "Last name must not be empty")
    @Size(max = 64, message = "Last name must not exceed 64 characters")
    @Size(min = 2, message = "Last name must be at least 2 characters long")
    private String lastName;

    @NotNull(message = "Birthday must not be empty")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @NotEmpty(message = "Emails must not be empty")
    private Set<CreateEmailDTO> emails;

    @NotEmpty(message = "Phones must not be empty")
    private Set<CreatePhoneDTO> phones;

    @NotEmpty(message = "Addresses must not be empty")
    private Set<CreateAddressDTO> addresses;
}
