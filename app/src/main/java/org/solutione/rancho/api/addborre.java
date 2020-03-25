package org.solutione.rancho.api;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.solutione.rancho.R;

import java.text.BreakIterator;

import static android.content.ContentValues.TAG;


public class addborre extends DialogFragment implements AdapterView.OnItemSelectedListener {
    public String razas;

    private String fechaSeleccionada;

    EditText    etPlannedDate = null;
    RadioGroup radioGroupTipoParto;
    RadioGroup radioGroupTipoproposito;
    RadioGroup radioGroupTipogenero;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        View Myview = inflater.inflate(R.layout.addborre, null);
        final EditText p = Myview.findViewById(R.id.nombrecordero);
        final EditText u = Myview.findViewById(R.id.peso);
        final  EditText idfinca=Myview.findViewById(R.id.idfinca);
        Spinner spinner = Myview.findViewById(R.id.razas);
       radioGroupTipoParto= Myview.findViewById(R.id.tipo_parto);
       /////tipo de parto
        final RadioButton radioButtonsimple = Myview.findViewById(R.id.radiosimple);
        final RadioButton radioButtondoble = Myview.findViewById(R.id.radiodoble);
        final RadioButton radioButtontriple = Myview.findViewById(R.id.radiotriple);
        ////proposito
        radioGroupTipoproposito= Myview.findViewById(R.id.propsito);
        final RadioButton radiocria = Myview.findViewById(R.id.radiocria);
        final RadioButton radioabasto = Myview.findViewById(R.id.radioabasto);
        ///////genero
       radioGroupTipogenero= Myview.findViewById(R.id.genero);
        final RadioButton radiohembra= Myview.findViewById(R.id.hembra);
        final RadioButton radiomacho = Myview.findViewById(R.id.macho);




        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.razas_borre, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


          etPlannedDate = (EditText) Myview.findViewById(R.id.etPlannedDate);
        etPlannedDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                crearDialogoFecha();

            }
        });
        builder.setView(Myview)


                .setPositiveButton(R.string.singnin, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String tipoparto=null;
                        String proposito=null;
                        String genero=null;
                        int idDeRadioButtonSeleccionado = radioGroupTipoParto.getCheckedRadioButtonId();
                        if (idDeRadioButtonSeleccionado == radioButtonsimple.getId()) {
                            tipoparto="simple";
                        } if (idDeRadioButtonSeleccionado == radioButtondoble.getId()) {
                            tipoparto="doble";
                        } if (idDeRadioButtonSeleccionado == radioButtontriple.getId()) {
                            tipoparto="triple";
                        }

                        int idDeRadioButtonSeleccionadoproposito = radioGroupTipoproposito.getCheckedRadioButtonId();
                        if (idDeRadioButtonSeleccionadoproposito == radiocria.getId()) {
                           proposito="cria";
                        } if (idDeRadioButtonSeleccionado == radioabasto.getId()) {
                            proposito="abasto";
                        }

                        int idDeRadioButtonSeleccionadogenero = radioGroupTipogenero.getCheckedRadioButtonId();
                        if (idDeRadioButtonSeleccionadogenero == radiohembra.getId()) {
                          genero="hembra";
                        } if (idDeRadioButtonSeleccionado == radiomacho.getId()) {
                          genero="macho";
                        }

                        String nombrecordero = u.getText().toString();
                        String peso = p.getText().toString();
                        String fecha=etPlannedDate.getText().toString();
                        String idfi=idfinca.getText().toString();
                        //add borre
                        Borre bor = new Borre(razas, peso,idfi,fecha,nombrecordero,tipoparto,proposito,genero);

                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        String email = user.getUid() + "/borres";
                        DatabaseReference myRef1 = FirebaseDatabase.getInstance().getReference();
                        DatabaseReference myRef = myRef1.child(email);
                        myRef.push() .setValue(bor);


                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                       addborre.this.getDialog().cancel();
                    }
                });


        return builder.create();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        razas = (String) adapterView.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // vacio

    }
    private void crearDialogoFecha(){
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                fechaSeleccionada = day + " / " + (month + 1 ) + " / " + year;
                etPlannedDate.setText(fechaSeleccionada);
            }
        });

        newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
    }

}
