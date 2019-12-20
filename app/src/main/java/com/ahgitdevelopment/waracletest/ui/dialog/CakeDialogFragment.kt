package com.ahgitdevelopment.waracletest.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.ahgitdevelopment.waracletest.common.CAKE_DIALOG_FRAGMENT_IMAGE
import com.ahgitdevelopment.waracletest.common.CAKE_DIALOG_FRAGMENT_MESSAGE
import com.ahgitdevelopment.waracletest.common.CAKE_DIALOG_FRAGMENT_TITLE
import com.ahgitdevelopment.waracletest.data.Cake

class CakeDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val title = arguments!!.getString(CAKE_DIALOG_FRAGMENT_TITLE)
        val desc = arguments!!.getString(CAKE_DIALOG_FRAGMENT_MESSAGE)

        return AlertDialog.Builder(activity as Context)
            .setTitle(title)
            .setMessage(desc)
            .setPositiveButton(android.R.string.ok) { dialog, _ -> dialog.dismiss() }
            .create()
    }

    companion object {
        fun newInstance(cake: Cake): CakeDialogFragment {
            val frag = CakeDialogFragment()
            val args = Bundle().apply {
                putString(CAKE_DIALOG_FRAGMENT_TITLE, cake.title)
                putString(CAKE_DIALOG_FRAGMENT_MESSAGE, cake.desc)
                putString(CAKE_DIALOG_FRAGMENT_IMAGE, cake.image)
            }
            frag.arguments = args

            return frag
        }
    }
}
