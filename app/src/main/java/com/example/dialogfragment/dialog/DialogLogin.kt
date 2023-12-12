package com.example.dialogfragment.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.dialogfragment.R
import com.example.dialogfragment.controller.Controller
import com.example.dialogfragment.databinding.ActivityDialogLoginBinding
import com.example.dialogfragment.interfaz.OnloginInteface

class DialogLogin(private val controller: Controller) : DialogFragment() {

    lateinit var userName: String
    lateinit var password: String
    private lateinit var listener: OnloginInteface
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = controller
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //Tengo que cambiar activity por myActivity
        return activity?.let {
            // Build the dialog and set up the button click handlers
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            val viewDialogLogin = inflater.inflate(R.layout.activity_dialog_login, null)
            builder.setView(viewDialogLogin)

            builder.setMessage("Datos Login").setPositiveButton("Aceptas los datos") { dialog, id ->
                // Send the positive button event back to the host activity
                val binding = ActivityDialogLoginBinding.bind(viewDialogLogin)
                userName = binding.username.text.toString()
                password = binding.password.text.toString()
                listener.onDialogPositiveClick(this)

            }.setNegativeButton("Cancelar") { dialog, id ->
                // Send the negative button event back to the host activity
                listener.onDialogNegativeClick(this)
            }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}