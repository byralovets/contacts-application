package by.ralovets.contacts.data.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreatePhoneDTO {

    @NotBlank
    private String primary;

    @NotBlank
    private String phone;
}
