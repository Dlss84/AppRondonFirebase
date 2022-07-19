package sebastiani.app_rondon.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sebastiani.app_rondon.R

class ServiciosFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //var rootView: View = inflater.inflate(R.layout.fragment_servicios, container, false)
        //return rootView
        return inflater.inflate(R.layout.fragment_servicios, container, false)
    }

}