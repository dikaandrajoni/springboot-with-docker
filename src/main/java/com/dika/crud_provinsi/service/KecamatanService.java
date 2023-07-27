package com.dika.crud_provinsi.service;

import com.dika.crud_provinsi.model.KabupatenKota;
import com.dika.crud_provinsi.model.Kecamatan;
import com.dika.crud_provinsi.model.Provinsi;
import com.dika.crud_provinsi.repository.KabupatenRepository;
import com.dika.crud_provinsi.repository.KecamatanRepository;
import com.dika.crud_provinsi.repository.ProvinsiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class KecamatanService {
    @Autowired
    private KabupatenRepository kabupatenRepository;
    @Autowired
    private KecamatanRepository kecamatanRepository;

    public List<Kecamatan> getAllKecamatan(){
        List<Kecamatan> kecamatan = new ArrayList<>();
        kecamatanRepository.findAll().iterator().forEachRemaining(kecamatan::add);
        return kecamatan;
    }

    public int addKecamatan(Kecamatan kecamatan){
        kecamatanRepository.save(kecamatan);
        return kecamatan.getId();
    }

    public void updateKecamatan(int id, Kecamatan kecamatan){
        Kecamatan kec = getKecamatan(id);
        kec.setNama(kecamatan.getNama());
        kec.setKabupaten(kecamatan.getKabupaten());
        kecamatanRepository.save(kec);
    }

    public Kecamatan getKecamatan(int id){
        return kecamatanRepository.findById(id).get();
    }

    public void deleteKecamatan(Integer id){
        kecamatanRepository.deleteById(id);
    }

}
