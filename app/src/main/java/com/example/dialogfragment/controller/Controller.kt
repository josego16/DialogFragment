package com.example.dialogfragment.controller

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.dialogfragment.MainActivity
import com.example.dialogfragment.dialog.DialogLogin
import com.example.dialogfragment.dialog.DialogLogin2
import com.example.dialogfragment.interfaz.OnloginInteface

class Controller(private var context: Context) : OnloginInteface {

    fun setActionEvent() {
        val myActivity = context as MainActivity
        myActivity.binding.btnLogin.setOnClickListener {
            initDialogWithInterface(myActivity)
        }
        myActivity.binding.btnLogin2.setOnClickListener {
            initDialogWithFun(myActivity)
        }
    }

    private fun initDialogWithInterface(mA: MainActivity) {
        val dialog = DialogLogin(this)
        dialog.show(mA.supportFragmentManager, "Login con Interfaz")

    }

    override fun onDialogPositiveClick(dialog: DialogFragment?) {
        val myDialogLogin = (dialog as DialogLogin)
        val myUserName = myDialogLogin.userName
        val myPassword = myDialogLogin.password
        val myActivity = context as MainActivity
        myActivity.binding.txtUser.text = "Usuario: $myUserName"
        myActivity.binding.txtPass.text = "Password: $myPassword"
        Toast.makeText(context, " Usuario: $myUserName y password: $myPassword", Toast.LENGTH_LONG)
            .show()

    }

    override fun onDialogNegativeClick(dialog: DialogFragment?) {
        Toast.makeText(context, " Has cancelado el login", Toast.LENGTH_LONG).show()
    }

    private fun initDialogWithFun(mA: MainActivity) {
        val dialog = DialogLogin2(this,
            { userName, password ->
                renderize(userName, password)
            },
            {
                msgCancel(it)
            })
        dialog.show(mA.supportFragmentManager, "Login con Orden Superior")
    }

    private fun renderize(userName: String, password: String) {
        val mA = context as MainActivity
        mA.binding.txtUser.text = "Usuario: $userName"
        mA.binding.txtPass.text = "Password: $password"
        Toast.makeText(context, " Usuario: $userName y password: $password", Toast.LENGTH_LONG)
            .show()
    }

    private fun msgCancel(msg: String) {
        Toast.makeText(context, " Has cancelado el login", Toast.LENGTH_LONG).show()

    }

}