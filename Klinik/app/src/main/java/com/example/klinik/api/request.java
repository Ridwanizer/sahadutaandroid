package com.example.klinik.api;

import com.example.klinik.model.model_user.ResponseRegister;
import com.example.klinik.model.model_user.ResponseLogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */

public interface request{
    @FormUrlEncoded
    @POST("Api/auth")
    Call<ResponseLogin> auth(@Field("no_rm") String no_rm,
                             @Field("password") String password);

    @FormUrlEncoded
    @POST("Api/user")
    Call<ResponseRegister> userRegister(@Field("nama_pasien")String nama_pasien,
                                        @Field("NIK")String nik,
                                        @Field("tgl_lahir")String tgl_lahir,
                                        @Field("nama_kk")String nama_kk,
                                        @Field("pendidikan")String pendidikan,
                                        @Field("pekerjaan")String pekerjaan,
                                        @Field("no_hp")String no_hp,
                                        @Field("alamat")String alamat,
                                        @Field("agama")String agama,
                                        @Field("jenis_kelamin")Character jenis_kelamin,
                                        @Field("password")String password);
    @FormUrlEncoded
    @PUT("Api/user")
    Call<ResponseRegister> userUpdate(@Field("nama_pasien")String nama_pasien,
                                      @Field("NIK")String nik,
                                      @Field("tgl_lahir")String tgl_lahir,
                                      @Field("nama_kk")String nama_kk,
                                      @Field("pendidikan")String pendidikan,
                                      @Field("pekerjaan")String pekerjaan,
                                      @Field("no_hp")String no_hp,
                                      @Field("alamat")String alamat,
                                      @Field("jenis_kelamin")Character jenis_kelamin,
                                      @Field("password")String password);







//    @FormUrlEncoded
//    @POST("Api/pesanan")
//    Call<ResponseRegisterTransaksi> checkout(@Body DataCarts data);
}
