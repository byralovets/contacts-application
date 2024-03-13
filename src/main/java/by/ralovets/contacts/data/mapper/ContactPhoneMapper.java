package by.ralovets.contacts.data.mapper;

import by.ralovets.contacts.data.request.CreatePhoneDTO;
import by.ralovets.contacts.data.request.UpdatePhoneDTO;
import by.ralovets.contacts.data.response.ContactPhoneDTO;
import by.ralovets.contacts.entity.ContactPhone;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface ContactPhoneMapper {

    ContactPhoneDTO toDTO(ContactPhone contactPhone);

    ContactPhone toEntity(CreatePhoneDTO request);

    ContactPhone toExistingEntity(UpdatePhoneDTO request, @MappingTarget ContactPhone phone);
}
