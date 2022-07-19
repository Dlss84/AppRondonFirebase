package sebastiani.app_rondon.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_contactenos.*
import sebastiani.app_rondon.R

class ContactenosFragment : Fragment(), OnMapReadyCallback {

    private lateinit var googleMap: GoogleMap

    override fun onActivityCreated(savedInstanceState: Bundle?){
        super.onActivityCreated(savedInstanceState)

        map_view.onCreate(savedInstanceState)
        map_view.onResume()

        map_view.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        map.let{
            googleMap = it
        }
        createMarker()
    }

    private fun createMarker(){
        val coordinates = LatLng(-12.120173510316851, -76.9975013644179)
        val marker= MarkerOptions().position(coordinates).title("Veterinaria Rondon")
        googleMap.addMarker(marker)
        googleMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            5000,
            null
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contactenos, container, false)

    }




}