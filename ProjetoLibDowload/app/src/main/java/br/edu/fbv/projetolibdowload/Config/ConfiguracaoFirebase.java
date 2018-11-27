package br.edu.fbv.projetolibdowload.Config;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class ConfiguracaoFirebase{

        private static DatabaseReference dataBase;
        private static StorageReference storage;

        // retornando a instancia do Database;
        public static DatabaseReference getFirebaseDatabase(){

            if(dataBase == null){
                dataBase = FirebaseDatabase.getInstance().getReference();
            }
            return dataBase;
        }

    public static StorageReference getFireBaseStorage(){

        if(storage == null){
            storage = FirebaseStorage.getInstance().getReference();
        }
        return storage;
    }
}
