package com.dika.crud_provinsi.repository;

import com.dika.crud_provinsi.model.Provinsi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProvinsiRepository extends JpaRepository<Provinsi, Integer> {
//    @Query("Select p.nama, k.nama from provinsi p JOIN kabupaten_kota k")
//    public List<Provinsi> listProvinsi();
}
