package com.dika.crud_provinsi.service;

import com.dika.crud_provinsi.model.KabupatenKota;
import com.dika.crud_provinsi.model.Provinsi;
import com.dika.crud_provinsi.repository.ProvinsiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProvinsiService {
    @Autowired
    ProvinsiRepository repo;

    public List<Provinsi> getAllProvinsi(){
        return repo.findAll();
    }

    public void save(Provinsi provinsi){
        repo.save(provinsi);
    }

    public Provinsi getProvinsi(int id){
        return repo.findById(id).get();
    }

    public void delete(int id){
        repo.deleteById(id);
    }


}
