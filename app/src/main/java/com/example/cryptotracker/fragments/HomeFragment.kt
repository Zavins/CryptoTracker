package com.example.cryptotracker.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.cryptotracker.R
import com.example.cryptotracker.adapters.CryptosAdapter
import com.example.cryptotracker.models.Crypto
import com.example.cryptotracker.network.RestClient

class HomeFragment : Fragment() {
    lateinit var restClient:RestClient
    lateinit var adapter: CryptosAdapter
    lateinit var rvCrypto: RecyclerView
    lateinit var scCrypto: SwipeRefreshLayout
    lateinit var previousButton: ActionMenuItemView;
    lateinit var nextButton: ActionMenuItemView;
    lateinit var pageText: TextView;
//    lateinit var svCrypto: SearchView
    private var pageNumber = 1
    private val cryptos = ArrayList<Crypto>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        restClient = RestClient()
        adapter = CryptosAdapter(cryptos)
        rvCrypto = requireView().findViewById<RecyclerView>(R.id.rvCrypto)
        rvCrypto.layoutManager = LinearLayoutManager(activity)
        rvCrypto.adapter = adapter
        scCrypto = requireView().findViewById<SwipeRefreshLayout>(R.id.scCrypto)
        scCrypto.setOnRefreshListener {
            populateCryptos()
        }
//        svCrypto = requireView().findViewById<SearchView>(R.id.svCrypto)

        previousButton = requireView().findViewById<ActionMenuItemView>(R.id.action_previous)
        nextButton = requireView().findViewById<ActionMenuItemView>(R.id.action_next)

        previousButton.setOnClickListener {
            pageNumber -= 1
            if (pageNumber <= 1) {
                pageNumber = 1
            }
            populateCryptos()
            updatePageText()
        }

        nextButton.setOnClickListener {
            pageNumber += 1
            if (pageNumber > 100){
                pageNumber = 100
            }
            populateCryptos()
            updatePageText()
        }

        scCrypto.setColorSchemeResources(
            android.R.color.holo_blue_bright,
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light
        )

//        svCrypto.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String): Boolean {
//                searchCrypto(query)
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String): Boolean {
//                return false
//            }
//        })
        populateCryptos()

    }

    fun updatePageText(){
        pageText = requireView().findViewById<TextView>(R.id.pageNum)
        pageText.text = "Page: " + pageNumber.toString()
    }

    fun populateCryptos(){
        try{
            restClient.getCryptoInfoList(pageNumber) { cryptoList: ArrayList<Crypto> ->
                adapter.clear()
                adapter.addAll(cryptoList)
                adapter.notifyDataSetChanged()
                scCrypto.setRefreshing(false);
            }
        }catch (e: Error){
            Log.e("Home Fragment Error", "Error in populating cryptos, " + e.toString())
        }
    }

//    fun searchCrypto(query: String){
//        //Do Search
//    }

}