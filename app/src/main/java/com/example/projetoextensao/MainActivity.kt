package com.example.projetoextensao

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    }

    fun clicar(view: View){         //função que vai iniciar ao clicar o botão

        val med_anterior =findViewById<EditText>(R.id.NUM_ANTERIOR)   // localizando o input de medição anterior
        val med_atual =findViewById<EditText>(R.id.NUM_ATUAL)           // localizando o input de medição atual
        val resultado = findViewById<TextView>(R.id.VALOR)            // localizando a "caixa de resultados"

        val medatual_Text = med_atual.text.toString()                   // convertando o valor digitado em uma string
        val medant_Text = med_anterior.text.toString()                  // convertando o valor digitado em uma string
        val precokwh = 1.14546                                         // determinando o preço MÉDIO do Kwh da companhia de energia eletrica já com a soma dos tributos
        val taxaILMNP = 19.94                                          // determina o valor da taxa de iluminação publica

        if (medatual_Text.isNotEmpty() && medant_Text.isNotEmpty()){        // validando se os input não estão vazios

        val numero_1 = medant_Text.toInt()                      // convertando o input digitado para numeros inteiros
        val numero_2 = medatual_Text.toInt()                    // convertando o input digitado para numeros inteiros

        val calular = (numero_2 - numero_1) * precokwh + taxaILMNP          // formula subtraindo os input e depois multiplicando pelo Kwh

        val calcuformat = String.format("%.2f",calular)                //formatando o resultado
        resultado.setText("R$: $calcuformat")}                      // exibindo o resultado na "caixa de resultados"

        else {
            Toast.makeText(this,"Insira os numeros acima", Toast.LENGTH_SHORT).show()   //condição caso não tenha valores nos input
        }

    }
}