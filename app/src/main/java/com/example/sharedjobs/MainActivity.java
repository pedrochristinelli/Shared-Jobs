package com.example.sharedjobs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import com.example.sharedjobs.databinding.ActivityMainBinding;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        activityMainBinding.spinnerFormacao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                    case 1:
                        activityMainBinding.linearLayoultFundamentalMedio.setVisibility(View.VISIBLE);
                        activityMainBinding.linearLayoultMestradoDoutorado.setVisibility(View.GONE);
                        activityMainBinding.linearLayoultGraduacaoEspecializacao.setVisibility(View.GONE);
                        break;
                    case 2:
                    case 3:
                        activityMainBinding.linearLayoultFundamentalMedio.setVisibility(View.GONE);
                        activityMainBinding.linearLayoultMestradoDoutorado.setVisibility(View.GONE);
                        activityMainBinding.linearLayoultGraduacaoEspecializacao.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                    case 5:
                        activityMainBinding.linearLayoultFundamentalMedio.setVisibility(View.GONE);
                        activityMainBinding.linearLayoultMestradoDoutorado.setVisibility(View.VISIBLE);
                        activityMainBinding.linearLayoultGraduacaoEspecializacao.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if (activityMainBinding.checkBoxCelular.isChecked()){

        }

        CheckBox celChkBx = ( CheckBox ) activityMainBinding.checkBoxCelular;
        celChkBx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if ( isChecked ){
                    activityMainBinding.editCelular.setVisibility(View.VISIBLE);
                } else {
                    activityMainBinding.editCelular.setVisibility(View.GONE);
                }
            }
        });
    }

    public void onClickButton(View view){
        if (view.getId() == activityMainBinding.buttonSubmit.getId()){
            saveForm();
        } else if (view.getId() == activityMainBinding.buttonClean.getId()){
            cleanForm();
        }
    }

    private void cleanForm(){
        activityMainBinding.editName.setText("");
        activityMainBinding.editEmail.setText("");
        activityMainBinding.checkBoxEmail.setText("");
        activityMainBinding.spinnerFormacao.setSelection(0);
        activityMainBinding.editFundamentalMedioData.setText("");
        activityMainBinding.radioButtonFem.setChecked(false);
        activityMainBinding.radioButtonMasc.setChecked(true);
    }

    private void saveForm(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Nome: ").append(activityMainBinding.editName.getText().toString()).append("\n");
        stringBuffer.append("E-Mail: ").append(activityMainBinding.editEmail.getText().toString()).append("\n");

        if (activityMainBinding.checkBoxEmail.isChecked()){
            stringBuffer.append("Desejo receber e-mails com atualizações de oportunidades").append("\n");
        } else {
            stringBuffer.append("Não quero receber e-mails com atualizações de oportunidades").append("\n");
        }

        stringBuffer.append("Telefone: ").append(activityMainBinding.editTelefone.getText().toString()).append("\n");

        if (activityMainBinding.checkBoxCelular.isChecked()){
            stringBuffer.append("Celular: ").append(activityMainBinding.editCelular.getText().toString()).append("\n");
        }

        stringBuffer.append("Formação: ").append(Arrays.asList(getResources().getStringArray(R.array.formacao)).get(activityMainBinding.spinnerFormacao.getSelectedItemPosition())).append("\n");
        if (activityMainBinding.spinnerFormacao.getSelectedItemPosition() == 0 || activityMainBinding.spinnerFormacao.getSelectedItemPosition() == 1){
            stringBuffer.append("Ano de Formatura: ").append(activityMainBinding.editFundamentalMedioData.getText().toString()).append("\n");
        }else if (activityMainBinding.spinnerFormacao.getSelectedItemPosition() == 2 || activityMainBinding.spinnerFormacao.getSelectedItemPosition() == 3){
            stringBuffer.append("Ano de Conclusão: ").append(activityMainBinding.editGraduacaoEspecializacaoData.getText().toString()).append("\n");
            stringBuffer.append("Instituição: ").append(activityMainBinding.editGraduacaoEspecializacaoInstituicao.getText().toString()).append("\n");
        }else if (activityMainBinding.spinnerFormacao.getSelectedItemPosition() == 4 || activityMainBinding.spinnerFormacao.getSelectedItemPosition() == 5){
            stringBuffer.append("Ano de Conclusão: ").append(activityMainBinding.editMestradoDoutoradoData.getText().toString()).append("\n");
            stringBuffer.append("Instituição: ").append(activityMainBinding.editMestradoDoutoradoInstituicao.getText().toString()).append("\n");
            stringBuffer.append("Título da Monografia: ").append(activityMainBinding.editMestradoDoutoradoTitulo.getText().toString()).append("\n");
            stringBuffer.append("Orientador: ").append(activityMainBinding.editMestradoDoutoradoOrientador.getText().toString()).append("\n");
        }

        stringBuffer.append("Sexo : ").append(activityMainBinding.radioButtonMasc.isChecked()?"Masculino":"Feminino").append("\n");

        stringBuffer.append("Vagas de Interesse: ").append(activityMainBinding.editVagas.getText().toString()).append("\n");
        Toast.makeText(this, stringBuffer, Toast.LENGTH_LONG).show();
    }
}