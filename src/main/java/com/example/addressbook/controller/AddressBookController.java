package com.example.addressbook.controller;

import com.example.addressbook.dto.AddressBookDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping("")
    public ResponseEntity<String> getAddressBook() {
        return ResponseEntity.ok("Address Book Data");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getAddressBookById(@PathVariable int id) {
        return ResponseEntity.ok("Address Book Data for ID: " + id);
    }

    @PostMapping("")
    public ResponseEntity<String> createAddressBook(@RequestBody AddressBookDTO addressBookDTO) {
        return ResponseEntity.ok("Address Book Created: " + addressBookDTO.toString());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAddressBook(@PathVariable int id, @RequestBody AddressBookDTO addressBookDTO) {
        return ResponseEntity.ok("Address Book Updated for ID: " + id + " with Data: " + addressBookDTO.toString());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddressBook(@PathVariable int id) {
        return ResponseEntity.ok("Address Book Deleted for ID: " + id);
    }
}