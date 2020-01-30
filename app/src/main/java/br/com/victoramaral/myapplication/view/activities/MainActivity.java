package br.com.victoramaral.myapplication.view.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import br.com.victoramaral.myapplication.R;

import static br.com.victoramaral.myapplication.view.activities.RegisterActivity.EMAIL_KEY;
import static br.com.victoramaral.myapplication.view.activities.RegisterActivity.NOME_KEY;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View navHeader = navigationView.getHeaderView(0);
        TextView nomeUsuario = navHeader.findViewById(R.id.headerTextNome);
        TextView emailUsuario = navHeader.findViewById(R.id.headerTextEmail);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_produtos, R.id.nav_addproduto,
                R.id.nav_remoproduto, R.id.nav_sobre)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            nomeUsuario.setText(bundle.getString(NOME_KEY));
            emailUsuario.setText(bundle.getString(EMAIL_KEY));
        } else {
            Toast.makeText(this, "Não foi possível carregar os dados de usuário",
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
