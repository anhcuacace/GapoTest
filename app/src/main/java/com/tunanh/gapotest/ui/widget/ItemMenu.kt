package com.tunanh.gapotest.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.tunanh.gapotest.R

class ItemMenu(context: Context?, attrs: AttributeSet?) : RelativeLayout(context, attrs) {
    private var itemImg: ImageView? = null
    private var imageView: ImageView? = null
    private var countNoty: TextView? = null
    private var checkBar: ImageView? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_item, this, true)
        itemImg = findViewById(R.id.item_img)
        imageView = findViewById(R.id.is_noty)
        countNoty = findViewById(R.id.count_noty)
        checkBar = findViewById(R.id.check_bar)
        attrs?.let {
            init(it)
        }
    }

    private fun init(attrs: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ItemMenu)
        val count = typedArray.getString(R.styleable.ItemMenu_count_noty) ?: ""
        if (count.isNotEmpty()) {
            countNoty?.visibility = View.VISIBLE
            countNoty?.text = count
        } else {
            countNoty?.visibility = GONE
        }
        val img = typedArray.getResourceId(R.styleable.ItemMenu_item_background, -1)
        if (img != -1) {
            itemImg?.setImageResource(img)
        }
        val isNoty = typedArray.getBoolean(R.styleable.ItemMenu_is_noty, false)
        if (isNoty) {
            imageView?.visibility = visibility
        } else {
            imageView?.visibility = GONE
        }
        typedArray.recycle()
    }

    fun isCheck() {
        itemImg?.setColorFilter(ContextCompat.getColor(context, R.color.selected_color))
        checkBar?.visibility = visibility
    }

    fun isNotCheck() {
        itemImg?.setColorFilter(ContextCompat.getColor(context, R.color.unselected_color))
        checkBar?.visibility = GONE
    }
}