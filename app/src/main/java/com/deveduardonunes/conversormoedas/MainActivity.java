package com.deveduardonunes.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //View Holders para achar identificar os IDs
        this.mViewHolder.editValue = findViewById(R.id.edit_value);
        this.mViewHolder.textDolar = findViewById(R.id.text_dolar);
        this.mViewHolder.textEuro = findViewById(R.id.text_euro);
        this.mViewHolder.textLibras = findViewById(R.id.text_libras);

        this.mViewHolder.buttonCalculate = findViewById(R.id.button_calculate);
        this.mViewHolder.buttonCalculate.setOnClickListener(this);

        this.clearValues();

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_calculate){
            String value = this.mViewHolder.editValue.getText().toString();
            if("".equals(value)){
                //Mostra mensagem pro usuário
                Toast.makeText(this, R.string.informe_valor, Toast.LENGTH_LONG).show();
            }else{
                //Lógica para converter o valor de real para euro, dolar e libras, respectivamente
                Double real = Double.valueOf(value); // Transformando o valor em double

                this.mViewHolder.textEuro.setText(String.format("%.2f",(real/6.30))); // Convertendo para Euro
                this.mViewHolder.textDolar.setText(String.format("%.2f",(real/5.32))); // Convertendo para Dolar
                this.mViewHolder.textLibras.setText(String.format("%.2f",(real/6.80))); // Covertendo para Libras


            }
        }
    }
    private void clearValues(){
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textEuro.setText("");
        this.mViewHolder.textLibras.setText("");

    }
    private static class ViewHolder{
        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        TextView textLibras;
        Button buttonCalculate;
    }

}