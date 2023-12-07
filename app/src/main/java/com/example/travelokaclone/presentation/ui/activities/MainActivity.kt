package com.example.travelokaclone.presentation.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.travelokaclone.R
import com.example.travelokaclone.databinding.ActivityMainBinding
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        binding = ActivityMainBinding.inflate(layoutInflater)
        val toolbar = binding.layoutToolbar.toolbar as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.title = null
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerMain) as NavHostFragment
        navController = navHostFragment.navController

        //set Rounded Bottom Navigation Background
        val bottomNavigationView = binding.bottomNavView
        val radius = resources.getDimension(R.dimen.bottom_nav_corner)
        val bottomNavigationBackground = bottomNavigationView.background as MaterialShapeDrawable
        bottomNavigationBackground.shapeAppearanceModel = bottomNavigationBackground.shapeAppearanceModel.toBuilder().apply {
            setAllCorners(CornerFamily.ROUNDED, radius)
        }.build()

        bottomNavigationView.setupWithNavController(navController)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.action_bar_main_menu, menu)
        return true
    }
}