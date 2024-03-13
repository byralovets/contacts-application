package by.ralovets.contacts.controller;

import by.ralovets.contacts.data.request.CreateAddressDTO;
import by.ralovets.contacts.data.request.UpdateAddressDTO;
import by.ralovets.contacts.data.response.ContactAddressDTO;
import by.ralovets.contacts.facade.AddressFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/contacts/{contactId}/addresses")
@RequiredArgsConstructor
public class ContactAddressController {

    private final AddressFacade addressFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContactAddressDTO create(@RequestBody CreateAddressDTO data, @PathVariable Long contactId) {
        return addressFacade.createAddress(contactId, data);
    }

    @PutMapping("/{addressId}")
    public ContactAddressDTO update(@PathVariable Long contactId,
                                    @PathVariable Long addressId,
                                    @RequestBody UpdateAddressDTO data) {
        return addressFacade.updateAddressById(addressId, contactId, data);
    }

    @DeleteMapping("/{addressId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long contactId, @PathVariable Long addressId) {
        addressFacade.deleteAddressById(addressId, contactId);
    }
}
