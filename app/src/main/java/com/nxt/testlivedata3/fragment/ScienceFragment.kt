package com.nxt.testlivedata3.fragment

import android.content.Intent
import android.os.Bundle
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

class ScienceFragment : Fragment(), Click {

    private var listDataScience: ArrayList<DataInfo>? = null
    private var adapterScience: Adapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.layout_viewpager, container, false)

        var rvScience = view.rv_app
        rvScience.adapter = adapterScience
        rvScience.layoutManager = LinearLayoutManager(context)

        createData()


        return view
    }

    private fun createData() {
        RetroInstance.getInstance().create(RetroService::class.java)
            .getCategoryNews("us", "science", 100, RetroInstance.API_KEY)
            .enqueue(object : retrofit2.Callback<Data> {
                override fun onResponse(call: Call<Data>, response: Response<Data>) {
                    listDataScience?.clear()
                    listDataScience?.addAll(response.body()?.articles!!)
                    adapterScience?.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<Data>, t: Throwable) {

                }
            })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        listDataScience = ArrayList()
        adapterScience = Adapter(listDataScience!!, this)
    }

    override fun onClick(position: Int) {
        val url = listDataScience!![position].url

        val intent = Intent(activity, WebView::class.java)
        intent.putExtra("url", url)
        startActivity(intent)
    }
}