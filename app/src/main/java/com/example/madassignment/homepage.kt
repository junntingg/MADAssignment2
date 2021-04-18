package com.example.madassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.madassignment.fragment.CheckIn
import com.example.madassignment.fragment.HomePage
import com.example.madassignment.fragment.Reservation
import kotlinx.android.synthetic.main.activity_homepage.*

class homepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        supportActionBar?.hide()

        val homePage = HomePage()
        val reservation = Reservation()
        val checkIn = CheckIn()

        makeCurrentFragment(homePage)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.ic_home -> makeCurrentFragment(homePage)
                R.id.ic_checkin -> makeCurrentFragment(checkIn)
                R.id.ic_Reservation -> makeCurrentFragment(reservation)
            }
            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wraper, fragment)
            commit()
        }


    fun sendMessage(view: View){
        val intent = Intent(this, reservationList::class.java)

        startActivity(intent)
    }
}