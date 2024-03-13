package by.ralovets.contacts.data.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateAddressDTO {

    @NotBlank
    @Size(min = 3, max = 64, message = "City size must be between 3 and 64 characters")
    private String city;

    @NotBlank
    private String street;

    @NotBlank
    private String postCode;
}
