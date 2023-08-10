package cl.awakelab.dogapi.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.awakelab.dogapi.R
import cl.awakelab.dogapi.databinding.FragmentDetailBinding
import cl.awakelab.dogapi.databinding.FragmentListBinding

private const val ARG_PARAM1 = "id"

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val razaViewModel: RazaViewModel by activityViewModels()

    private var param1: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailBinding.inflate(layoutInflater,container, false)
        initAdapter()
        razaViewModel.getDetallePerroVM((param1.toString()))
        binding.rvDetail.setOnClickListener{
            razaViewModel.getAllRazas()
        }
        return binding.root
    }

    private fun initAdapter() {


    }
}