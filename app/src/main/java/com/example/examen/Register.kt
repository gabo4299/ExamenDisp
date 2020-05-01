package com.example.examen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_register.*
import kotlin.concurrent.timer


class Register : AppCompatActivity() {

    lateinit var registerViewModel:RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register)
        registerViewModel=RegisterViewModel(RegisterRepository())
        registerViewModel.model.observe(this, Observer(::updateUI))
        btn_reg.setOnClickListener{
            progressBar.visibility= View.VISIBLE

            registerViewModel.doRegister(Name_Text.text.toString(),LastName_Text.text.toString(),Email_Text.text.toString())
            val r =Runnable{
                progressBar.visibility= View.GONE
            }
            Handler().postDelayed(r,1000)


        }
    }
    private fun updateUI(model:RegisterViewModel.UiModel?)
    {
        when (model)
        {
            is RegisterViewModel.UiModel.Register ->validarReg(model.success)
        }
    }

    private fun validarReg(resp:Boolean) {
//        funca o no
        val builder=AlertDialog.Builder(this) // Builder needs a context
        builder.setTitle("Registro de Usuario")

        if (resp){
            builder.setMessage("Usuario Creado Exitosamente")
            builder.setPositiveButton("Ok") { _,_ ->
                Toast.makeText(this, "Creado", Toast.LENGTH_LONG).show()
            }
        }
        else{
            builder.setMessage("Usuario No creado")
            builder.setPositiveButton("Ok") { _,_ ->
                Toast.makeText(this, "No creado", Toast.LENGTH_LONG).show()
            }
        }





        builder.show()

    }
}
