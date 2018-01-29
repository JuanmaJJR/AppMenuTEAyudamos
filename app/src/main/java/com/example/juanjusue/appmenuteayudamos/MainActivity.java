package com.example.juanjusue.appmenuteayudamos;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.juanjusue.appmenuteayudamos.Fragments.LoginFragment;
import com.example.juanjusue.appmenuteayudamos.Fragments.UsuariosPlantas;

public class MainActivity extends AppCompatActivity {
    LoginFragment loginFragment;
    UsuariosPlantas usuariosPlantas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginFragment = (LoginFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentLogin);
        usuariosPlantas = new UsuariosPlantas();
        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.show(loginFragment);
        transition.commit();

    }
    public void comprobarUser(View v){
        if( usuariosPlantas.esUser(loginFragment.getEtUser().getText().toString(),loginFragment.getEtPass().getText().toString())){
            Log.v("LoginFragment","siiii");
        }
        else{
            Log.v("LoginFragment","noo");
        }
    }
}
