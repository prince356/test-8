package com.example.addressbook.controller;

import com.example.addressbook.dto.AddressBookDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
@Slf4j
public class AddressBookController {

    @GetMapping("")
    public ResponseEntity<String> getAddressBook() {
        log.debug("Fetching all address book data");
        return ResponseEntity.ok("Address Book Data");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getAddressBookById(@PathVariable int id) {
        log.debug("Fetching address book data for ID: {}", id);
        return ResponseEntity.ok("Address Book Data for ID: " + id);
    }

    @PostMapping("")
    public ResponseEntity<String> createAddressBook(@RequestBody AddressBookDTO addressBookDTO) {
        log.info("Creating new address book entry: {}", addressBookDTO);
        return ResponseEntity.ok("Address Book Created: " + addressBookDTO.toString());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAddressBook(@PathVariable int id, @RequestBody AddressBookDTO addressBookDTO) {
        log.info("Updating address book entry for ID: {} with data: {}", id, addressBookDTO);
        return ResponseEntity.ok("Address Book Updated for ID: " + id + " with Data: " + addressBookDTO.toString());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddressBook(@PathVariable int id) {
        log.warn("Deleting address book entry for ID: {}", id);
        return ResponseEntity.ok("Address Book Deleted for ID: " + id);
    }
}