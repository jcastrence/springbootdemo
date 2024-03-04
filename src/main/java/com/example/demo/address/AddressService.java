package com.example.demo.address;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void addNewAddress(Address address) {
        Optional<Address> addressOptional = addressRepository.findAddressByOwner(address.getOwner());
        if (addressOptional.isPresent()) {
            throw new IllegalStateException("One address per owner");
        }
        addressRepository.save(address);
    }

    @Autowired
    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    @Transactional
    public void updateAddress(Long id, String newAddress) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Id does not exist"
                ));

        address.setAddress(newAddress);
    }

    public void deleteAddress(Long id) {
        boolean exists = addressRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Id does not exist");
        }
        addressRepository.deleteById(id);
    }
}
