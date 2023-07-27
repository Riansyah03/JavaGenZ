package com.boniewijaya2021.springboot.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbl_barang", schema = "sample")
public class Barang {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id_barang")
    private UUID idBarang;

    @Column(name = "nama_barang", length = 20, nullable = false)
    private String namaBarang;

    @Column(name = "harga")
    private Integer harga;

    @Column(name = "stok")
    private Integer stok;

    @Column(name = "id_supplier")
    private UUID idSupplier;



}
