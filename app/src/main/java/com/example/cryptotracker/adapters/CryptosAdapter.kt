package com.example.cryptotracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptotracker.R
import com.example.cryptotracker.models.Crypto
import com.example.cryptotracker.utilities.LoadSVG


class CryptosAdapter(val cryptos: ArrayList<Crypto>):RecyclerView.Adapter<CryptosAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        //inflate item layout
        val view = inflater.inflate(R.layout.item_crypto, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val crypto: Crypto = cryptos.get(position)
        holder.tvCryptoName.text = crypto.currency
        holder.tvCryptoPrice.text = String.format("$%.5f", crypto.price)
        holder.tvCryptoChangePct.text = String.format("%.2f%%", crypto.oneDay?.priceChangePct?.toDouble()!! * 100)
        LoadSVG.loadSvg(holder.ivCryptoImage, crypto.logoURL!!)
    }

    override fun getItemCount(): Int {
        return cryptos.size
    }

    fun clear(){
        cryptos.clear()
        notifyDataSetChanged()
    }

    fun addAll(cryptos: ArrayList<Crypto>){
        this.cryptos.addAll(cryptos)
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val ivCryptoImage = itemView.findViewById<ImageView>(R.id.cryptoLogo)
        val tvCryptoName = itemView.findViewById<TextView>(R.id.cryptoName)
        val tvCryptoPrice= itemView.findViewById<TextView>(R.id.cryptoPrice)
        val tvCryptoChangePct = itemView.findViewById<TextView>(R.id.cryptoChangePercentage)
    }
}