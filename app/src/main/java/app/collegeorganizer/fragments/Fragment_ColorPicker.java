package app.collegeorganizer.fragments;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import app.collegeorganizer.OnColorChosenListener;
import app.collegeorganizer.R;
import app.collegeorganizer.data.GoogleCalendarColors;

public class Fragment_ColorPicker extends DialogFragment {
    private OnColorChosenListener onColorChosenListener;
    private int color;
    private GoogleCalendarColors goog_colors = new GoogleCalendarColors();

    Button tomato;
    Button flamingo;
    Button tangerine;
    Button banana;
    Button sage;
    Button basil;
    Button peacock;
    Button blueberry;
    Button lavender;
    Button grape;
    Button graphite;

    public void DismissListener(OnColorChosenListener onColorChosenListener) {
        this.onColorChosenListener = onColorChosenListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_color_picker, container, false);

        tomato = (Button) v.findViewById(R.id.tomato);
        flamingo = (Button) v.findViewById(R.id.flamingo);
        tangerine = (Button) v.findViewById(R.id.tangerine);
        banana = (Button) v.findViewById(R.id.banana);
        sage = (Button) v.findViewById(R.id.sage);
        basil = (Button) v.findViewById(R.id.basil);
        peacock = (Button) v.findViewById(R.id.peacock);
        blueberry = (Button) v.findViewById(R.id.blueberry);
        lavender = (Button) v.findViewById(R.id.lavender);
        grape = (Button) v.findViewById(R.id.grape);
        graphite = (Button) v.findViewById(R.id.graphite);

        tomato.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                color = goog_colors.tomato;
                dismiss();
            }
        });

        flamingo.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                color = goog_colors.flamingo;
                dismiss();
            }
        });

        tangerine.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                color = goog_colors.tangerine;
                dismiss();
            }
        });

        banana.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                color = goog_colors.banana;
                dismiss();
            }
        });

        sage.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                color = goog_colors.sage;
                dismiss();
            }
        });

        basil.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                color = goog_colors.basil;
                dismiss();
            }
        });

        peacock.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                color = goog_colors.peacock;
                dismiss();
            }
        });

        blueberry.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                color = goog_colors.blueberry;
                dismiss();
            }
        });

        lavender.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                color = goog_colors.lavender;
                dismiss();
            }
        });

        grape.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                color = goog_colors.grape;
                dismiss();
            }
        });

        graphite.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                color = goog_colors.graphite;
                dismiss();
            }
        });
        return v;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if(onColorChosenListener != null) {
            onColorChosenListener.handleDialogClose(color);
        }

    }
}