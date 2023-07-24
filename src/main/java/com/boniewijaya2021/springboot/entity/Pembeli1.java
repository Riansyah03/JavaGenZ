package com.boniewijaya2021.springboot.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbl_pembeli1", schema = "sample")
public class Pembeli1 {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id_pembayaran")
    private UUID idPembayaran;

    @Column(name = "tgl_bayar")
    private Date tglBayar;

    @Column(name = "total_bayar")
    private Integer totalBayar;

    @ManyToOne
    @JoinColumn(name = "id_transaksi")
    private Transaksi transaksi;
}
