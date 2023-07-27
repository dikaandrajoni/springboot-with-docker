package com.dika.crud_provinsi.controller;

import com.dika.crud_provinsi.model.Desa;
import com.dika.crud_provinsi.model.Kecamatan;
import com.dika.crud_provinsi.service.DesaService;
import com.dika.crud_provinsi.service.KecamatanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Controller
public class DesaController {
    @Autowired
    private KecamatanService kecamatanService;
    @Autowired
    private DesaService desaService;

    @GetMapping("/desa")
    public String getAllDesa(Model model){
        List<Desa> desa = desaService.getAllDesa();
        model.addAttribute("desa", desa);
        return "desa/ListDesa";
    }

    @RequestMapping(value = "/desa/tambah")
    public String addDesa(Model model){
        Desa desa = new Desa();
        model.addAttribute("desa", desa);
        List<Kecamatan> kecamatan = kecamatanService.getAllKecamatan();
        model.addAttribute("kecamatan", kecamatan);
        return "desa/FormDesa";
    }

    @RequestMapping(value = "/desa/simpan", method = RequestMethod.POST)
    public String saveDesa(Desa desa){
        desaService.addDesa(desa);
        return "redirect:/desa";
    }



    @RequestMapping(value = "/desa/edit/{id}")
    public String editDesa(@PathVariable(name = "id") int id, Model model){
        Desa desa = desaService.getDesa(id);
        List<Kecamatan> kecamatan = kecamatanService.getAllKecamatan();
        model.addAttribute("desa", desa);
        model.addAttribute("kecamatan", kecamatan);
        return "desa/EditDesa";
    }

    @RequestMapping(value = "/desa/update/{id}")
    public String updateDesa(@PathVariable(name = "id") int id, Desa desa){
        desaService.updateDesa(id,desa);
        return "redirect:/desa";
    }

    @RequestMapping("/desa/delete/{id}")
    public String deleteDesa(@PathVariable(name = "id") int id) {
        desaService.deleteDesa(id);
        return "redirect:/desa";
    }


}
