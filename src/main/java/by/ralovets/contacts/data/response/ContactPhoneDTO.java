package by.ralovets.contacts.data.response;

import lombok.Data;

@Data
public class ContactPhoneDTO {

    private Long id;
    private String primary;
    private String phone;
}
