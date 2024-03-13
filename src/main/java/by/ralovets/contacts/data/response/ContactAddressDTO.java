package by.ralovets.contacts.data.response;

import lombok.Data;

@Data
public class ContactAddressDTO {

    private Long id;
    private String city;
    private String street;
    private String postCode;
}
