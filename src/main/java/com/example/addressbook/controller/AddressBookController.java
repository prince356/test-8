package com.example.addressbook.controller;

import com.example.addressbook.dto.AddressBookDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
@Slf4j
public class AddressBookController {

    @PostMapping("")
    public ResponseEntity<String> createAddressBook(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        log.info("Creating new address book entry: {}", addressBookDTO);
        return ResponseEntity.ok("Address Book Created: " + addressBookDTO.toString());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAddressBook(@PathVariable int id, @Valid @RequestBody AddressBookDTO addressBookDTO) {
        log.info("Updating address book entry for ID: {} with data: {}", id, addressBookDTO);
        return ResponseEntity.ok("Address Book Updated for ID: " + id + " with Data: " + addressBookDTO.toString());
    }
}