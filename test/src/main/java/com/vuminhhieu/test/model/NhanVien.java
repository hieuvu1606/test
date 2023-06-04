package com.vuminhhieu.test.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="NhanVien")
public class NhanVien {
    @Id
    @Column(name="Ma_NV")
    private String Ma_NV;

    @Column(name="Ten_NV")
    @NotNull(message = "Employee name is required")
    private String Ten_NV;

    @Column(name="Phai")
    private String Phai;

    @Column(name="Noi_Sinh")
    private String Noi_Sinh;

    @ManyToOne
    @JoinColumn(name = "Ma_Phong")
    private PhongBan phongBan;

    @Column(name="Luong")
    private int Luong;


}
