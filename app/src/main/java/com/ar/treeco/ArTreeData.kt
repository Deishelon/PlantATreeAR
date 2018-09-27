package com.ar.treeco

import java.util.ArrayList

fun getArTreeData(): ArrayList<ArTree> {
    val arTreeList = ArrayList<ArTree>()

    arTreeList.add(ArTree("Coffee tree", R.drawable.ar_preview_coffe, R.raw.tree))
    arTreeList.add(ArTree("Palm tree", R.drawable.ar_preview_palm, R.raw.palm_tree))

    return arTreeList
}