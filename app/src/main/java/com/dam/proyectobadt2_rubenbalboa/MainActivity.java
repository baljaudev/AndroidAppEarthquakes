package com.dam.proyectobadt2_rubenbalboa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dam.proyectobadt2_rubenbalboa.dao.PaisesDao;
import com.dam.proyectobadt2_rubenbalboa.dao.TerremotosDao;
import com.dam.proyectobadt2_rubenbalboa.db.TerremotosDB;
import com.dam.proyectobadt2_rubenbalboa.dialog.FiltroDialog;
import com.dam.proyectobadt2_rubenbalboa.dialog.OnFiltroListener;
import com.dam.proyectobadt2_rubenbalboa.entity.PaisAfectado;
import com.dam.proyectobadt2_rubenbalboa.entity.Terremoto;
import com.dam.proyectobadt2_rubenbalboa.rvutil.TerremotoAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnFiltroListener {

    public static final String TODOS_CAMPOS = "Todos";
    Button btnFiltrar;
    Button btnConsultar;
    TextView tvFiltroUsado;

    RecyclerView rvTerremotos;
    LinearLayoutManager llm;
    TerremotoAdapter tAdapter;

    String mes;
    String anio;
    String pais;

    ArrayList<Terremoto> listaTerremotos;
    TerremotosDB db;
    TerremotosDao tDao;
    PaisesDao pDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFiltrar = findViewById(R.id.btnFiltro);
        btnConsultar = findViewById(R.id.btnConsultar);
        tvFiltroUsado = findViewById(R.id.tvFiltroUsado);

        rvTerremotos = findViewById(R.id.rvTerremotos);


        db = TerremotosDB.getDatabase(this);
        tDao = db.terremotosDAO();
        pDao = db.paisesDAO();

        btnFiltrar.setOnClickListener(this);
        btnConsultar.setOnClickListener(this);

        cargarDatos();
    }

    private void cargarDatos() {
        listaTerremotos = (ArrayList<Terremoto>) tDao.getAll();
        if(listaTerremotos.isEmpty()) {
            insertarTerremotos();
            insertarPaises();
        }
    }

    private void insertarPaises() {
        pDao.insert(new PaisAfectado("22 de mayo de 1960, 15:11", "Chile"));
        pDao.insert(new PaisAfectado("26 de diciembre de 2004, 07:58", "Indonesia"));
        pDao.insert(new PaisAfectado("27 de marzo de 1964, 17:36", "Estados Unidos"));
        pDao.insert(new PaisAfectado("11 de marzo de 2011, 14:46", "Jap??n"));
        pDao.insert(new PaisAfectado("4 de noviembre de 1952, 16:58", "Rusia"));
        pDao.insert(new PaisAfectado("13 de agosto de 1868, 21:30", "Chile"));
        pDao.insert(new PaisAfectado("28 de octubre de 1746, 22:30", "Per??"));
        pDao.insert(new PaisAfectado("26 de enero de 1700, 21:30", "Estados Unidos"));
        pDao.insert(new PaisAfectado("27 de febrero de 2010, 03:34", "Chile"));
        pDao.insert(new PaisAfectado("6 de febrero de 2023, 01:17", "Turqu??a"));
        pDao.insert(new PaisAfectado("6 de febrero de 2023, 01:17", "Siria"));
        pDao.insert(new PaisAfectado("31 de enero de 1906, 15:36", "Ecuador"));
        pDao.insert(new PaisAfectado("31 de enero de 1906, 15:36", "Colombia"));
        pDao.insert(new PaisAfectado("25 de noviembre de 1833, 20:00", "Indonesia"));
        pDao.insert(new PaisAfectado("1 de noviembre de 1755, 10:16", "Portugal"));
        pDao.insert(new PaisAfectado("8 de julio de 1730, 04:45", "Chile"));
        pDao.insert(new PaisAfectado("11 de abril de 2012, 15:38", "Indonesia"));
        pDao.insert(new PaisAfectado("28 de marzo de 2005, 23:09", "Indonesia"));
        pDao.insert(new PaisAfectado("9 de marzo de 1957, 14:22", "Estados Unidos"));
        pDao.insert(new PaisAfectado("15 de agosto de 1950", "India"));
        pDao.insert(new PaisAfectado("15 de agosto de 1950", "China"));
        pDao.insert(new PaisAfectado("10 de noviembre de 1922, 23:53", "Argentina"));
        pDao.insert(new PaisAfectado("28 de marzo de 1787, 11:30", "M??xico"));
        pDao.insert(new PaisAfectado("3 de febrero de 1923, 04:58", "Rusia"));
        pDao.insert(new PaisAfectado("20 de octubre de 1687, 09:15", "Per??"));
        pDao.insert(new PaisAfectado("16 de diciembre de 1575, 14:30", "Chile"));
        pDao.insert(new PaisAfectado("16 de septiembre de 2015, 19:54", "Chile"));
        pDao.insert(new PaisAfectado("23 de junio de 2001, 15:33","Per??"));
    }

    private void insertarTerremotos() {
        tDao.insert(new Terremoto("22 de mayo de 1960, 15:11", 9.5, "Terremoto de Valdivia de 1960", "Valdivia, Regi??n de los R??os", "38??14???24???S 73??3???0???O", "1655 a 2000"));
        tDao.insert(new Terremoto("26 de diciembre de 2004, 07:58", 9.3, "Terremoto del oc??ano ??ndico de 2004", "Frente al norte de la isla de Sumatra", "Sin datos", "230270"));
        tDao.insert(new Terremoto("27 de marzo de 1964, 17:36", 9.2, "Terremoto de Alaska de 1964", "Anchorage, Alaska", "61??N 148??O", "128"));
        tDao.insert(new Terremoto("11 de marzo de 2011, 14:46", 9.1, "Terremoto y maremoto de Jap??n de 2011", "Costa Este de la Regi??n de T??hoku, Honsh??", "38??19???19.20???N 142??22???8.40???E", "15897"));
        tDao.insert(new Terremoto("4 de noviembre de 1952, 16:58", 9.0, "Terremoto de Kamchatka de 1952", "Pen??nsula de Kamchatka", "52??48???N 159??30???E", "2366"));
        tDao.insert(new Terremoto("13 de agosto de 1868, 21:30", 9.0, "Terremoto de Arica de 1868", "Arica", "18??36???S 71??0???O", "693"));
        tDao.insert(new Terremoto("28 de octubre de 1746, 22:30", 9.0, "Terremoto de Lima de 1746", "Lima y Callao", "11??21???00???S 77??16???48???O", "15000 a 20000"));
        tDao.insert(new Terremoto("26 de enero de 1700, 21:30", 9.0, "Terremoto de Cascadia de 1700", "California, Oreg??n, Washington y Columbia Brit??nica", "Sin datos", "Sin datos"));
        tDao.insert(new Terremoto("27 de febrero de 2010, 03:34", 8.8, "Terremoto de Chile de 2010", "Cobquecura, Regi??n del Biob??o (actual ??uble)", "35??50???45.6???S 72??42???57.6???O", "525"));
        tDao.insert(new Terremoto("31 de enero de 1906, 15:36", 8.8, "Terremoto de Ecuador y Colombia de 1906", "Frente a las costas de Esmeraldas", "1??0???N 81??30???O", "1500"));
        tDao.insert(new Terremoto("25 de noviembre de 1833, 20:00", 8.8, "Terremoto de Sumatra de 1833", "En el mar al sur de la isla de Sumatra, a 175 km al sur de Padang", "3??30???S 102??12???E", "Sin datos"));
        tDao.insert(new Terremoto("1 de noviembre de 1755, 10:16", 8.7, "Terremoto de Lisboa de 1755", "Lisboa", "36??N 11??O", "60000 a 100000"));
        tDao.insert(new Terremoto("8 de julio de 1730, 04:45", 8.7, "Terremoto de Valpara??so de 1730", "Valpara??so y La Serena", "33??30???S 71??36???O", "300"));
        tDao.insert(new Terremoto("11 de abril de 2012, 15:38", 8.6, "Terremoto del oc??ano ??ndico de 2012", "Frente al norte de la isla de Sumatra", "02??18???39.6???N 93??03???46.8???E", "10"));
        tDao.insert(new Terremoto("28 de marzo de 2005, 23:09", 8.6, "Terremoto de Sumatra de 2005", "Frente al norte de la isla de Sumatra", "2??36???N 97??6???E", "1300"));
        tDao.insert(new Terremoto("9 de marzo de 1957, 14:22", 8.6, "Terremoto de las islas Andreanof de 1957", "Islas Andreanof, Alaska", "51??33???36???N 175??23???24???O", "0"));
        tDao.insert(new Terremoto("15 de agosto de 1950", 8.6, "Terremoto de Assam de 1950", "Assam (India)); T??bet (China)", "28??30???N 96??30???O", "1526"));
        tDao.insert(new Terremoto("10 de noviembre de 1922, 23:53", 8.6, "Terremoto de Vallenar de 1922 Chile", "Regi??n de Atacama y Provincia de Catamarca", "Sin datos", "1500"));
        tDao.insert(new Terremoto("28 de marzo de 1787, 11:30", 8.6, "Terremoto de Nueva Espa??a de 1787", "Costas de Oaxaca y Guerrero", "Sin datos", "11"));
        tDao.insert(new Terremoto("3 de febrero de 1923, 04:58", 8.5, "Terremoto de Kamchatka de 1923", "Pen??nsula de Kamchatka", "54??N 161??E", "Sin datos"));
        tDao.insert(new Terremoto("20 de octubre de 1687, 09:15", 8.5, "Terremotos de Lima y Callao de 1687", "Lima y Callao", "Sin datos", "5000"));
        tDao.insert(new Terremoto("16 de diciembre de 1575, 14:30", 8.5, "Terremoto de Valdivia de 1575", "Valdivia", "39??48???S 73??12???O", "1221"));
        tDao.insert(new Terremoto("16 de septiembre de 2015, 19:54", 8.4, "Terremoto de Coquimbo de 2015", "Frente a las costas de la Comuna de Canela, Regi??n de Coquimbo", "31??34???52???S 71??45???07???O", "12"));
        tDao.insert(new Terremoto("23 de junio de 2001, 15:33", 8.4, "Terremoto del sur del Per?? de 2001", "Departamentos de Arequipa, Moquegua y Tacna", "16??15???36???S 73??38???24???O", "102"));
        tDao.insert(new Terremoto("6 de febrero de 2023, 01:17", 7.8, "Terremoto de Turqu??a y Siria 2023", "Turqu??a, Siria", "37??10???26???N 37??01???55???E", "40120"));

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnFiltro) {
            cogerFiltro();
        } else if (v.getId() == R.id.btnConsultar) {
            if (tvFiltroUsado.getText().toString().isEmpty()) {
                consultarTodos();
            } else {
                consultarConFiltrado();

            }
        }
    }

    private void consultarConFiltrado() {
        llm = new LinearLayoutManager(this);
        if (anio.trim().isEmpty() && pais.equals(TODOS_CAMPOS) && mes.equals(TODOS_CAMPOS)) {
            tAdapter = new TerremotoAdapter((ArrayList<Terremoto>) tDao.getAllOrderByMagnitud());
            if (tAdapter.getItemCount() == 0) {
                Toast.makeText(this, R.string.no_filtro, Toast.LENGTH_SHORT).show();
            }
        } else if (anio.trim().isEmpty() && pais.equals(TODOS_CAMPOS)) {
            tAdapter = new TerremotoAdapter((ArrayList<Terremoto>) tDao.getTerremotosByMes(mes));
            if (tAdapter.getItemCount() == 0) {
                Toast.makeText(this, R.string.no_filtro, Toast.LENGTH_SHORT).show();
            }
        } else if (mes.equals(TODOS_CAMPOS) && pais.equals(TODOS_CAMPOS)) {
            tAdapter = new TerremotoAdapter((ArrayList<Terremoto>) tDao.getTerremotosByAnio(anio));
            if (tAdapter.getItemCount() == 0) {
                Toast.makeText(this, R.string.no_filtro, Toast.LENGTH_SHORT).show();
            }
        } else if (mes.equals(TODOS_CAMPOS) && anio.trim().isEmpty()) {
            tAdapter = new TerremotoAdapter((ArrayList<Terremoto>) tDao.getTerremotosByPais(pais));
            if (tAdapter.getItemCount() == 0) {
                Toast.makeText(this, R.string.no_filtro, Toast.LENGTH_SHORT).show();
            }
        } else if (pais.equals(TODOS_CAMPOS)) {
            tAdapter = new TerremotoAdapter((ArrayList<Terremoto>) tDao.getTerremotosByMesAndAnio(mes, anio));
            if (tAdapter.getItemCount() == 0) {
                Toast.makeText(this, R.string.no_filtro, Toast.LENGTH_SHORT).show();
            }
        } else if (mes.equals(TODOS_CAMPOS) && !anio.trim().isEmpty()) {
            tAdapter = new TerremotoAdapter((ArrayList<Terremoto>) tDao.getTerremotosByAnioAndPais(anio, pais));
            if (tAdapter.getItemCount() == 0) {
                Toast.makeText(this, R.string.no_filtro, Toast.LENGTH_SHORT).show();
            }
        } else if (anio.trim().isEmpty()) {
            tAdapter = new TerremotoAdapter((ArrayList<Terremoto>) tDao.getTerremotosByMesAndPais(mes, pais));
            if (tAdapter.getItemCount() == 0) {
                Toast.makeText(this, R.string.no_filtro, Toast.LENGTH_SHORT).show();
            }
        } else if (mes.equals(TODOS_CAMPOS)) {
            tAdapter = new TerremotoAdapter((ArrayList<Terremoto>) tDao.getTerremotosByAnioAndPais(anio, pais));
            if (tAdapter.getItemCount() == 0) {
                Toast.makeText(this, R.string.no_filtro, Toast.LENGTH_SHORT).show();
            }
        } else {
            tAdapter = new TerremotoAdapter((ArrayList<Terremoto>) tDao.getTerremotosByMesAndAnioAndPais(mes, anio, pais));
            if (tAdapter.getItemCount() == 0) {
                Toast.makeText(this, R.string.no_filtro, Toast.LENGTH_SHORT).show();
            }
        }
        rvTerremotos.setLayoutManager(llm);
        rvTerremotos.setHasFixedSize(true);
        rvTerremotos.setAdapter(tAdapter);
    }

    private void cogerFiltro() {
        FiltroDialog dialog = new FiltroDialog();
        dialog.setCancelable(false);
        dialog.show(getSupportFragmentManager(), "FiltroDialog");
    }

    private void consultarTodos() {
        llm = new LinearLayoutManager(this);
        tAdapter = new TerremotoAdapter((ArrayList<Terremoto>) tDao.getAllOrderByMagnitud());
        rvTerremotos.setAdapter(tAdapter);
        rvTerremotos.setLayoutManager(llm);
        rvTerremotos.setHasFixedSize(true);
    }

    @Override
    public void onFiltroListener(String mes, String anio, String pais) {
        tvFiltroUsado.setText("Mes: " + mes + ".A??o: " + anio + ".Pa??s: " + pais);
        this.mes=mes;
        this.anio=anio;
        this.pais=pais;
    }

}