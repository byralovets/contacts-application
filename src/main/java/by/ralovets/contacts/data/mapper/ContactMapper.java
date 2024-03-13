package by.ralovets.contacts.data.mapper;

import by.ralovets.contacts.data.request.CreateContactDTO;
import by.ralovets.contacts.data.request.UpdateContactDTO;
import by.ralovets.contacts.data.response.ContactDTO;
import by.ralovets.contacts.entity.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(uses = {ContactPhoneMapper.class, ContactEmailMapper.class, ContactAddressMapper.class})
public interface ContactMapper {

    ContactDTO toDTO(Contact contact);

    Contact toEntity(CreateContactDTO request);

    Contact toExistingEntity(UpdateContactDTO request, @MappingTarget Contact contact);
}
