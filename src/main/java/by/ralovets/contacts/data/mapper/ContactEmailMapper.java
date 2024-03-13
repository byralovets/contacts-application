package by.ralovets.contacts.data.mapper;

import by.ralovets.contacts.data.response.ContactEmailDTO;
import by.ralovets.contacts.data.request.CreateEmailDTO;
import by.ralovets.contacts.entity.ContactEmail;
import org.mapstruct.Mapper;

@Mapper
public interface ContactEmailMapper {

    ContactEmailDTO toDTO(ContactEmail contactEmail);

    ContactEmail toEntity(CreateEmailDTO request);
}
