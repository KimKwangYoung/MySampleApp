 package com.kky.mysampleapp.activity
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.core.view.ViewCompat
import com.google.android.material.appbar.AppBarLayout
import com.kky.mysampleapp.MyApplication.Companion.TAG
import com.kky.mysampleapp.R
import com.kky.mysampleapp.databinding.ActivityCoordinatorLayoutBinding
import java.lang.Math.abs

class CoordinatorLayoutActivity : AppCompatActivity() {
    var icon: Drawable? = null
    private val colorWhite = -0xFFFFFF

    val binding: ActivityCoordinatorLayoutBinding by lazy {
        ActivityCoordinatorLayoutBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener { finish() }

        setSupportActionBar(binding.toolbar)

        setFullScreen()
        initView()
    }

    private fun initView() = with(binding) {
        icon = binding.toolbar.navigationIcon
        appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            Log.d(TAG, "${appBarLayout.measuredHeight} / ${appBarLayout.totalScrollRange} / $verticalOffset")
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun setFullScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.setSystemBarsAppearance(WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS, WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS)
        } else {
            @Suppress("DEPRECATION")
            window?.apply {
                clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }
    }


}