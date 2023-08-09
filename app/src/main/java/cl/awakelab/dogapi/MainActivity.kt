package cl.awakelab.dogapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*
[] 2 pantallas: Listado y detalle
[x] Permiso de internet
[x] ViewBinding
[x] Dependencias: Coil, Room, Retrofit, navigation, viewModel
[x] navigation
[] Listado: RecyclerView + ViewHolder + Adapter
[] Detalle: RecyclerView + ViewHolder + Adapter
[x] Repositorio
[x] Remoto:
    [x] Dataclass
    [x] API (interfaz)
    [x] Retrofit
[x] Local:
    [x] Database
    [x] Entity
    [x] DAO
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}