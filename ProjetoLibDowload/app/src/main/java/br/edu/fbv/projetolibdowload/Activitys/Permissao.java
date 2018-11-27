package br.edu.fbv.projetolibdowload.Activitys;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class Permissao {

    public static boolean validarPermissoes(String[] permissoes, Activity activity, int requestcode) {

        if (Build.VERSION.SDK_INT >= 23) {

            List<String> listapermissoes = new ArrayList<>();

            for (String permissao : permissoes) {
                Boolean aprovado = ContextCompat.checkSelfPermission(activity, permissao) == PackageManager.PERMISSION_GRANTED;
                if (!aprovado) listapermissoes.add(permissao);
            }

            if (listapermissoes.isEmpty()) return true;
            String[] newspermissoes = new String[listapermissoes.size()];
            listapermissoes.toArray(newspermissoes);

            ActivityCompat.requestPermissions(activity, newspermissoes, requestcode);
        }
        return true ;
    }



}
