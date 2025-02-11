package com.digiplan.servicesImpl;

import com.digiplan.entities.Address;
import com.digiplan.repositories.AddressRepository;
import com.digiplan.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(Long addressId) {
        return addressRepository.findById(addressId).orElse(null);
    }

    @Override
    public List<Address> getAddressesByUserId(String userId) {
        return addressRepository.findByUserId(userId);
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Long addressId, Address updatedAddress) {
        Optional<Address> existingAddressOptional = addressRepository.findById(addressId);

        if (existingAddressOptional.isPresent()) {
            Address existingAddress = existingAddressOptional.get();
            // Update the fields you want to update
            existingAddress.setClinicName(updatedAddress.getClinicName());
            existingAddress.setAddress(updatedAddress.getAddress());
            return addressRepository.save(existingAddress);
        } else {
            // Handle address not found
            return null;
        }
    }

    @Override
    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
    }

}
