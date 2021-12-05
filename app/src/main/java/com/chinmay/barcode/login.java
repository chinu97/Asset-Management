package com.chinmay.barcode;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class login extends AppCompatActivity
{
    Button b1,b2,b3,b4;
    final Activity activity=this;
    EditText et7,et33,et22,et23,et24,et25,et26,et27,et28,et29,et30,et31,et32,et19,et18,et16,et15,et9,et14,et11,et10,et8,et;
    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseAuth firebaseAuth;
    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    private DrawerLayout mDrawerLayout;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button7);
        b3=(Button)findViewById(R.id.button14);


        et7=(EditText)findViewById(R.id.editText7);
        et33=(EditText)findViewById(R.id.editText33);
        et22=(EditText)findViewById(R.id.editText22);
        et23=(EditText)findViewById(R.id.editText23);
        et24=(EditText)findViewById(R.id.editText24);
        et25=(EditText)findViewById(R.id.editText25);
        et26=(EditText)findViewById(R.id.editText26);
        et27=(EditText)findViewById(R.id.editText27);
        et28=(EditText)findViewById(R.id.editText28);
        et29=(EditText)findViewById(R.id.editText29);
        et30=(EditText)findViewById(R.id.editText30);
        et31=(EditText)findViewById(R.id.editText31);
        et32=(EditText)findViewById(R.id.editText32);
        et19=(EditText)findViewById(R.id.editText19);

        et18=(EditText)findViewById(R.id.editText18);
        et16=(EditText)findViewById(R.id.editText16);
        et15=(EditText)findViewById(R.id.editText15);
        et9=(EditText)findViewById(R.id.editText9);
        et14=(EditText)findViewById(R.id.editText14);
        et11=(EditText)findViewById(R.id.editText11);
        et10=(EditText)findViewById(R.id.editText10);
        et8=(EditText)findViewById(R.id.editText8);
        database=FirebaseDatabase.getInstance();
        reference= database.getReference("All Assets");
        firebaseAuth=FirebaseAuth.getInstance();
        et=(EditText)findViewById(R.id.editText7);

        b3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String er=firebaseAuth.getCurrentUser().getUid();
                reference.child(er).child("status").setValue("inactive");
                firebaseAuth.getInstance().signOut();
                Intent r=new Intent(login.this,MainActivity.class);
                startActivity(r);
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String Asset=et7.getText().toString() ;
                String Sno=et33.getText().toString() ;
                String AssetWithSubNo=et22.getText().toString() ;
                String SerialNumber=et23.getText().toString() ;
                String SerialNumber2=et24.getText().toString() ;
                String CapitalDate=et25.getText().toString() ;
                String DepnDate=et26.getText().toString() ;
                String Plant=et27.getText().toString() ;
                String CostCenter=et28.getText().toString() ;
                String ProfitCenter=et29.getText().toString() ;
                String HFMCode=et30.getText().toString() ;
                String Class=et31.getText().toString() ;
                String ClassDescription=et32.getText().toString() ;
                String LocationName=et19.getText().toString() ;
                String AssetGL=et18.getText().toString() ;
                String DepnGL=et16.getText().toString() ;
                String Location=et15.getText().toString() ;
                String Qty=et9.getText().toString() ;
                String Life=et14.getText().toString();
                String WDV=et11.getText().toString();
                String AssetDescription=et10.getText().toString();
                String GrossValue=et8.getText().toString();


                // String G=et4.getText().toString();
                Product PO=new Product(Asset,Sno,AssetWithSubNo,SerialNumber,SerialNumber2,CapitalDate,DepnDate,Plant,CostCenter,ProfitCenter,HFMCode,Class,ClassDescription,LocationName,AssetGL,DepnGL,Location,Qty,Life,WDV,AssetDescription,GrossValue);
                reference.child(Asset).setValue(PO);
                Toast.makeText(getApplicationContext(),"Data Successfully Saved",Toast.LENGTH_LONG).show();
                Intent i = new Intent(login.this,MainActivity.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                IntentIntegrator in = new IntentIntegrator(activity);
                in.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                in.setPrompt("scan");
                in.setCameraId(0);
                in.setBeepEnabled(false);
                //in.setBarcodeImageEnabled(false);
                in.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        IntentResult result=IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result!=null)
        {
            if(result.getContents()==null)
            {
                Log.d("MainActivity","Cancelled scan");
                Toast.makeText(this,"Cancelled",Toast.LENGTH_LONG).show();;
            }
            else
            {
                Log.d("MainActivity","Scanned");


/*reference.child(result.getContents()).addValueEventListener(new ValueEventListener()
{
    @Override
    public void onDataChange(DataSnapshot dataSnapshot)
    {
   add a= dataSnapshot.getValue(add.class);
Log.e("Name",a.Name);



    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});*/
                et.setText(result.getContents());
                Toast.makeText(this, "Scanned", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            super.onActivityResult(requestCode,resultCode,data);
        }
        // super.onActivityResult(requestCode, resultCode, data);
    }
}