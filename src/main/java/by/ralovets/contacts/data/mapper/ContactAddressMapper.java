package by.ralovets.contacts.data.mapper;

import by.ralovets.contacts.data.request.CreateAddressDTO;
import by.ralovets.contacts.data.request.UpdateAddressDTO;
import by.ralovets.contacts.data.response.ContactAddressDTO;
import by.ralovets.contacts.entity.ContactAddress;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface ContactAddressMapper {

    ContactAddressDTO toDTO(ContactAddress contactAddress);

    ContactAddress toEntity(CreateAddressDTO request);

    ContactAddress toExistingEntity(UpdateAddressDTO request, @MappingTarget ContactAddress address);
}
