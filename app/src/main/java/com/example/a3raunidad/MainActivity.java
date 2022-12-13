package com.example.a3raunidad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout tilSerie,tilDescripcion,tilValor;
    private Button btnGrabar,btnEliminar,btnAnterior,btnSiguiente;
    private TextView tvActual;
    private String [] arraySpn;
    private ArrayList<Producto> listaProductos;
    private ArrayAdapter<String> adaptadorListaSpn;
    private Spinner spinnerTipo;
    private int indice =0,valor;
    private String Valor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        referencias();
        eventos();
        poblar();
        obtenerDatos();
        limpiar();
        }
    private void poblar (){
        arraySpn [0] = "Seleccione tipo de producto";
        arraySpn [1] = "Pc";
        arraySpn [2] = "Impresora";
        arraySpn [3] = "Mouse";
        arraySpn [4] = "Teclado";
        arraySpn [5] = "Accesorio";
        adaptadorListaSpn = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraySpn);
        spinnerTipo.setAdapter(adaptadorListaSpn);
        listaProductos = new ArrayList<Producto>();
        listaProductos.add(new Producto("hola","computador",arraySpn[1],10000));
        listaProductos.add(new Producto("hola1","computador",arraySpn[2],10000));
        listaProductos.add(new Producto("hola2","computador",arraySpn[3],10000));
    }
        //region eventos y referencias
    private void referencias(){
        tilSerie =findViewById(R.id.tilSerie);
        tilDescripcion =findViewById(R.id.tilDescripcion);
        tilValor =findViewById(R.id.tilValor);
        tvActual = findViewById(R.id.tvActual);
        btnGrabar =findViewById(R.id.btnGrabar);
        btnEliminar =findViewById(R.id.btnEliminar);
        btnAnterior =findViewById(R.id.btnAnterior);
        btnSiguiente =findViewById(R.id.btnSiguiente);
        arraySpn = new String[6];
        listaProductos = new ArrayList<Producto>();
        spinnerTipo=findViewById(R.id.spnTipo);

    }
    private void eventos(){
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                indice ++;
                if(indice ==listaProductos.size())
                    indice = 0;
                obtenerDatos();
            }

        });
        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                indice --;
                if(indice == -1) indice = listaProductos.size()-1;

                obtenerDatos();
            }
        });
        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grabar();
                limpiar();
            }
        });
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminar();
                limpiar();
            }
        });
    }

    //endregion
    private void obtenerDatos(){
        Producto p = listaProductos.get(indice);
        tilSerie.getEditText().setText(p.getSerie());
        tilDescripcion.getEditText().setText(p.getDescripcion());
        valor = p.getValor();
        Valor = Integer.toString(valor);
        tilValor.getEditText().setText(Valor);




        if(p.getTipo().equals("Pc")) spinnerTipo.setSelection(1);
        if(p.getTipo().equals("Impresora")) spinnerTipo.setSelection(2);
        if(p.getTipo().equals("Mouse")) spinnerTipo.setSelection(3);
        if(p.getTipo().equals("Teclado")) spinnerTipo.setSelection(4);
        if(p.getTipo().equals("Accesorio")) spinnerTipo.setSelection(5);

        tvActual.setText((indice+1) + "de"+listaProductos.size());

    }
    private void limpiar(){
        tilSerie.getEditText().setText("");
        tilDescripcion.getEditText().setText("");
        tilValor.getEditText().setText("0");
        spinnerTipo.setSelection(0);

        tvActual.setText("" +listaProductos.size());
    }
    private void grabar(){
        String serie, descripcion, tipo;
        int valor;
        serie = tilSerie.getEditText().getText().toString();
        descripcion = tilDescripcion.getEditText().getText().toString();
        tipo = spinnerTipo.getSelectedItem().toString();
        valor = Integer.parseInt(tilValor.getEditText().getText().toString());
        Producto p = new Producto (serie,descripcion,tipo,valor);
        listaProductos.add(p);
    }
    private void eliminar(){
        listaProductos.remove(indice);
    }
    }
