package com.androidmooc.proyecto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;

public class PhotoDetailActivity extends ListActivity implements OnClickListener{
	private String COMMENT = "comment";
	private String DATE = "date";
	private List<HashMap<String,String>> vComments = new ArrayList<HashMap<String,String>>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photo_detail);
		Button btnAdd = (Button) findViewById(R.id.btnComentar);
		btnAdd.setOnClickListener(this);
		
		SimpleAdapter saAdapter = new SimpleAdapter(this, vComments,android.R.layout.simple_list_item_2, new String[]{COMMENT, DATE}, new int[]{android.R.id.text1, android.R.id.text2});
		setListAdapter(saAdapter);
	}
/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.photo_detail, menu);
		return true;
	}
*/
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		EditText txtComments = (EditText) findViewById(R.id.txtComentario);
		String Comentario = txtComments.getText().toString();
		String Fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(Calendar.getInstance().getTime());
		HashMap<String, String> elComentario = new HashMap<String, String>();
		elComentario.put(COMMENT, Comentario);
		elComentario.put(DATE, "Agregado :" + Fecha);
		vComments.add(elComentario);
		SimpleAdapter myAdapter = (SimpleAdapter) getListAdapter();
		myAdapter.notifyDataSetChanged();
		txtComments.setText("");
	}
}
