package ahmedpro.com.cuerrencyconverter

import ahmedpro.com.cuerrencyconverter.data.models.RateModel
import ahmedpro.com.cuerrencyconverter.databinding.RateItemListBinding
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.lang.String.format
import java.util.*
import kotlin.collections.ArrayList

class RatesAdapter : RecyclerView.Adapter<RatesAdapter.MyViewHolder>() {
    private var models = ArrayList<RateModel>()
    private var listener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(rateModel: RateModel?)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.rate_item_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val model = models[position]
        holder.binding.tvCurrencyName.text = model.currencyName
        holder.binding.tvCurrencyrate.text = format(
            Locale.getDefault(),
            "%.02f",
            model.rate
        )
    }

    fun setRates(models: ArrayList<RateModel>) {
        this.models = models
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = RateItemListBinding.bind(itemView)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener!!.onItemClick(models[position])
                }
            }
        }
    }
}