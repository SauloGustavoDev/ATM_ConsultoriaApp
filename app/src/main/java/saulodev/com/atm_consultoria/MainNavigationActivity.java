package saulodev.com.atm_consultoria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import saulodev.com.atm_consultoria.databinding.ActivityMainNavigationBinding;

public class MainNavigationActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainNavigationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMainNavigation.toolbar);
        binding.appBarMainNavigation.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();

            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_servicos, R.id.nav_clientes, R.id.nav_sobre)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main_navigation);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void enviarEmail(){
        //String celular = "tel: 41997734446";
       //String imagem = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGxAjrc3YXG0Hm9R1HYaiw89ZbobtBWO_9eA&usqp=CAU";
        String endereco = "https://www.google.com/maps/place/Pedreira+Paulo+Leminski/@-25.384017,-49.279661,17z/data=!3m1!4b1!4m5!3m4!1s0x94dce6ce3d10cef5:0xa92bfe61324da3ac!8m2!3d-25.384017!4d-49.2774723";
        //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 41997734446"));
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(imagem));
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(endereco));

        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"atendimento@atmconsultoria.com.br"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "contato pelo app");
        intent.putExtra(Intent.EXTRA_TEXT, "Mensagem automática");

        //para encontrar a lista do tipos, pesquise "mime-types" no google

        intent.setType("message/rfc822");
        //intent.setType("text/plain");
        //intent.setType("image/*");
        startActivity(Intent.createChooser(intent, "Compartilhar"));
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main_navigation);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}