package saulodev.com.atm_consultoria.ui.sobre;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;
import saulodev.com.atm_consultoria.R;


public class sobreFragment extends Fragment {


    public sobreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String descricao = "A ATM Consultoria tem como missão apoiar organizações " +
                "que desejam alcançar o sucesso atráves da excelência em gestão e "+
                "da busca pela qualidade.";

        Element versao = new Element();
        versao.setTitle("Versão 1.0");
        return new AboutPage(getActivity())
                .setImage(R.drawable.logo)
                .setDescription(descricao)

                .addGroup("Entre em contato")
                .addEmail("atendimento@atmconsultoria.com.br,", "Envie um e-mail")
                .addWebsite("https://www.google.com/", "Acesse nosso site")

                .addGroup("Redes Sociais")
                .addFacebook("saulo.gustavo.75", "Facebook")
                .addInstagram("saulo.gst", "Instagram")
                .addYoutube("saulo gustavo", "Youtube")
                .addGitHub("SauloGustavoDev", "Github")
                .addItem(versao)
                .create();

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_sobre, container, false);
    }
}