package com.dika.crud_provinsi.controller;

import com.dika.crud_provinsi.model.KabupatenKota;
import com.dika.crud_provinsi.model.Kecamatan;
import com.dika.crud_provinsi.model.Provinsi;
import com.dika.crud_provinsi.service.KabupatenService;
import com.dika.crud_provinsi.service.KecamatanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class KecamatanController {
    @Autowired
    private KecamatanService kecamatanService;
    @Autowired
    private KabupatenService kabupatenService;

    @GetMapping("/kecamatan")
    public String getAllKecamatan(Model model){
        List<Kecamatan> kecamatan = kecamatanService.getAllKecamatan();
        model.addAttribute("kecamatan", kecamatan);
        return "kecamatan/ListKecamatan";
    }

    @RequestMapping(value = "/kecamatan/tambah")
    public String addKecamatan(Model model){
        Kecamatan kecamatan = new Kecamatan();
        model.addAttribute("kecamatan", kecamatan);
        List<KabupatenKota> kabupaten = kabupatenService.getAllKabKota();
        model.addAttribute("kabupaten", kabupaten);
        return "kecamatan/FormKecamatan";
    }

    @RequestMapping(value = "/kecamatan/simpan", method = RequestMethod.POST)
    public String saveKecamatan(Kecamatan kecamatan){
        int id = kecamatanService.addKecamatan(kecamatan);
        return "redirect:/kecamatan";
    }

    @RequestMapping(value = "/kecamatan/edit/{id}")
    public String editKecamatan(@PathVariable(name = "id") int id, Model model){
        Kecamatan kecamatan = kecamatanService.getKecamatan(id);
        List<KabupatenKota> kabupaten = kabupatenService.getAllKabKota();
        model.addAttribute("kabupaten", kabupaten);
        model.addAttribute("kecamatan", kecamatan);
        return "kecamatan/EditKecamatan";
    }

    @RequestMapping(value = "/kecamatan/update/{id}")
    public String updateKecamatan(@PathVariable(name = "id") int id, Kecamatan kecamatan){
        kecamatanService.updateKecamatan(id,kecamatan);
        return "redirect:/kabupaten";
    }

    @RequestMapping("/kecamatan/delete/{id}")
    public String deleteKecamatan(@PathVariable(name = "id") int id) {
        kecamatanService.deleteKecamatan(id);
        return "redirect:/kecamatan";
    }



}
