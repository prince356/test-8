package com.example.addressbook.service;

import com.example.addressbook.exception.AddressBookNotFoundException;
import com.example.addressbook.model.AddressBook;
import com.example.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    public List<AddressBook> getAllAddressBooks() {
        return addressBookRepository.findAll();
    }

    public AddressBook getAddressBookById(Long id) {
        return addressBookRepository.findById(id)
                .orElseThrow(() -> new AddressBookNotFoundException("Address book not found with ID: " + id));
    }

    public AddressBook createAddressBook(AddressBook addressBook) {
        return addressBookRepository.save(addressBook);
    }

    public AddressBook updateAddressBook(Long id, AddressBook addressBookDetails) {
        AddressBook addressBook = addressBookRepository.findById(id)
                .orElseThrow(() -> new AddressBookNotFoundException("Address book not found with ID: " + id));

        addressBook.setName(addressBookDetails.getName());
        addressBook.setAddress(addressBookDetails.getAddress());
        addressBook.setCity(addressBookDetails.getCity());
        addressBook.setState(addressBookDetails.getState());
        addressBook.setZip(addressBookDetails.getZip());
        addressBook.setPhone(addressBookDetails.getPhone());

        return addressBookRepository.save(addressBook);
    }

    public void deleteAddressBook(Long id) {
        AddressBook addressBook = addressBookRepository.findById(id)
                .orElseThrow(() -> new AddressBookNotFoundException("Address book not found with ID: " + id));

        addressBookRepository.delete(addressBook);
    }
}