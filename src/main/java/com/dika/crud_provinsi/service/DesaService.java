package com.dika.crud_provinsi.service;

import com.dika.crud_provinsi.model.Desa;
import com.dika.crud_provinsi.model.Kecamatan;
import com.dika.crud_provinsi.repository.DesaRepository;
import com.dika.crud_provinsi.repository.KecamatanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DesaService {
    @Autowired
    private DesaRepository desaRepository;
    @Autowired
    private KecamatanRepository kecamatanRepository;

    public List<Desa> getAllDesa(){
        List<Desa> desa = new ArrayList<>();
        desaRepository.findAll().iterator().forEachRemaining(desa::add);
        return desa;
    }

    public void addDesa(Desa desa){
        desaRepository.save(desa);
    }

    public void updateDesa(int id, Desa desa){
        Desa ds = getDesa(id);
        ds.setNama(desa.getNama());
        ds.setKecamatan(desa.getKecamatan());
        desaRepository.save(ds);
    }
    public Desa getDesa(int id){
        return desaRepository.findById(id).get();
    }
    public void deleteDesa(Integer id){
        desaRepository.deleteById(id);
    }
}
