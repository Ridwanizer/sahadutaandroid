package com.example.klinik;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.klinik.api.client;
import com.example.klinik.model.model_user.DataUser;
import com.example.klinik.model.model_user.ResponseRegister;
import com.example.klinik.myinterface.InitComponent;
import com.example.klinik.utils.validate;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ActivityRegister extends AppCompatActivity  implements InitComponent, View.OnClickListener {

    private EditText Nama;
    private EditText NIK;
    private EditText tv_dateresult;
    private EditText Alamat;
    private EditText KK;
    private EditText Agama;
    private EditText Pendidikan;
    private EditText Pekerjaan;
    private EditText Nomor_HP;
    private EditText Password;
    private EditText ConPassword;
    private Character JK;
    private RadioButton rbl;
    private RadioButton rbp;
    private Button button_regist;
    private CoordinatorLayout coordinatorLayout;

    //declare context
    private Context mContext;

    //declare variable
    private DataUser userData;

    private ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mContext=this;
        startInit();
    }

    @Override
    public void startInit() {

        initUI();
        initValue();
        initEvent();
    }



    @Override
    public void initUI() {
        Nama=(EditText)findViewById(R.id.Nama);
        NIK=(EditText)findViewById(R.id.NIK);
        tv_dateresult=(EditText)findViewById(R.id.tv_dateresult);
        Alamat=(EditText)findViewById(R.id.Alamat);
        KK=(EditText)findViewById(R.id.KK);
        Agama=(EditText)findViewById(R.id.Agama);
        Pendidikan=(EditText)findViewById(R.id.Pendidikan);
        Pekerjaan=(EditText)findViewById(R.id.Pekerjaan);
        Nomor_HP=(EditText)findViewById(R.id.Nomor_HP);
        Password=(EditText)findViewById(R.id.Password);
        ConPassword=(EditText)findViewById(R.id.ConPassword);
        rbl=(RadioButton)findViewById(R.id.jkl);
        rbp=(RadioButton)findViewById(R.id.jkp);
        button_regist=(Button)findViewById(R.id.button_regist);


    }

    @Override
    public void initValue() {

    }

    @Override
    public void initEvent() {
        button_regist.setOnClickListener(this);
        rbl.setOnClickListener(this);
        rbp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_regist:
                if (validasi())
                    register();
                break;
            case R.id.jkl:
                JK = 'L';
                rbp.setChecked(false);
                break;
            case R.id.jkp:
                JK = 'P';
                rbl.setChecked(false);
                break;
        }

    }

    private void register(){
        pDialog = new ProgressDialog(this);
        // pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setMessage("Loading");
        pDialog.setCancelable(false);
        pDialog.show();

        Call<ResponseRegister> register;
        register = client.getApi().userRegister
                        (Nama.getText().toString(),
                        NIK.getText().toString(),
                        tv_dateresult.getText().toString(),
                        KK.getText().toString(),
                        Pendidikan.getText().toString(),
                        Pekerjaan.getText().toString(),
                        Nomor_HP.getText().toString(),
                        Alamat.getText().toString(),
                        Agama.getText().toString(),
                        JK,
                        Password.getText().toString());

        register.enqueue(new Callback<ResponseRegister>() {

            @Override
            public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                pDialog.hide();
                if (response.isSuccessful()){
                    if (response.body().getStatus()) {
                        Toasty.success(mContext,"Berhasil Dibuat", Toast.LENGTH_LONG).show();
                    }else {
                        Toasty.success(mContext,"Gagal dibuat", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toasty.error(mContext,"Gagal dibuat", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseRegister> call, Throwable t) {
                pDialog.hide();
                Toasty.success(mContext,"Koneksi bermasalah", Toast.LENGTH_LONG).show();
            }
        });
    }
    private Boolean validasi(){
        if (!validate.cek(Nama)
                &&!validate.cek(Nama)
                &&!validate.cek(NIK)
                &&!validate.cek(tv_dateresult)
                &&!validate.cek(KK)
                &&!validate.cek(Pendidikan)
                &&!validate.cek(Pekerjaan)
                &&!validate.cek(Nomor_HP)
                &&!validate.cek(Alamat)
                &&!validate.cek(Agama)
                &&!validate.cek(ConPassword)) {
            if (validate.cekPassword(ConPassword,Password.getText().toString(),ConPassword.getText().toString())){
                return false;
            }else{
                return true;
            }
        } else{ return false; }
    }
}
