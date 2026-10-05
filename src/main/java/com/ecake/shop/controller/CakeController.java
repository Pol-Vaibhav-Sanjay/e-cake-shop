package com.ecake.shop.controller;

import com.ecake.shop.entity.Cake;
import com.ecake.shop.service.CakeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cakes")
public class CakeController {

    private final CakeService cakeService;

    public CakeController(CakeService cakeService) {
        this.cakeService = cakeService;
    }

    // Add Cake
    @PostMapping
    public Cake addCake(@RequestBody Cake cake) {
        return cakeService.addCake(cake);
    }

    // Get All Cakes
    @GetMapping
    public List<Cake> getAllCakes() {
        return cakeService.getAllCakes();
    }

    // Get Cake By ID
    @GetMapping("/{id}")
    public ResponseEntity<Cake> getCakeById(@PathVariable Long id) {

        return cakeService.getCakeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update Cake
    @PutMapping("/{id}")
    public Cake updateCake(
            @PathVariable Long id,
            @RequestBody Cake cake) {

        return cakeService.updateCake(id, cake);
    }

    // Delete Cake
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCake(@PathVariable Long id) {

        cakeService.deleteCake(id);

        return ResponseEntity.noContent().build();
    }
}
