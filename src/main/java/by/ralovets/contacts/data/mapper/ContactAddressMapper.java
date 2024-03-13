package by.ralovets.contacts.data.mapper;

import by.ralovets.contacts.data.response.ContactAddressDTO;
import by.ralovets.contacts.data.request.CreateAddressDTO;
import by.ralovets.contacts.entity.ContactAddress;
import org.mapstruct.Mapper;

@Mapper
public interface ContactAddressMapper {

    ContactAddressDTO toDTO(ContactAddress contactAddress);

    ContactAddress toEntity(CreateAddressDTO request);
}
