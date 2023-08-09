package cl.awakelab.dogapi.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import cl.awakelab.dogapi.R
import cl.awakelab.dogapi.data.local.RazaEntity
import cl.awakelab.dogapi.databinding.ItemLayoutBinding

class AdapterRaza : RecyclerView.Adapter<AdapterRaza.ViewHolder>() {

    private lateinit var binding: ItemLayoutBinding
    private val listItemRazas = mutableListOf<RazaEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItemRazas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val raza = listItemRazas[position]
        holder.bind(raza)
    }

    fun setData(razas: List<RazaEntity>) {
        this.listItemRazas.clear()
        this.listItemRazas.addAll(razas)
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(razaEntity: RazaEntity) {
            binding.textItem.text = razaEntity.raza
            binding.cardViewItem.setOnClickListener{
                Navigation.findNavController(binding.root).navigate(R.id.action_listFragment_to_detailFragment)
            }
        }

    }
}