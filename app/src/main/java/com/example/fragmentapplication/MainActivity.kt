package com.example.fragmentapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.setFragmentResultListener
import com.example.fragmentapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInput.setOnClickListener {
            val fragment = supportFragmentManager.beginTransaction().run {
                val fragment = InputFragment()
                replace(binding.frmFragment.id, fragment)
                commit()
                fragment
            }
            fragment.setFragmentResultListener("value") { key, bundle ->

            }
        }

        binding.btnMax.setOnClickListener {
            supportFragmentManager.beginTransaction().run {
                replace(binding.frmFragment.id, ResultFragment.newInstance(1))
                commit()
            }
        }

        binding.btnSum.setOnClickListener {
            supportFragmentManager.beginTransaction().run {
                replace(binding.frmFragment.id, ResultFragment.newInstance(2))
                commit()
            }
        }

        }
    }