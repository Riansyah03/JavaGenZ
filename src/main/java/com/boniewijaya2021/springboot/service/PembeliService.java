package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.Pembeli;
import com.boniewijaya2021.springboot.repository.DataPembeliRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PembeliService {
    @Autowired
    private DataPembeliRepository dataPembeliRepository;

//    public ResponseEntity<MessageModel> addDataPembeli(Pembeli pembeli)
    public ResponseEntity<MessageModel> addDataPembeli(List<Pembeli> pembelis)
    {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try{
           List<Pembeli> paramPost = pembelis;
           List<Pembeli> postData = new ArrayList<>();
           String responData = "Tersimpan";

           for(Pembeli map: pembelis){
               Pembeli objectSimpan = new Pembeli();
               objectSimpan.setNamaPembeli(map.getNamaPembeli());
               objectSimpan.setAlamat(map.getAlamat());
               objectSimpan.setJk(map.getJk());
               objectSimpan.setNoTelp(map.getNoTelp());
               postData.add(objectSimpan);

           }
           dataPembeliRepository.saveAll(postData);

//            dataPembeliRepository.save(pembelis);
            msg.setStatus(true);
            msg.setMessage("Success");
            result.put("data", responData);
            msg.setData(result);
            return ResponseEntity.status(HttpStatus.OK).body(msg);

        }catch (Exception e){
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }

    public ResponseEntity<MessageModel> deleteDataPembeli(UUID idPembeli) {
        MessageModel msg = new MessageModel();
        try {
            Optional<Pembeli> pembeliOptional = dataPembeliRepository.findById(idPembeli);
            if (pembeliOptional.isPresent()) {
                dataPembeliRepository.deleteById(idPembeli);
                msg.setStatus(true);
                msg.setMessage("Data pembeli berhasil dihapus");
                return ResponseEntity.status(HttpStatus.OK).body(msg);
            } else {
                msg.setStatus(false);
                msg.setMessage("Data pembeli dengan ID " + idPembeli + " tidak ditemukan");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(msg);
        }
    }
}
