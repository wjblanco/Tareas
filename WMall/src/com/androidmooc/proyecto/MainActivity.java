package com.androidmooc.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		final ListView lstView = (ListView) findViewById(R.id.MallList);
		//String[] strMallList = {"Uno","Dos","Tres"};
		Negocio[] negMallList = {
			new Negocio(1, "Tienda de zapatos", "Local 1", "22334455", "09:00 a 18:00", "www.calzadoroy.com", "info@calzadoroy.com"),
			new Negocio(2, "Tienda de ropa", "Local 2", "22335566", "09:00 a 18:00", "www.megapaca.com.gt", "info@megapaca.com.gt"),
			new Negocio(3, "Tienda de juguetes", "Local 2", "22335566", "09:00 a 18:00", "www.megapaca.com.gt", "info@megapaca.com.gt")
		};
		
		Button btnPhotoView = (Button) findViewById(R.id.btnPhotoView);
		
		ArrayAdapter<Negocio> MallAdapter = new ArrayAdapter<Negocio>(this,android.R.layout.simple_list_item_1,negMallList);
		lstView.setAdapter((ListAdapter) MallAdapter);
		
		lstView.setOnItemClickListener(new OnItemClickListener() { 
			@Override 
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					Negocio negItem = (Negocio) lstView.getItemAtPosition(position);
					//Toast.makeText(getBaseContext(), negItem.direccion, Toast.LENGTH_LONG).show();
					
					String[] Datos = new String[6];
					Datos[Negocio.NOMBRE] = negItem.nombre;
					Datos[Negocio.DIRECCION] = negItem.direccion;
					Datos[Negocio.TELEFONO] = negItem.telefono;
					Datos[Negocio.HORARIO] = negItem.horario;
					Datos[Negocio.WEBSITE] = negItem.website;
					Datos[Negocio.EMAIL] = negItem.email;
					
					Intent sentIntent = new Intent(getApplicationContext(),ShowMallInfoActivity.class);
					sentIntent.putExtra(ShowMallInfoActivity.QUERY, Datos);
					startActivity(sentIntent);
				} 
			});
		
		btnPhotoView.setOnClickListener(
				new OnClickListener(){

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						Intent photoIntent = new Intent(getApplicationContext(),PhotoDetailActivity.class);
						startActivity(photoIntent);						
					}
					
					
				}
				);
		
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
