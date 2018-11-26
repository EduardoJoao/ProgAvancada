package br.edu.fbv.projetolibdowload.Dowload;

import android.os.Environment;

import java.io.File;

import java.util.concurrent.*;

public class ThreadPoolConection {
    final File destination = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS );
    final String url = ("https://firebasestorage.googleapis.com/v0/b/teste-b3d5f.appspot.com/o/Prestadores-de-servi%C3%A7o.jpg?alt=media&token=d11c7ee2-2003-4715-b57e-9b446497a98b");



    int threadPoolSize = 6;

    String imageUrl;
    File f;

    public ThreadPoolConection(String imageUrl , File f){
        this.imageUrl =imageUrl ;
        this.f = f;
    }

    Download_img dow = new Download_img(url,destination);


    ExecutorService tpes =
            Executors.newFixedThreadPool(threadPoolSize);



    //tpes.execute(dow);


}
