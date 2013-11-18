package com.androidmooc.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.view.View.*;
import android.widget.Button;
import android.widget.TextView;

public class ShowMallInfoActivity extends Activity implements OnClickListener 
{
	
	//Negocio negSeleccionado;
	String[] negSeleccionado;
	public static final String QUERY = "query";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_mallinfo);
	    
	    Button btnCall = (Button) findViewById(R.id.btnCall);
	    btnCall.setOnClickListener((android.view.View.OnClickListener) this);
	    
	    TextView txtvwNombre = (TextView) findViewById(R.id.txtnegNombre);
	    TextView txtvwDireccion = (TextView) findViewById(R.id.txtnegDireccion);
	    TextView txtvwTelefono = (TextView) findViewById(R.id.txtnegTelefono);
	    TextView txtvwHorario = (TextView) findViewById(R.id.txtnegHorario);
	    TextView txtvwWebsite = (TextView) findViewById(R.id.txtnegWebsite);
	    TextView txtvwEmail = (TextView) findViewById(R.id.txtnegEmail);
	    
	    Intent selIntent = getIntent();
	    negSeleccionado = selIntent.getStringArrayExtra(ShowMallInfoActivity.QUERY);
	    
	    txtvwNombre.setText(negSeleccionado[Negocio.NOMBRE]);
	    txtvwDireccion.setText(negSeleccionado[Negocio.DIRECCION]);
	    txtvwTelefono.setText(negSeleccionado[Negocio.TELEFONO]);
	    txtvwHorario.setText(negSeleccionado[Negocio.HORARIO]);
	    txtvwWebsite.setText(negSeleccionado[Negocio.WEBSITE]);
	    txtvwEmail.setText(negSeleccionado[Negocio.EMAIL]);
	    Linkify.addLinks(txtvwWebsite, Linkify.WEB_URLS);
	    Linkify.addLinks(txtvwEmail, Linkify.EMAIL_ADDRESSES);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent callIntent = new Intent(Intent.ACTION_CALL);
	    callIntent.setData(Uri.parse("tel:" + negSeleccionado[Negocio.TELEFONO]));
	    startActivity(callIntent);
	}
}

