package by.ralovets.contacts.data.mapper;

import by.ralovets.contacts.data.request.CreateEmailDTO;
import by.ralovets.contacts.data.request.UpdateEmailDTO;
import by.ralovets.contacts.data.response.ContactEmailDTO;
import by.ralovets.contacts.entity.ContactEmail;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface ContactEmailMapper {

    ContactEmailDTO toDTO(ContactEmail contactEmail);

    ContactEmail toEntity(CreateEmailDTO request);

    ContactEmail toExistingEntity(UpdateEmailDTO request, @MappingTarget ContactEmail email);
}
