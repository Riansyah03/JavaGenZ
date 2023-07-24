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
@Table(name="tbl_supplier", schema = "sample")
public class Supplier {


    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id_supplier")
    private UUID idSupplier;

    @Column(name = "nama_supplier", length = 30, nullable = false)
    private String namaSupplier;

    @Column(name = "no_telp", length = 13)
    private String noTelp;

    @Column(name = "alamat", length = 100)
    private String alamat;

}
