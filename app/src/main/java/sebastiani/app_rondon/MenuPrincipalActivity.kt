package sebastiani.app_rondon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination

import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView



class MenuPrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        val drawarlayout = findViewById<DrawerLayout>(R.id.drawarLayout)
        val imgMenu = findViewById<ImageView>(R.id.imgMenu)

        val navView = findViewById<NavigationView>(R.id.navDawar)
        navView.itemIconTintList=null
        imgMenu.setOnClickListener{
            drawarlayout.openDrawer(GravityCompat.START)
        }

        val navController=Navigation.findNavController(this, R.id.fragment)
            NavigationUI.setupWithNavController(navView, navController)

        val textTitle=findViewById<TextView>(R.id.title)
        navController
            .addOnDestinationChangedListener { controller, destination, arguments ->
                textTitle.text = destination.label
            }

    }
}