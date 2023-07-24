package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.Pembeli;
import com.boniewijaya2021.springboot.entity.TblSales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface DataPembeliRepository extends JpaRepository<Pembeli, UUID> {
//    @Query(value = "INSERT INTO sample.tbl_pembeli (id_pembeli, nama_pembeli, jk, no_telp, alamat) " +
//            "VALUES " +
//            "(cast(:idPembeli as UUID), :namaPembeli, :jk, :noTelp, :alamat);", nativeQuery = true)
//    Pembeli addPembeli(@Param("idPembeli") UUID idPembeli,
//                       @Param("namaPembeli") String namaPembeli,
//                       @Param("jk") String jk,
//                       @Param("noTelp") String noTelp,
//                       @Param("alamat") String alamat);

}
