package com.dika.crud_provinsi.model;

import javax.persistence.*;

@Entity
@Table(name = "desa")
public class Desa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nama;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kecamatan_id")
    private Kecamatan kecamatan;

    public Desa() {
    }

    public Desa(int id, String nama, Kecamatan kecamatan) {
        this.id = id;
        this.nama = nama;
        this.kecamatan = kecamatan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Kecamatan getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(Kecamatan kecamatan) {
        this.kecamatan = kecamatan;
    }
}
