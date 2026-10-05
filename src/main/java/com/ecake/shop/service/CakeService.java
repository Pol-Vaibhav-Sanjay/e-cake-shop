package com.ecake.shop.service;

import com.ecake.shop.entity.Cake;
import com.ecake.shop.repository.CakeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CakeService {

    private final CakeRepository cakeRepository;

    public CakeService(CakeRepository cakeRepository) {
        this.cakeRepository = cakeRepository;
    }

    public Cake addCake(Cake cake) {
        return cakeRepository.save(cake);
    }

    public List<Cake> getAllCakes() {
        return cakeRepository.findAll();
    }

    public Optional<Cake> getCakeById(Long id) {
        return cakeRepository.findById(id);
    }

    public Cake updateCake(Long id, Cake cakeDetails) {

        Cake cake = cakeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cake not found"));

        cake.setName(cakeDetails.getName());
        cake.setFlavor(cakeDetails.getFlavor());
        cake.setSize(cakeDetails.getSize());
        cake.setPrice(cakeDetails.getPrice());
        cake.setDescription(cakeDetails.getDescription());

        return cakeRepository.save(cake);
    }

    public void deleteCake(Long id) {
        cakeRepository.deleteById(id);
    }
}
