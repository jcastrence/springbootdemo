package com.example.demo.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public void postAddress(@RequestBody Address address) {
        addressService.addNewAddress(address);
    }

    @GetMapping
    public List<Address> getStudents() {
        return this.addressService.getAddresses();
    }

    @PutMapping(path = "{id}")
    public void updateAddress(
            @PathVariable("id") Long id,
            @RequestParam(required = true) String newAddress
    ) {
        addressService.updateAddress(id, newAddress);
    }

    @DeleteMapping(path = "{id}")
    public void deleteAddress(@PathVariable("id") Long id) {
        addressService.deleteAddress(id);
    }

}
