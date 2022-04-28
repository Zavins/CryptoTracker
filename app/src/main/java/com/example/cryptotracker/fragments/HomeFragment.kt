package com.example.cryptotracker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptotracker.R
import com.example.cryptotracker.adapters.CryptosAdapter
import com.example.cryptotracker.models.Crypto
import com.example.cryptotracker.network.RestClient

class HomeFragment : Fragment() {
    lateinit var restClient:RestClient
    lateinit var rvCrypto: RecyclerView
    lateinit var adapter: CryptosAdapter

    private var pageNumber = 1
    private var loaded = false
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

        rvCrypto = requireView().findViewById<RecyclerView>(R.id.rvCrypto)
        adapter = CryptosAdapter(cryptos)
        rvCrypto.layoutManager = LinearLayoutManager(activity)
        rvCrypto.adapter = adapter
        if (!loaded){
            populateCryptos()
            loaded = true
        }


    }

    fun populateCryptos(){
        if (!loaded){
            restClient.getCryptoInfoList(pageNumber) { cryptoList: List<Crypto> ->
                cryptos.addAll(cryptoList)
                adapter.notifyDataSetChanged()
            }
        }
    }

}