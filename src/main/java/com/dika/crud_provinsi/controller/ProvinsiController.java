package com.dika.crud_provinsi.controller;

import com.dika.crud_provinsi.model.Provinsi;
import com.dika.crud_provinsi.repository.KabupatenRepository;
import com.dika.crud_provinsi.repository.ProvinsiRepository;
import com.dika.crud_provinsi.service.KabupatenService;
import com.dika.crud_provinsi.service.ProvinsiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProvinsiController {

    @Autowired
    private ProvinsiService service;
    @Autowired
    JdbcTemplate jdbc;

    @RequestMapping(value = "/")
    public String listDaerah(Model model){

        List<Provinsi> listProvinsi = jdbc.query(
                "SELECT p.id, p.nama, kab.id, kab.nama, kec.id, kec.nama , d.nama FROM " +
                        "provinsi p LEFT JOIN kabupaten_kota kab ON p.id=kab.provinsi_id  " +
                        "LEFT JOIN kecamatan kec ON kab.id=kec.kabupaten_id " +
                        "LEFT JOIN desa d ON kec.id=d.kecamatan_id order by p.id, d.id" ,
                (rs, rowNum) -> new Provinsi(rs.getInt("p.id"), rs.getString("p.nama"),
                        rs.getString("kab.nama"),
                        rs.getString("kec.nama"),rs.getString("d.nama")));

        model.addAttribute("listProvinsi", listProvinsi);
        return "index";
    }

    @RequestMapping(value = "/provinsi")
    public String listProvinsi(Model model){
        List<Provinsi> listProvinsi = service.getAllProvinsi();
        model.addAttribute("listProvinsi", listProvinsi);
        return "provinsi/list_provinsi";
    }



    @RequestMapping(value = "/provinsi/tambah")
    public String addProvinsi(Model model){
        Provinsi provinsi = new Provinsi();
        model.addAttribute("provinsi", provinsi);
        return "provinsi/FormProvinsi";
    }

    @RequestMapping(value = "/provinsi/simpan", method = RequestMethod.POST)
    public String saveProvinsi(@ModelAttribute("provinsi") Provinsi provinsi){
        service.save(provinsi);
        return "redirect:/provinsi";
    }

    @RequestMapping(value = "/provinsi/edit/{id}")
    public ModelAndView editProvinsi(@PathVariable(name = "id") int id){
        ModelAndView mv = new ModelAndView("provinsi/EditProvinsi");
        Provinsi provinsi = service.getProvinsi(id);
        mv.addObject("provinsi", provinsi);
        return mv;
    }

    @RequestMapping("/provinsi/delete/{id}")
    public String deleteProvinsi(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/provinsi";
    }

}
