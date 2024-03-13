package by.ralovets.contacts.data.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateContactDTO {

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
}
