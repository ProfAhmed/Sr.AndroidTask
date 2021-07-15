package ahmedpro.com.cuerrencyconverter

import ahmedpro.com.cuerrencyconverter.databinding.ActivityConvertBinding
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ConvertActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConvertBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConvertBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val name = intent.getStringExtra("name")
        binding.tvTarget.text = name

    }

    fun calc(view: View) {
        val rate = intent.getDoubleExtra("rate", 1.0)
        val input = binding.etBase.text.toString().toDouble()
        val result = input * rate
        binding.etTarget.setText(
            String.format(
                java.util.Locale.getDefault(),
                "%.02f",
                result
            )
        )
    }
}