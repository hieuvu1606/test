package com.vuminhhieu.test.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name="PhongBan")
public class PhongBan {

    @Id
    @Column(name = "Ma_Phong")
    private String Ma_Phong;

    @Column(name = "Ten_Phong")
    @NotNull(message = "Name is required")
    private String Ten_Phong;

    @OneToMany(mappedBy = "phongBan", cascade = CascadeType.ALL)
    private List<NhanVien> nhanViens;

}
