package com.sorteioNumeros.myapplication;
//Define o pacote do app — funciona como um "endereço" único que identifica seu aplicativo.

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
//MainActivity é a tela principal do app
//extends AppCompatActivity significa que ela herda todos os comportamentos de uma tela Android padrão (ciclo de vida, navegação, etc.)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//onCreate é chamado automaticamente quando a tela é criada
//@Override indica que estamos substituindo o comportamento padrão da classe pai
//super.onCreate(...) chama o comportamento original antes de adicionar o nosso
//savedInstanceState contém dados salvos caso o app tenha sido fechado antes (ex: rotação de tela)
        //EdgeToEdge.enable(this) → faz o conteúdo se estender por toda a tela
        //setContentView(R.layout.activity_main) → vincula o XML de layout (activity_main.xml) a esta Activity — é aqui que a tela é "desenhada"
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
//Esse bloco é gerado automaticamente pelo Android Studio. Ele:
//Detecta o tamanho das barras do sistema (status bar, navigation bar)
//Adiciona padding na tela para o conteúdo não ficar escondido atrás dessas barras
    public void sortearNumero(View view){
        //Método público (pode ser chamado de fora)
        //Recebe um View como parâmetro — isso é necessário para que ele possa ser chamado diretamente pelo botão no XML com android:onClick="sortearNumero"

        int numero = new Random().nextInt(100) + 1;

        TextView texto = findViewById(R.id.Resultado);

        texto.setText(String.valueOf(numero));
    }
}
//new Random() → cria um gerador de números aleatórios
//.nextInt(100) → gera um número entre 0 e 99
//+ 1 → desloca o resultado para 1 a 100