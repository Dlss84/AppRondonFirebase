package sebastiani.app_rondon.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import kotlinx.android.synthetic.*
import sebastiani.app_rondon.R

class MenuHomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu_home, container, false)
        val imageSlider = view.findViewById<ImageSlider>(R.id.imageSlider)
        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel("https://lh3.googleusercontent.com/p/AF1QipP7-49bkrIAym3tUB1bH7yMJ99zhddDkul9CDwu=s300-w300", "Buena Infraestructura"))
        imageList.add(SlideModel("https://lh3.googleusercontent.com/p/AF1QipOjVbZvUf4Pgp2QUBakHg8kQJUgIbMkchuXRRCU=s300-w300", "Ambiente agradable"))
        imageList.add(SlideModel("https://diariocorreo.pe/resizer/m2oSlkmmkVcOqahh99EJE0DOJBQ=/1200x1200/smart/filters:format(jpeg):quality(75)/arc-anglerfish-arc2-prod-elcomercio.s3.amazonaws.com/public/3UZNAP4LKREO3P4A4IMIFNW65Q.jpg", "Servicio de Calidad"))
        //imageList.add(SlideModel(R.drawable.image1))
        //imageList.add(SlideModel(R.drawable.image2))
        //imageList.add(SlideModel(R.drawable.image3))

        imageSlider.setImageList(imageList, ScaleTypes.FIT)
        return view
    }

    /*
    private fun sliderView() {
        val imageSlider = view?.findViewById<ImageSlider>(R.id.imageSlider2)
        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel(R.drawable.imagen1))
        imageList.add(SlideModel(R.drawable.imagen2))
        imageList.add(SlideModel(R.drawable.imagen3))

        imageSlider?.setImageList(imageList, ScaleTypes.FIT)

    }
     */
}

