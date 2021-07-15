package ahmedpro.com.cuerrencyconverter

import ahmedpro.com.cuerrencyconverter.data.api.ApiClient
import ahmedpro.com.cuerrencyconverter.data.api.ApiService
import ahmedpro.com.cuerrencyconverter.data.models.RateModel
import ahmedpro.com.cuerrencyconverter.databinding.ActivityMainBinding
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        callLatestApi()

    }

    private fun callLatestApi() {
        val apiService = ApiClient.apiClient().create(ApiService::class.java)
        val ratesAdapter = RatesAdapter()
        binding.rvRates.adapter = ratesAdapter
        binding.rvRates.addItemDecoration(
            DividerItemDecoration(
                binding.rvRates.context,
                DividerItemDecoration.VERTICAL
            )
        )

        GlobalScope.launch {
            val param = HashMap<String, String>()
            param["access_key"] = ApiClient.API_KEY
            param["base"] = ApiClient.BASE_CURRENCY
            val latestModel = apiService.latest(param)
            if (latestModel.success) {
                Log.d("LatestModel", latestModel.toString())
                val listRates = ArrayList<RateModel>()
                latestModel.rates.forEach { (key, value) ->
                    val rateModel = RateModel(key, value)
                    listRates.add(rateModel)
                }
                withContext(Dispatchers.Main) {
                    ratesAdapter.setRates(listRates)
                    ratesAdapter.setOnItemClickListener(object : RatesAdapter.OnItemClickListener {
                        override fun onItemClick(rateModel: RateModel?) {
                            startActivity(
                                Intent(this@MainActivity, ConvertActivity::class.java)
                                    .putExtra("name", rateModel?.currencyName)
                                    .putExtra("rate", rateModel?.rate)
                            )
                        }
                    })
                    binding.progressCircular.visibility = View.GONE
                }
            } else {
                Toast.makeText(this@MainActivity, "An error ", Toast.LENGTH_LONG).show()
            }
        }
    }

}