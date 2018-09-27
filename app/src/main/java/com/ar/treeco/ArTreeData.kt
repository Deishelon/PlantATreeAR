package com.ar.treeco

import java.util.ArrayList

fun getArTreeData(): ArrayList<ArTree> {
    val arTreeList = ArrayList<ArTree>()

    arTreeList.add(ArTree("Coffee tree", R.drawable.ar_preview_coffe, R.raw.tree))
    arTreeList.add(ArTree("Palm tree", R.drawable.ar_preview_palm, R.raw.palm_tree))
    arTreeList.add(ArTree("Pine tree", R.drawable.ar_preview_pine_tree, R.raw.pine_tree))
    arTreeList.add(ArTree("Banana tree", R.drawable.ar_preview_banana, R.raw.banana_tree))
    arTreeList.add(ArTree("Ivory cane palm tree", R.drawable.ar_preview_ivory, R.raw.ivory_tree))
    arTreeList.add(ArTree("Sakura tree", R.drawable.ar_preview_sakura, R.raw.sakura_tree))

    return arTreeList
}