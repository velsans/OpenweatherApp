package com.vel.openweatherapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.weather_details.*
import timber.log.Timber

class OpenWeatherFragment : Fragment() {
    private val viewModel: OpenWeatherViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        ViewModelProvider(this, OpenWeatherViewModel.Factory(activity.application))
            .get(OpenWeatherViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.weatherList.observe(viewLifecycleOwner, { weatherList ->
            Timber.d("weatherList size :$weatherList")
            weatherList?.apply {
                cityText.text = weatherList.name + " " + weatherList.sys.country
                condDescr.text = weatherList.weather[0].main + " " + weatherList.weather[0].description
                temp.text = Math.round(weatherList.main.temp - 273.15).toString() + "�C"
                hum.text = weatherList.main.humidity.toString() + " %"
                press.text = weatherList.main.pressure.toString() + " hPa"
                windSpeed.text = weatherList.wind.speed.toString() + " mps"
                windDeg.text = weatherList.wind.deg.toString() + " mps"
            }
        })
        search_by_location.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    viewModel.refreshDataFromRepository(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                TODO("Not yet implemented")
                return false
            }

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.weather_details, container, false)
    }


}