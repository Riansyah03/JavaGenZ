package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.Barang;
import com.boniewijaya2021.springboot.entity.TblSales;
import com.boniewijaya2021.springboot.repository.DataBarangRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@Service
public class BarangService {
    @Autowired
    private DataBarangRepository dataBarangRepository;

    public ResponseEntity getDataBarang(UUID idBarang) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {
            Barang data = dataBarangRepository.getBarangByid(idBarang);
            if (data.getIdBarang() == null) {
                msg.setStatus(true);
                msg.setMessage("data tidak ditemukan");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            } else {
                msg.setStatus(true);
                msg.setMessage("Success");
                result.put("data", data);
                msg.setData(result);
                return ResponseEntity.ok().body(msg);
            }

        } catch (Exception e) {
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.ok().body(msg);

        }
    }
}
