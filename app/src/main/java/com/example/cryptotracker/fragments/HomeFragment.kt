package com.example.cryptotracker.fragments

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.cryptotracker.R
import com.example.cryptotracker.adapters.CryptosAdapter
import com.example.cryptotracker.models.Crypto
import com.example.cryptotracker.network.RestClient
import java.util.*
import kotlin.collections.ArrayList


class HomeFragment : Fragment() {
    lateinit var restClient:RestClient
    lateinit var rvCrypto: RecyclerView
    lateinit var adapter: CryptosAdapter
 lateinit var swipecontainer: SwipeRefreshLayout
    private var pageNumber = 1
    private var loaded = false
    private val cryptos = ArrayList<Crypto>()
    private lateinit var templateArrayList: ArrayList<Crypto>
  override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        templateArrayList= arrayListOf<Crypto>()
        restClient = RestClient()
        swipecontainer = requireView().findViewById(R.id.swipeContainer)
        swipecontainer.setOnRefreshListener {
            // Toast.makeText(context,"Working I guess",Toast.LENGTH_SHORT).show()
            populateCryptos()
        }
        rvCrypto = requireView().findViewById<RecyclerView>(R.id.rvCrypto)
        adapter = CryptosAdapter(cryptos)
        rvCrypto.layoutManager = LinearLayoutManager(activity)
        rvCrypto.adapter = adapter
        if (!loaded) {
            populateCryptos()
            loaded = true
        }


    }

    fun OnCreateOptionsMenu(menu: Menu?, inflater: MenuInflater): Boolean {
        inflater.inflate(R.menu.menu, menu)
        val item= menu?.findItem(R.id.action_Search)
        val searchView=item?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
              //DO("Not yet implemented")
                Toast.makeText(context,"Not working",Toast.LENGTH_SHORT).show()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                templateArrayList.clear()
                val searchText= newText!!.toLowerCase(Locale.getDefault())
                if(searchText.isNotEmpty()){
                    cryptos.forEach{
                      if (it.name.toLowerCase(Locale.getDefault()).contains(searchText)){
                          templateArrayList.add(it)

                      }
                    }

                rvCrypto.adapter!!.notifyDataSetChanged()



                }else{
                    templateArrayList.clear()
                    templateArrayList.addAll(cryptos)
                    rvCrypto.adapter!!.notifyDataSetChanged()

                }
                return false
            }

        })
        return true
    }


    fun populateCryptos(){
        if (!loaded){
           // adapter.clear()
            restClient.getCryptoInfoList(pageNumber) { cryptoList: List<Crypto> ->
                cryptos.addAll(cryptoList)
                adapter.notifyDataSetChanged()
              templateArrayList.addAll(cryptos)
}
        }
        swipecontainer.setRefreshing(false);
    }




}

