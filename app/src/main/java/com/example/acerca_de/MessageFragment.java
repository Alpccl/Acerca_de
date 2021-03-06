package com.example.acerca_de;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.BundleCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.acerca_de.databinding.FragmentMessageBinding;


public class MessageFragment extends Fragment {

    private FragmentMessageBinding  mBinding;


    public MessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding=FragmentMessageBinding.inflate(inflater, container, false);
        return mBinding.getRoot();

        mBinding.BtnContact.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v) {
                        mBinding.BtnContact.setVisibility(View.GONE);
                        mBinding.MsgHolder.setVisibility(View.VISIBLE);
                        mBinding.BtnSend.setVisibility(View.VISIBLE);

                    }
                });

        mBinding.BtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBinding.EdtxMsg.getText().toString().length() != 0) {
                    String message = mBinding.EdtxMsg.getText().toString();
                    SendMessage(message);
                } else {
                    Toast.makeText(getContext(), "Porfavor Ingrese un Mensaje",
                            Toast.LENGTH_SHORT).show();
                }
            }
        }
    }





    private void SendMessage(String message){
        String[] Emails = {"aledleonv@gmail.com", "support@mail.com"};
        Intent mintent = new Intent(Intent.ACTION_SENDTO);

        mintent.setData(Uri.parse("mailto;"));
        mintent.putExtra(Intent.EXTRA_EMAIL, Emails );
        mintent.putExtra(Intent.EXTRA_SUBJECT,"Contacto Acercade_APP");
        mintent.putExtra(Intent.EXTRA_TEXT, message);
        if (mintent.resolveActivity(getActivity().getPackageManager()) !=null){
            startActivity(mintent);
        }else{
            Toast.makeText(getContext(), "Porfavor Instale una App de Correo para contactar",
                    Toast.LENGTH_SHORT).show();
        }
    }

