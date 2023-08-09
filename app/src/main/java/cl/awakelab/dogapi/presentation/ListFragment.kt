package cl.awakelab.dogapi.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.awakelab.dogapi.databinding.FragmentListBinding


class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding
    private val razaViewModel: RazaViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        initAdapter()
        razaViewModel.getAllRazas()
        return binding.root
    }

    private fun initAdapter() {

        val adapter = AdapterRaza()
        binding.rvListado.adapter = adapter
        razaViewModel.razasLiveData().observe(viewLifecycleOwner) {
            adapter.setData(it)
        }

    }

}