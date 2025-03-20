package com.example.addressbook.service;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.exception.AddressBookNotFoundException;
import com.example.addressbook.model.AddressBook;
import com.example.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    public List<AddressBookDTO> getAllAddressBooks() {
        return addressBookRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AddressBookDTO getAddressBookById(Long id) {
        AddressBook addressBook = addressBookRepository.findById(id)
                .orElseThrow(() -> new AddressBookNotFoundException("Address book not found with ID: " + id));
        return convertToDTO(addressBook);
    }

    public AddressBookDTO createAddressBook(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = convertToEntity(addressBookDTO);
        AddressBook savedAddressBook = addressBookRepository.save(addressBook);
        return convertToDTO(savedAddressBook);
    }

    public AddressBookDTO updateAddressBook(Long id, AddressBookDTO addressBookDTO) {
        AddressBook addressBook = addressBookRepository.findById(id)
                .orElseThrow(() -> new AddressBookNotFoundException("Address book not found with ID: " + id));

        addressBook.setName(addressBookDTO.getName());
        addressBook.setAddress(addressBookDTO.getAddress());
        addressBook.setCity(addressBookDTO.getCity());
        addressBook.setState(addressBookDTO.getState());
        addressBook.setZip(addressBookDTO.getZip());
        addressBook.setPhone(addressBookDTO.getPhone());

        AddressBook updatedAddressBook = addressBookRepository.save(addressBook);
        return convertToDTO(updatedAddressBook);
    }

    public void deleteAddressBook(Long id) {
        AddressBook addressBook = addressBookRepository.findById(id)
                .orElseThrow(() -> new AddressBookNotFoundException("Address book not found with ID: " + id));

        addressBookRepository.delete(addressBook);
    }

    private AddressBookDTO convertToDTO(AddressBook addressBook) {
        AddressBookDTO addressBookDTO = new AddressBookDTO();
        addressBookDTO.setName(addressBook.getName());
        addressBookDTO.setAddress(addressBook.getAddress());
        addressBookDTO.setCity(addressBook.getCity());
        addressBookDTO.setState(addressBook.getState());
        addressBookDTO.setZip(addressBook.getZip());
        addressBookDTO.setPhone(addressBook.getPhone());
        return addressBookDTO;
    }

    private AddressBook convertToEntity(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook();
        addressBook.setName(addressBookDTO.getName());
        addressBook.setAddress(addressBookDTO.getAddress());
        addressBook.setCity(addressBookDTO.getCity());
        addressBook.setState(addressBookDTO.getState());
        addressBook.setZip(addressBookDTO.getZip());
        addressBook.setPhone(addressBookDTO.getPhone());
        return addressBook;
    }
}