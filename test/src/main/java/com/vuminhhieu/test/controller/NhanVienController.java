package com.vuminhhieu.test.controller;

import com.vuminhhieu.test.model.NhanVien;
import com.vuminhhieu.test.service.NhanVienService;
import com.vuminhhieu.test.service.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nhanvien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private PhongBanService phongBanService;

    @GetMapping
    public String listBooks(Model model){
        List<NhanVien> nhanViens = nhanVienService.getAllNhanVien();
        model.addAttribute("listNhanVien", nhanViens);
        model.addAttribute("title", "List Nhan Vien");
        return "index";
    }

    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("nhanvien", new NhanVien());
        model.addAttribute("listPhongBan", phongBanService.getAllPhongBan());
        return "addNew";
    }
    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("nhanvien") NhanVien nhanVien, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listPhongBan", phongBanService.getAllPhongBan());
            return "addNew";
        }
        nhanVienService.saveNhanVien(nhanVien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") String id, Model model){
        NhanVien editNhanVien = nhanVienService.getNhanVienById(id);
        if(editNhanVien != null){
            model.addAttribute("nhanvien", editNhanVien);
            model.addAttribute("listPhongBan", phongBanService.getAllPhongBan());
            return "edit";
        }else {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editBook(@Valid @ModelAttribute("nhanvien")NhanVien updateNhanVien, BindingResult bindingResult, Model model ){
        if (bindingResult.hasErrors()){
            model.addAttribute("listPhongBan", phongBanService.getAllPhongBan());
            return "edit";
        }
        nhanVienService.updateBook(updateNhanVien);
        return "redirect:/nhanvien";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") String id){
        nhanVienService.deleteNhanVien(id);
        return "redirect:/nhanvien";
    }
}
