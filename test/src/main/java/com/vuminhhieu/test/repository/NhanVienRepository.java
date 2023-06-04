package com.vuminhhieu.test.repository;

import com.vuminhhieu.test.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien,String> {

}
