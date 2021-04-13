package com.example.sharedjobs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private EditText editName;
    private EditText editEmail;
    private EditText editFundamentalMedioData;
    private EditText editMestradoDoutoradoOrientador;
    private EditText editMestradoDoutoradoTitulo;
    private EditText editMestradoDoutoradoInstituicao;
    private EditText editMestradoDoutoradoData;
    private EditText editGraduacaoEspecializacaoInstituicao;
    private EditText editGraduacaoEspecializacaoData;
    private CheckBox checkBoxCelular;
    private EditText editCelular;
    private EditText editTelefone ;
    private EditText editVagas;
    private CheckBox checkBoxEmail;
    private Spinner spinnerFormacao;
    private LinearLayout linearLayoultFundamentalMedio;
    private LinearLayout linearLayoultMestradoDoutorado;
    private LinearLayout linearLayoultGraduacaoEspecializacao;
    private RadioButton radioButtonFem;
    private RadioButton radioButtonMasc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();

        spinnerFormacao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                    case 1:
                        linearLayoultFundamentalMedio.setVisibility(View.VISIBLE);
                        linearLayoultMestradoDoutorado.setVisibility(View.GONE);
                        linearLayoultGraduacaoEspecializacao.setVisibility(View.GONE);
                        break;
                    case 2:
                    case 3:
                        linearLayoultFundamentalMedio.setVisibility(View.GONE);
                        linearLayoultMestradoDoutorado.setVisibility(View.GONE);
                        linearLayoultGraduacaoEspecializacao.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                    case 5:
                        linearLayoultFundamentalMedio.setVisibility(View.GONE);
                        linearLayoultMestradoDoutorado.setVisibility(View.VISIBLE);
                        linearLayoultGraduacaoEspecializacao.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if (checkBoxCelular.isChecked()){

        }

        CheckBox celChkBx = ( CheckBox ) findViewById( R.id.checkBoxCelular );
        celChkBx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if ( isChecked ){
                    editCelular.setVisibility(View.VISIBLE);
                } else {
                    editCelular.setVisibility(View.GONE);
                }
            }
        });
    }

    private void bindViews(){
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        checkBoxEmail = findViewById(R.id.checkBoxEmail);
        spinnerFormacao = findViewById(R.id.spinnerFormacao);
        linearLayoultFundamentalMedio = findViewById(R.id.linearLayoultFundamentalMedio);
        editFundamentalMedioData = findViewById(R.id.editFundamentalMedioData);
        radioButtonFem = findViewById(R.id.radioButtonFem);
        radioButtonMasc = findViewById(R.id.radioButtonMasc);
        linearLayoultMestradoDoutorado = findViewById(R.id.linearLayoultMestradoDoutorado);
        linearLayoultGraduacaoEspecializacao = findViewById(R.id.linearLayoultGraduacaoEspecializacao);
        editMestradoDoutoradoOrientador = findViewById(R.id.editMestradoDoutoradoOrientador);
        editMestradoDoutoradoTitulo = findViewById(R.id.editMestradoDoutoradoTitulo);
        editMestradoDoutoradoInstituicao = findViewById(R.id.editMestradoDoutoradoInstituicao);
        editMestradoDoutoradoData = findViewById(R.id.editMestradoDoutoradoData);
        editGraduacaoEspecializacaoInstituicao = findViewById(R.id.editGraduacaoEspecializacaoInstituicao);
        editGraduacaoEspecializacaoData = findViewById(R.id.editGraduacaoEspecializacaoData);
        checkBoxCelular = findViewById(R.id.checkBoxCelular);
        checkBoxCelular = findViewById(R.id.checkBoxCelular);
        editCelular = findViewById(R.id.editCelular);
        editTelefone = findViewById(R.id.editTelefone );
        editVagas = findViewById(R.id.editVagas);
    }

    public void onClickButton(View view){
        if (view.getId() == R.id.buttonSubmit){
            saveForm();
        } else if (view.getId() == R.id.buttonClean){
            cleanForm();
        }
    }

    public void onChangeCelular(View view){
        System.out.println("" +
                "a" +
                "a" +
                "a" +
                "a" +
                "a" +
                "a" +
                "a" +
                "a" +
                "a" +
                "a" +
                "" +
                "a" +
                "a" +
                "a");
    }

    private void cleanForm(){
        editName.setText("");
        editEmail.setText("");
        checkBoxEmail.setText("");
        spinnerFormacao.setSelection(0);
        editFundamentalMedioData.setText("");
        radioButtonFem.setChecked(false);
        radioButtonMasc.setChecked(true);
    }

    private void saveForm(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Nome: ").append(editName.getText().toString()).append("\n");
        stringBuffer.append("E-Mail: ").append(editEmail.getText().toString()).append("\n");

        if (checkBoxEmail.isChecked()){
            stringBuffer.append("Desejo receber e-mails com atualizações de oportunidades").append("\n");
        } else {
            stringBuffer.append("Não quero receber e-mails com atualizações de oportunidades").append("\n");
        }

        stringBuffer.append("Telefone: ").append(editTelefone.getText().toString()).append("\n");

        if (checkBoxCelular.isChecked()){
            stringBuffer.append("Celular: ").append(editCelular.getText().toString()).append("\n");
        }

        stringBuffer.append("Formação: ").append(Arrays.asList(getResources().getStringArray(R.array.formacao)).get(spinnerFormacao.getSelectedItemPosition())).append("\n");
        if (spinnerFormacao.getSelectedItemPosition() == 0 || spinnerFormacao.getSelectedItemPosition() == 1){
            stringBuffer.append("Ano de Formatura: ").append(editFundamentalMedioData.getText().toString()).append("\n");
        }else if (spinnerFormacao.getSelectedItemPosition() == 2 || spinnerFormacao.getSelectedItemPosition() == 3){
            stringBuffer.append("Ano de Conclusão: ").append(editGraduacaoEspecializacaoData.getText().toString()).append("\n");
            stringBuffer.append("Instituição: ").append(editGraduacaoEspecializacaoInstituicao.getText().toString()).append("\n");
        }else if (spinnerFormacao.getSelectedItemPosition() == 4 || spinnerFormacao.getSelectedItemPosition() == 5){
            stringBuffer.append("Ano de Conclusão: ").append(editMestradoDoutoradoData.getText().toString()).append("\n");
            stringBuffer.append("Instituição: ").append(editMestradoDoutoradoInstituicao.getText().toString()).append("\n");
            stringBuffer.append("Título da Monografia: ").append(editMestradoDoutoradoTitulo.getText().toString()).append("\n");
            stringBuffer.append("Orientador: ").append(editMestradoDoutoradoOrientador.getText().toString()).append("\n");
        }

        stringBuffer.append("Sexo : ").append(radioButtonMasc.isChecked()?"Masculino":"Feminino").append("\n");

        stringBuffer.append("Vagas de Interesse: ").append(editVagas.getText().toString()).append("\n");
        Toast.makeText(this, stringBuffer, Toast.LENGTH_LONG).show();
    }
}