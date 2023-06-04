package com.vuminhhieu.test.service;

import com.vuminhhieu.test.model.NhanVien;
import com.vuminhhieu.test.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanvienRepository;

    public List<NhanVien> getAllNhanVien() {
        return this.nhanvienRepository.findAll();
    }

    public void saveNhanVien(NhanVien nhanvien) {
        this.nhanvienRepository.save(nhanvien);
    }

    public NhanVien getNhanVienById(String id) {
        Optional<NhanVien> optional = nhanvienRepository.findById(id);
        NhanVien nhanvien = null;
        if(optional.isPresent()){
            nhanvien = optional.get();
        }
        else {
            throw new RuntimeException("Product not found for id ::" +id);
        }
        return nhanvien;
    }

    public void updateBook(NhanVien newNhanVien){
        nhanvienRepository.save(newNhanVien);
    }

    public void deleteNhanVien(String id) {
        this.nhanvienRepository.deleteById(id);
    }
}
