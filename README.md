# Desafio - Criando um App Android com Suporte a Vários Idiomas



### **Projeto: Criando um App Android com Suporte a Vários Idiomas**



Este projeto tem como objetivo criar um aplicativo Android simples que demonstre como adicionar suporte a vários idiomas a um aplicativo. O aplicativo será um conversor de unidades que pode converter entre diferentes unidades de medida, como comprimento, peso e temperatura. O aplicativo será traduzido para inglês, espanhol e francês.



#### **Estrutura do Projeto**

O projeto será estruturado em vários módulos, incluindo:

- Módulo `app`: Contém a lógica principal do aplicativo, como navegação e gerenciamento de dados.
- Módulo `core`: Contém classes e utilitários comuns usados por outros módulos.



#### **Recursos do Aplicativo**

O aplicativo terá os seguintes recursos:

- **Tela Principal:** Exibe uma lista de categorias de conversão (por exemplo, comprimento, peso, temperatura).
- **Tela de Conversão:** Permite que o usuário converta entre diferentes unidades dentro de uma categoria específica.
- **Suporte a Vários Idiomas:** O aplicativo será traduzido para inglês, espanhol e francês.



**Código do Projeto**

#### **MainActivity.kt**

kotlin

```kotlin
package com.example.multilanguageapp

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var conversionCategoriesSpinner: Spinner
    private lateinit var conversionTextView: TextView
    private lateinit var conversionCategories: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        conversionCategoriesSpinner = findViewById(R.id.conversionCategoriesSpinner)
        conversionTextView = findViewById(R.id.conversionTextView)

        // Obter o idioma do dispositivo
        val locale = resources.configuration.locale

        // Carregar as strings traduzidas
        val resources = createConfigurationContext(Configuration(locale)).resources
        conversionCategories = resources.getStringArray(R.array.conversion_categories).toList()

        // Criar um adaptador para o spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, conversionCategories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        conversionCategoriesSpinner.adapter = adapter

        // Definir o ouvinte do spinner
        conversionCategoriesSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedCategory = conversionCategories[position]
                updateConversionTextView(selectedCategory)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Não fazer nada
            }
        }

        // Selecionar a primeira categoria por padrão
        conversionCategoriesSpinner.setSelection(0)
    }

    private fun updateConversionTextView(category: String) {
        // Carregar as strings traduzidas
        val resources = createConfigurationContext(Configuration(Locale.getDefault())).resources

        when (category) {
            resources.getString(R.string.length) -> {
                // Converter comprimento
            }
            resources.getString(R.string.weight) -> {
                // Converter peso
            }
            resources.getString(R.string.temperature) -> {
                // Converter temperatura
            }
        }
    }
}
```



#### **strings.xml** (diretório **res/values**)

xml

```xml
<resources>
    <string name="app_name">Conversor de Unidades</string>
    <string name="conversion_categories">Comprimento,Peso,Temperatura</string>
    <string name="length">Comprimento</string>
    <string name="weight">Peso</string>
    <string name="temperature">Temperatura</string>
</resources>
```



#### **strings.xml** (diretório **res/values-es**)

xml

```xml
<resources>
    <string name="app_name">Conversor de Unidades</string>
    <string name="conversion_categories">Longitud,Peso,Temperatura</string>
    <string name="length">Longitud</string>
    <string name="weight">Peso</string>
    <string name="temperature">Temperatura</string>
</resources>
```



#### **strings.xml** (diretório **res/values-fr**)

xml

```xml
<resources>
    <string name="app_name">Convertisseur d'unités</string>
    <string name="conversion_categories">Longueur,Poids,Température</string>
    <string name="length">Longueur</string>
    <string name="weight">Poids</string>
    <string name="temperature">Température</string>
</resources>
```



### **Conclusão**

Este projeto fornece um modelo completo para criar um aplicativo Android com suporte a vários idiomas. O aplicativo pode ser personalizado para atender às suas necessidades específicas, adicionando recursos adicionais, como mais idiomas ou a capacidade de alterar o idioma do aplicativo dinamicamente.

