package com.dika.crud_provinsi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "provinsi")
public class Provinsi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nama;
    private String kabupaten;
    private String kecamatan;
    private String desa;

    @OneToMany(mappedBy = "provinsi",cascade = CascadeType.ALL)
    List<KabupatenKota> kabupatenKotas = new ArrayList<KabupatenKota>();

    public Provinsi() {
    }

    public Provinsi(Integer id, String nama, String kabupaten, String kecamatan, String desa) {
        this.id = id;
        this.nama = nama;
        this.kabupaten = kabupaten;
        this.kecamatan = kecamatan;
        this.desa = desa;
    }

    public String getDesa() {
        return desa;
    }

    public void setDesa(String desa) {
        this.desa = desa;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public List<KabupatenKota> getKabupatenKotas() {
        return kabupatenKotas;
    }

    public void setKabupatenKotas(List<KabupatenKota> kabupatenKotas) {
        this.kabupatenKotas = kabupatenKotas;
    }
}
