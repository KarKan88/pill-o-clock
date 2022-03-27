package com.example.pilloclock

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.pilloclock.data.AppDatabase
import com.example.pilloclock.data.entity.Pill
import com.example.pilloclock.data.repo.PillRepository

class MedicationList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medication_list)

       //val pillDao = AppDatabase.getDatabase(this.application).pillDao()
        //val pillList = pillDao.getAll()

        val pill = Pill(
            1, "Med 1", "Prozac", "10AM", "Mon, Tue, Wed", "blue_pill",
            "20/10/22", "22/11/22", "10Mg", 66.0, true, "27/03/22",
            "", "", ""
        )

        val pill2 = Pill(
            1, "Med 2", "Aspirin", "10AM", "Mon, Tue, Wed", "pink_pill",
            "20/10/22", "22/11/22", "10Mg", 66.0, false,  "27/03/22",
            "", "", ""
        )

        val pillList = listOf(pill, pill2)

        val listView = findViewById<ListView>(R.id.medicationView)

        val resources = resources
        listView.adapter = MedicationListAdapter(this, pillList, resources, packageName)

        listView.setOnItemClickListener {parent, view, position, id ->
            val intent = Intent(this, ViewDetails::class.java)
            intent.putExtra("Position", position)
            startActivity(intent)
        }
    }

    private class MedicationListAdapter(context: Context, pillList: List<Pill>, resources: Resources, packageName: String): BaseAdapter() {
        private val mContext: Context = context
        private val mPillList: List<Pill> = pillList
        private val mResources: Resources = resources
        private val mPackageName: String = packageName

        override fun getCount(): Int {
            return mPillList.size
        }

        override fun getItem(p0: Int): Any {
           return ""
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val layoutInflator = LayoutInflater.from(mContext)
            val med_list = layoutInflator.inflate(R.layout.medication_list_item, p2, false)
            val currItem = mPillList.get(p0)

            val nameTextView = med_list.findViewById<TextView>(R.id.medName)
            nameTextView.text = currItem.name

            val brandTextView = med_list.findViewById<TextView>(R.id.medBrandText)
            brandTextView.text = currItem.brand

            val datesTextView = med_list.findViewById<TextView>(R.id.datesText)
            datesTextView.text = "${currItem.startDate} - ${currItem.endDate}"

            val uri = """drawable/${currItem.icon}"""
            val imageResource = mResources.getIdentifier(uri, null, mPackageName)
            val res = mResources.getDrawable(imageResource, null)
            val iconImageView = med_list.findViewById<ImageView>(R.id.iconImage)
            iconImageView.setImageDrawable(res)
            return med_list
        }

    }
}