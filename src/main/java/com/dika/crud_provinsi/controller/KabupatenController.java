package com.dika.crud_provinsi.controller;

import com.dika.crud_provinsi.model.KabupatenKota;
import com.dika.crud_provinsi.model.Provinsi;
import com.dika.crud_provinsi.service.KabupatenService;
import com.dika.crud_provinsi.service.ProvinsiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

@Controller
public class KabupatenController {
    @Autowired
    private KabupatenService kabupatenService;

    @Autowired
    private ProvinsiService provinsiService;

    @GetMapping("/kabupaten")
    public String getAllKabupatenKota(Model model){
        List<KabupatenKota> kabupatenKotas = kabupatenService.getAllKabKota();
        model.addAttribute("kabupatenKota", kabupatenKotas);
        return "kabupatenKota/list_kabupaten";
    }

    @RequestMapping(value = "/kabupaten/tambah")
    public String addKabupaten(Model model){
        KabupatenKota kabupatenKota = new KabupatenKota();
        model.addAttribute("kabupatenKota", kabupatenKota);
        List<Provinsi> provinsi = provinsiService.getAllProvinsi();
        model.addAttribute("provinsi", provinsi);
        return "kabupatenKota/FormKabupaten";
    }

    @RequestMapping(value = "/kabupaten/simpan", method = RequestMethod.POST)
    public String saveKabupaten(KabupatenKota kabupatenKota){
        int id = kabupatenService.addKabupatenKota(kabupatenKota);
        return "redirect:/kabupaten";
    }

    @RequestMapping(value = "/kabupaten/edit/{id}")
    public String editKabupaten(@PathVariable(name = "id") int id, Model model){
        KabupatenKota kabupatenKota = kabupatenService.getKabupatenKota(id);
        List<Provinsi> provinsi = provinsiService.getAllProvinsi();
        model.addAttribute("provinsi", provinsi);
        model.addAttribute("kabupatenKota", kabupatenKota);
        return "kabupatenKota/EditKabupaten";
    }

    @RequestMapping(value = "/kabupaten/update/{id}")
    public String updateKabupaten(@PathVariable(name = "id") int id, KabupatenKota kabupatenKota){
       kabupatenService.updateKabupatenKota(id,kabupatenKota);
        return "redirect:/kabupaten";
    }

    @RequestMapping("/kabupaten/delete/{id}")
    public String deleteKabupaten(@PathVariable(name = "id") int id) {
        kabupatenService.deleteKabKota(id);
        return "redirect:/kabupaten";
    }



}
