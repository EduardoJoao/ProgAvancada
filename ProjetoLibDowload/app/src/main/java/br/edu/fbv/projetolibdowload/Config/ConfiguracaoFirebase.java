package br.edu.fbv.projetolibdowload.Config;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ConfiguracaoFirebase{

        private static DatabaseReference dataBase;

        // retornando a instancia do Database;
        public static DatabaseReference getFirebaseDatabase(){

            if(dataBase == null){
                dataBase = FirebaseDatabase.getInstance().getReference();
            }
            return dataBase;
        }
}
