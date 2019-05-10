package com.example.klinik.model.model_user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */
public class DataUser {
    @SerializedName("no_rm")
    @Expose
    private Integer no_rm;

    @SerializedName("NIK")
    @Expose
    private String nik;

    @SerializedName("tgl_lahir")
    @Expose
    private String tgl_lahir;

    @SerializedName("nama_pasien")
    @Expose
    private String nama_pasien;

    @SerializedName("nama_kk")
    @Expose
    private String nama_kk;

    @SerializedName("pendidikan")
    @Expose
    private String pendidikan;

    @SerializedName("pekerjaan")
    @Expose
    private String pekerjaan;

    @SerializedName("no_hp")
    @Expose
    private String no_hp;

    @SerializedName("jenis_kelamin")
    @Expose
    private Character jenis_kelamin;

    @SerializedName("alamat")
    @Expose
    private String alamat;

    @SerializedName("agama")
    @Expose
    private String agama;

    @SerializedName("password")
    @Expose
    private String password;


    public Integer getNo_rm() {
        return no_rm;
    }

    public void setNo_rm(Integer no_rm) {
        this.no_rm = no_rm;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getTglLahir() {
        return tgl_lahir;
    }

    public void setTglLahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getNamaPasien() {
        return nama_pasien;
    }

    public void setNamaPasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }

    public String getNamaKK() {
        return nama_kk;
    }

    public void setNamaKK(String nama_kk) {
        this.nama_kk = nama_kk;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public Character getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(Character jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
