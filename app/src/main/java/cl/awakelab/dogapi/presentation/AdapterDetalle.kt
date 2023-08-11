package cl.awakelab.dogapi.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.awakelab.dogapi.data.local.RazaDetalleEntity
import cl.awakelab.dogapi.databinding.ItemDetalleLayoutBinding
import coil.load

class AdapterDetalle: RecyclerView.Adapter<AdapterDetalle.DetalleViewHolder>() {

    lateinit var binding: ItemDetalleLayoutBinding
    private val listDetalle = mutableListOf<RazaDetalleEntity>()
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetalleViewHolder {
        binding = ItemDetalleLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
         return DetalleViewHolder(binding)
     }

     override fun getItemCount(): Int {
        return listDetalle.size

     }

     override fun onBindViewHolder(holder: DetalleViewHolder, position: Int) {
        val perro = listDetalle[position]
         holder.bind(perro)
     }
    fun setDataDetalle(detalle : List<RazaDetalleEntity>){
        this.listDetalle.clear()
        this.listDetalle.addAll(detalle)
        notifyDataSetChanged()
    }

    class DetalleViewHolder(val perrovista: ItemDetalleLayoutBinding): RecyclerView.ViewHolder(perrovista.root){
        fun bind(detalle: RazaDetalleEntity){
            perrovista.imageDogsDetail.load(detalle.url)
        }
    }

 }