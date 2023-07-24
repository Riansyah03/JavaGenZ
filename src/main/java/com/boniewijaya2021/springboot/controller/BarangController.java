package com.boniewijaya2021.springboot.controller;

import com.boniewijaya2021.springboot.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/barang")

public class BarangController {
    @Autowired
    private BarangService barangService;
    @GetMapping("/get-barang")
    public ResponseEntity getDataBarang(@RequestParam UUID idBarang ){
        ResponseEntity responseEntity = barangService.getDataBarang(idBarang);
        return responseEntity;

    }
}
