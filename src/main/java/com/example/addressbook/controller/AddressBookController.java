package com.example.addressbook.controller;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.service.AddressBookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
@Slf4j
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    @GetMapping("")
    public ResponseEntity<List<AddressBookDTO>> getAllAddressBooks() {
        log.info("Fetching all address book data");
        return ResponseEntity.ok(addressBookService.getAllAddressBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBookDTO> getAddressBookById(@PathVariable Long id) {
        log.info("Fetching address book data for ID: {}", id);
        return ResponseEntity.ok(addressBookService.getAddressBookById(id));
    }

    @PostMapping("")
    public ResponseEntity<AddressBookDTO> createAddressBook(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        log.info("Creating new address book entry: {}", addressBookDTO);
        return ResponseEntity.ok(addressBookService.createAddressBook(addressBookDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBookDTO> updateAddressBook(@PathVariable Long id, @Valid @RequestBody AddressBookDTO addressBookDTO) {
        log.info("Updating address book entry for ID: {} with data: {}", id, addressBookDTO);
        return ResponseEntity.ok(addressBookService.updateAddressBook(id, addressBookDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddressBook(@PathVariable Long id) {
        log.info("Deleting address book entry for ID: {}", id);
        addressBookService.deleteAddressBook(id);
        return ResponseEntity.ok("Address book deleted successfully");
    }
}