package com.dika.crud_provinsi.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kabupaten_kota")
public class KabupatenKota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nama;

    @ManyToOne
    @JoinColumn(name = "provinsi_id")
    private Provinsi provinsi;

    public KabupatenKota() {
    }

    public KabupatenKota(int id, String nama, Provinsi provinsi) {
        this.id = id;
        this.nama = nama;
        this.provinsi = provinsi;
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

    public Provinsi getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(Provinsi provinsi) {
        this.provinsi = provinsi;
    }


}
