package com.example.aplikasigithubuser

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvPeople: RecyclerView
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.title = getString(R.string.GithubUser)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvPeople = findViewById(R.id.rv_people)
        rvPeople.setHasFixedSize(true)
        list.addAll(listUser)
        showRecyclerList()
    }

    private val listUser: ArrayList<User>
        get() {
            val dataName = resources.getStringArray(R.array.name)
            val dataUsername = resources.getStringArray(R.array.username)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val dataAvatar = resources.obtainTypedArray(R.array.avatar)
            val listUser = ArrayList<User>()
            for (i in dataName.indices) {
                val user = User(
                    dataName[i],
                    dataUsername[i],
                    dataLocation[i],
                    dataCompany[i],
                    dataRepository[i],
                    dataFollowers[i],
                    dataFollowing[i],
                    dataAvatar.getResourceId(i, -1))
                listUser.add(user)
            }
            dataAvatar.recycle()
            return listUser
        }
    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvPeople.layoutManager = GridLayoutManager(this, 3)
        } else {
            rvPeople.layoutManager = LinearLayoutManager(this)
        }
        val listUserAdapter = ListUserAdapter(list)
        rvPeople.adapter = listUserAdapter
        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                showSelectedUser(data)
                println("You Click Me")
                val intent = Intent(this@MainActivity, UserDetailItem::class.java)
                intent.putExtra(UserDetailItem.EXTRA_USER, data)
                startActivity(intent)
            }
        })
    }
    private fun showSelectedUser(user: User) {
        Toast.makeText(this, "Kamu memilih " + user.name, Toast.LENGTH_SHORT).show()
    }

}