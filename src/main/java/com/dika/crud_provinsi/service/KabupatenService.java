package com.dika.crud_provinsi.service;

import com.dika.crud_provinsi.model.KabupatenKota;
import com.dika.crud_provinsi.repository.KabupatenRepository;
import com.dika.crud_provinsi.repository.ProvinsiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class KabupatenService{
    @Autowired
    private KabupatenRepository kabupatenRepository;
    @Autowired
    private ProvinsiRepository provinsiRepository;

    public List<KabupatenKota> getAllKabKota(){
        List<KabupatenKota> kabupatenKotas = new ArrayList<>();
        kabupatenRepository.findAll().iterator().forEachRemaining(kabupatenKotas::add);
        return kabupatenKotas;
    }

    public int addKabupatenKota(KabupatenKota kabupatenKota){
       kabupatenRepository.save(kabupatenKota);
       return kabupatenKota.getId();
    }

    public void updateKabupatenKota(int id, KabupatenKota kabupatenKota){
        KabupatenKota kab = getKabupatenKota(id);
        kab.setNama(kabupatenKota.getNama());
        kab.setProvinsi(kabupatenKota.getProvinsi());
        kabupatenRepository.save(kab);
    }

    public KabupatenKota getKabupatenKota(int id){
        return kabupatenRepository.findById(id).get();
    }

    public void deleteKabKota(Integer id){
        kabupatenRepository.deleteById(id);
    }

}
