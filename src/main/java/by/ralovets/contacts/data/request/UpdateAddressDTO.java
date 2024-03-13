package by.ralovets.contacts.data.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateAddressDTO {

    @NotBlank(message = "City must not be empty")
    @Size(max = 64, message = "City must not exceed 64 characters")
    @Size(min = 2, message = "City must be at least 2 characters long")
    private String city;

    @NotBlank(message = "Street must not be empty")
    @Size(max = 64, message = "Street must not exceed 64 characters")
    @Size(min = 2, message = "Street must be at least 2 characters long")
    private String street;

    @NotBlank(message = "Post code must not be empty")
    @Size(max = 64, message = "Post code must not exceed 64 characters")
    @Size(min = 2, message = "Post code must be at least 2 characters long")
    private String postCode;
}
