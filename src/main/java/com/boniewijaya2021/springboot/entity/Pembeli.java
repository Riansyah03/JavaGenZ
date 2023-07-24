package com.boniewijaya2021.springboot.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Setter
@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbl_pembeli", schema = "sample")
public class Pembeli implements Serializable {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id_pembeli")
    private UUID idPembeli;

    @Column(name = "nama_pembeli", length = 30, nullable = false)
    private String namaPembeli;

    @Column(name = "jk", length = 1)
    private String jk;

    @Column(name = "no_telp", length = 14)
    private String noTelp;

    @Column(name = "alamat", length = 50)
    private String alamat;

    public UUID returningId(){
        return idPembeli;
    }
}
