package com.nxt.testlivedata3.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nxt.testlivedata3.Click.Click
import com.nxt.testlivedata3.R
import com.nxt.testlivedata3.activity.WebView
import com.nxt.testlivedata3.adapter.Adapter
import com.nxt.testlivedata3.api.RetroInstance
import com.nxt.testlivedata3.api.RetroService
import com.nxt.testlivedata3.model.Data
import com.nxt.testlivedata3.model.DataInfo
import kotlinx.android.synthetic.main.layout_viewpager.view.*
import retrofit2.Call
import retrofit2.Response

class HomeFragment : Fragment(), Click {

    private var adapterHome: Adapter? = null
    private var listDataHome: ArrayList<DataInfo>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.layout_viewpager, container, false)
            var rvHome = view.rv_app
            rvHome.layoutManager = LinearLayoutManager(context)
            rvHome.adapter = adapterHome
            createData()

        return view
    }

    private fun createData() {
        //tao trinh giao dien
        RetroInstance.getInstance().create(RetroService::class.java)
            .getNews("us", 100, RetroInstance.API_KEY)
                //Goi Data de nhan phan hoi
            .enqueue(object : retrofit2.Callback<Data> {
                override fun onResponse(call: Call<Data>, response: Response<Data>) {

                    Log.d("aaa", response.body().toString())

                    listDataHome?.clear()
                    listDataHome?.addAll(response.body()?.articles!!)
                    adapterHome?.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<Data>, t: Throwable) {

                }

            })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listDataHome = ArrayList()
        adapterHome = Adapter(listDataHome!!, this)
    }

    override fun onClick(position: Int) {

        val url = listDataHome!![position].url
        val intent = Intent(activity, WebView::class.java)

        intent.putExtra("url", url)
        startActivity(intent)
    }
}