package ch.kdvl.bottomExample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ch.kdvl.bottomNavigation.SpaceNavigationView
import ch.kdvl.bottomNavigation.SpaceItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val spaceNavigationView = findViewById<View>(R.id.nav_view) as SpaceNavigationView
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState)
        spaceNavigationView.addSpaceItem(SpaceItem("HOME", R.drawable.ic_home_black_24dp))
        spaceNavigationView.addSpaceItem(SpaceItem("SEARCH", R.drawable.ic_notifications_black_24dp))
        spaceNavigationView.setCentreButtonSelectable(true)
        spaceNavigationView.showIconOnly()
    }
}