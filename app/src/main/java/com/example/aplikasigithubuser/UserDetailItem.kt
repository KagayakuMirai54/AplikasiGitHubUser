package com.example.aplikasigithubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aplikasigithubuser.databinding.ActivityUserDetailItemBinding

class UserDetailItem : AppCompatActivity() {
    companion object {
        const val EXTRA_USER = "extra_user"
    }
    private lateinit var binding: ActivityUserDetailItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail_item)
        supportActionBar?.title = "Detail User"

        val data = intent.extras?.getParcelable<User>(EXTRA_USER)

        val name = data?.name
        val avatar = data?.avatar
        val company = data?.company
        val location = data?.location
        val repository = data?.repository
        val following = data?.following
        val followers = data?.followers
        val username = data?.username
        binding = ActivityUserDetailItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvUssername.text = username
        binding.tvCompanyDetailuser.text = company
        binding.tvNamaDetailuser.text = name
        binding.tvAddressDetailuser.text = location
        binding.tvRepository.text = repository
        binding.tvFollowers.text = followers
        binding.tvFollowing.text = following


        if (avatar!=null)
            binding.imgDetailUser.setImageResource(avatar)
    }
}