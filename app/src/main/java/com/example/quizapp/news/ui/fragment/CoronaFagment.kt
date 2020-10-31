package com.example.quizapp.news

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.load.engine.Resource
import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentNewsBinding
import com.example.quizapp.db.AppDataBase
import com.example.quizapp.news.data.local.CoronaLocalDataSource
import com.example.quizapp.news.data.modelfromservice.AllCountryItem
import com.example.quizapp.news.data.remote.CoronaRemoteDataSource
import com.example.quizapp.news.data.repository.CoronaRepository
import com.example.quizapp.news.ui.ClickListener
import com.example.quizapp.news.ui.adapter.CoronaListAdapter
import com.example.quizapp.news.ui.viewmodel.CoronaViewModel
import com.example.quizapp.news.ui.viewmodel.CoronaViewModelProviderFactory
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_news.*

@AndroidEntryPoint
class CoronaFagment : Fragment() ,ClickListener{

    private lateinit var binding: FragmentNewsBinding
    private  val viewModel: CoronaViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      binding=  DataBindingUtil.inflate(inflater, R.layout.fragment_news,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)






        viewModel.allInformation.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is com.example.quizapp.util.Resource.Success -> {
                    response.data?.let{result->
                        binding.allInformation=result
                    }
                }
                is com.example.quizapp.util.Resource.Loading -> {

                }
                is com.example.quizapp.util.Resource.Error -> {

                   var scnak= Snackbar.make(requireView(),"${response.message}",Snackbar.LENGTH_SHORT)
                   var view= scnak.view
                    view.setBackgroundColor(Color.RED)
                }
            }

        })


        setUpRecyclerView()
        viewModel.allCountry.observe(viewLifecycleOwner, Observer {response->
            when(response){
                is com.example.quizapp.util.Resource.Success->{
                    setUpRecyclerView()

                    recyclerView.adapter?.notifyDataSetChanged()

                    Toast.makeText(requireContext(),"obser",Toast.LENGTH_SHORT).show()
                }
                is com.example.quizapp.util.Resource.Error->{

                }
            }

        })
    }

    fun setUpRecyclerView(){

      viewModel.allCountry.value?.data?.let {
          recyclerView.adapter= CoronaListAdapter(it,this@CoronaFagment) }
    }

    override fun onCardClick( allCountryItem:AllCountryItem) {

        findNavController().navigate(CoronaFagmentDirections.actionNewsFagmentToSingleCountryFragment(allCountryItem))
    }
}