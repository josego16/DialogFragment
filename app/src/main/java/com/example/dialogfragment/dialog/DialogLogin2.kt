package com.example.dialogfragment.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.dialogfragment.R
import com.example.dialogfragment.controller.Controller
import com.example.dialogfragment.databinding.ActivityDialogLoginBinding

class DialogLogin2(
    val controller: Controller,
    val onDialogPositiveClick: (String, String) -> Unit,
    val onDialogNegativeClick: (String) -> Unit

) : DialogFragment() {


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

            builder.setMessage("Datos Login")
                .setPositiveButton(
                    "Aceptas los datos"
                ) { dialog, id ->
                    // Send the positive button event back to the host activity
                    val binding = ActivityDialogLoginBinding.bind(viewDialogLogin)
                    onDialogPositiveClick(
                        binding.username.text.toString(),
                        binding.password.text.toString()
                    )

                }
                .setNegativeButton(
                    "Cancelar"
                ) { dialog, id ->
                    // Send the negative button event back to the host activity
                    onDialogNegativeClick("Se ha cancelado")
                }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}