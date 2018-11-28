package app.collegeorganizer.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import app.collegeorganizer.DialogFragmentListener;
import app.collegeorganizer.R;
import app.collegeorganizer.data.GoogleCalendarColors;

public class Fragment_ColorPicker extends DialogFragment {
    private DialogFragmentListener dialogFragmentListener;
    private int color;

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

    public void DismissListener(DialogFragmentListener dialogFragmentListener) {
        this.dialogFragmentListener = dialogFragmentListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_color_picker, container, false);

        tomato = v.findViewById(R.id.tomato);
        flamingo = v.findViewById(R.id.flamingo);
        tangerine = v.findViewById(R.id.tangerine);
        banana = v.findViewById(R.id.banana);
        sage = v.findViewById(R.id.sage);
        basil = v.findViewById(R.id.basil);
        peacock = v.findViewById(R.id.peacock);
        blueberry = v.findViewById(R.id.blueberry);
        lavender = v.findViewById(R.id.lavender);
        grape = v.findViewById(R.id.grape);
        graphite = v.findViewById(R.id.graphite);

        tomato.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                color = GoogleCalendarColors.tomato;
                dismiss();
            }
        });

        flamingo.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                color = GoogleCalendarColors.flamingo;
                dismiss();
            }
        });

        tangerine.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                color = GoogleCalendarColors.tangerine;
                dismiss();
            }
        });

        banana.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                color = GoogleCalendarColors.banana;
                dismiss();
            }
        });

        sage.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                color = GoogleCalendarColors.sage;
                dismiss();
            }
        });

        basil.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                color = GoogleCalendarColors.basil;
                dismiss();
            }
        });

        peacock.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                color = GoogleCalendarColors.peacock;
                dismiss();
            }
        });

        blueberry.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                color = GoogleCalendarColors.blueberry;
                dismiss();
            }
        });

        lavender.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                color = GoogleCalendarColors.lavender;
                dismiss();
            }
        });

        grape.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                color = GoogleCalendarColors.grape;
                dismiss();
            }
        });

        graphite.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                color = GoogleCalendarColors.graphite;
                dismiss();
            }
        });
        return v;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (dialogFragmentListener != null) {
            dialogFragmentListener.handleDialogClose(color);
        }

    }
}