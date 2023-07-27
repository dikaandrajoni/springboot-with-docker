package com.dika.crud_provinsi.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kecamatan")
public class Kecamatan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nama;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kabupaten_id")
    private KabupatenKota kabupaten;

    public Kecamatan() {
    }

    public Kecamatan(int id, String nama, KabupatenKota kabupaten) {
        this.id = id;
        this.nama = nama;
        this.kabupaten = kabupaten;
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

    public KabupatenKota getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(KabupatenKota kabupaten) {
        this.kabupaten = kabupaten;
    }

}
