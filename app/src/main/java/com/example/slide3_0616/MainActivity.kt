package com.example.slide3_0616

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_pager.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 여기에 필터링 코드 들어가야함.


        pager.adapter = PagerRecyclerAdapter(MenuData.values())
        pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Toast.makeText(baseContext, "onPageSelected", Toast.LENGTH_SHORT).show()
            }
        })
    }
    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menu?.removeGroup(Menu.NONE)
        if (pager.adapter is PagerRecyclerAdapter) {
            menu?.add(Menu.NONE, MENU_ID_FRAGMENT_ADAPTER, Menu.NONE, "FragmentStateAdapter Vertical")
        } else {
            menu?.add(Menu.NONE, MENU_ID_RECYCLER_ADAPTER, Menu.NONE, "RecyclerViewAdapter Horizontal")
        }
        menu?.add(Menu.NONE, MENU_ID_ADD_ITEM, Menu.NONE, "Add New Item")
        return super.onPrepareOptionsMenu(menu)
    }
/**
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            MENU_ID_RECYCLER_ADAPTER, MENU_ID_FRAGMENT_ADAPTER -> updateAdapter(item.itemId)
            MENU_ID_ADD_ITEM -> addNewItem()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun updateAdapter(type: Int) {
        if (type == MENU_ID_RECYCLER_ADAPTER) {
            pager.adapter = PagerRecyclerAdapter(MenuData.values())
            pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }/** else {
        pager.adapter = PagerFragmentStateAdapter(bgColors, supportFragmentManager)
        pager.orientation = ViewPager2.ORIENTATION_VERTICAL
        }*/
        invalidateOptionsMenu()
    }

    private fun addNewItem() {
        val newBgColor = intArrayOf(
                android.R.color.holo_green_dark,
                android.R.color.holo_purple,
                android.R.color.darker_gray,
                android.R.color.black
        ).random()
        MenuData.values().add(newBgColor)
        pager.adapter?.notifyDataSetChanged()
    }
*/
    companion object {
        private const val MENU_ID_RECYCLER_ADAPTER = 100
        private const val MENU_ID_FRAGMENT_ADAPTER = 101
        private const val MENU_ID_ADD_ITEM = 103
    }
}