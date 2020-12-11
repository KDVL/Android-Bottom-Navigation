package ch.kdvl.bottomExample

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ch.kdvl.bottomNavigation.SpaceItem
import ch.kdvl.bottomNavigation.SpaceNavigationView
import ch.kdvl.bottomNavigation.SpaceOnClickListener


class MainActivity : AppCompatActivity() {
    private lateinit var spaceNavigationView: SpaceNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        spaceNavigationView = findViewById<View>(R.id.nav_view) as SpaceNavigationView
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState)
        spaceNavigationView.addSpaceItem(SpaceItem("", R.drawable.ic_tab_events))
        spaceNavigationView.addSpaceItem(SpaceItem("", R.drawable.ic_tab_search))
        spaceNavigationView.addSpaceItem(SpaceItem("", R.drawable.ic_tab_favorites))
        spaceNavigationView.addSpaceItem(SpaceItem("", R.drawable.ic_tab_more))
        spaceNavigationView.setCentreButtonSelectable(true)
        spaceNavigationView.showIconOnly()
        spaceNavigationView.setInitalSelectedItem(-1)

        spaceNavigationView.setSpaceOnClickListener(object : SpaceOnClickListener {
            override fun onCentreButtonClick() {
                Toast.makeText(this@MainActivity, "onCentreButtonClick", Toast.LENGTH_SHORT).show()
            }

            override fun onItemClick(itemIndex: Int, itemName: String) {
                Toast.makeText(
                    this@MainActivity,
                    "$itemIndex $itemName",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onItemReselected(itemIndex: Int, itemName: String) {
                Toast.makeText(
                    this@MainActivity,
                    "$itemIndex $itemName",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

    }
}