package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DataBarangRepository extends JpaRepository<Barang, UUID> {
    @Query(value = "SELECT cast (id_barang as varchar) id_barang, nama_barang, harga, stok, id_supplier\n" +
            "FROM sample.tbl_barang where id_barang =:idBarang", nativeQuery = true)
    Barang getBarangByid(@Param("idBarang") UUID idBarang);

}
