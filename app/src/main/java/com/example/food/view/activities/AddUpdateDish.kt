package com.example.food.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.food.R
import com.example.food.databinding.ActivityAddDishBinding

class AddUpdateDish : AppCompatActivity() {
    private lateinit var mBinding:ActivityAddDishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding= ActivityAddDishBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        setUpActionBar()
    }
    //implementing the backButton on toolbar
    private  fun setUpActionBar(){
        setSupportActionBar(mBinding.toolbarAddDishActivity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mBinding.toolbarAddDishActivity.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}