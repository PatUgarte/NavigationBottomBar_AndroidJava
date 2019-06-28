package digitalhouse.com.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Me traigo el BottomNavigationView del XML a Java para poder programarlo.
        BottomNavigationView bottomNavigationView = findViewById(R.id.BottomNavigationView);

        //  Cargo por defecto el ProfileFragment, para que no aparezca el contenedor vacío.
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragments,new ProfileFragment()).commit();
        //  Como el fragmento que decidí cargar por defecto es el del medio en el menú de la BottomBar configuro que esa aparezca seleccionada inicialmente.
        bottomNavigationView.setSelectedItemId(R.id.item_profile_bottom);


        //  Configuro el escuchador la selección de cualquier item en el menú
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //  Hago el switch para responder de forma diferente según el item del menú elegido.
                switch (menuItem.getItemId()){
                    case R.id.item_home_bottom:
                        Toast.makeText(MainActivity.this, "HOME", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragments,new HomeFragment()).commit();
                        break;
                    case R.id.item_profile_bottom:
                        Toast.makeText(MainActivity.this, "PROFILE", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragments,new ProfileFragment()).commit();
                        break;
                    case R.id.item_extras_bottom:
                        Toast.makeText(MainActivity.this, "EXTRAS", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragments,new ExtrasFragment()).commit();
                        break;
                }
                return true;
            }
        });
    }
}
