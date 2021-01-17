package com.example.acerca_de;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.acerca_de.databinding.ActivityContactBinding;
import com.example.acerca_de.databinding.FragmentMessageBinding;

import java.util.zip.Inflater;

public class ContactActivity extends AppCompatActivity {

    private ActivityContactBinding Binding;
    private String Facebook = "https://www.facebook.com/leondelhuasco";
    private String Linkedin = "https://www.linkedin.com/in/alexis-leon-villegas-aa445088/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View OnCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Binding = ActivityContactBinding.inflate(inflater, container, false);
        return Binding.getRoot();
        Binding.IBFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Uri uri = Uri.parse(Facebook);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
            }
        });

        Binding.IBInkeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(Linkedin);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


    }

}



