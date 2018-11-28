package app.collegeorganizer.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import app.collegeorganizer.DialogFragmentListener;
import app.collegeorganizer.R;
import app.collegeorganizer.activities.Activity_Main;
import app.collegeorganizer.data.SleepDataCategory;

@SuppressLint("NewApi")
public class Fragment_AddSleepDataCategory extends DialogFragment {
    private DialogFragmentListener dialogFragmentListener;

    private String name;
    private int color;

    private EditText edit_name;

    private Button color_button;

    private ImageButton cancel_button;
    private ImageButton save_button;

    private int temp_color = 0;

    public static Fragment_AddSleepDataCategory newInstance() {
        return new Fragment_AddSleepDataCategory();
    }

    @Override
    public void onDismiss(final DialogInterface dialog) {
        super.onDismiss(dialog);
        final Activity activity = getActivity();
        if (activity instanceof DialogInterface.OnDismissListener) {
            ((DialogInterface.OnDismissListener) activity).onDismiss(dialog);
        }
        if (dialogFragmentListener != null) {
            dialogFragmentListener.handleDialogClose(0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_edit_sleepdata_category, container, false);

        edit_name = v.findViewById(R.id.textinput_category_name);

        color_button = v.findViewById(R.id.color_button);

        cancel_button = v.findViewById(R.id.cancel_button);
        save_button = v.findViewById(R.id.save_button);

        return v;
    }


    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        color_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showColorPicker();
            }
        });
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ask if sure TODO
                dismiss();
            }
        });
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkInput()) {
                    name = edit_name.getText().toString();
                    color = temp_color;

                    SleepDataCategory s = new SleepDataCategory(name, color);

                    Activity_Main.sleepDataCategoryList.add(s);

                    dismiss();
                } else {
                    Toast.makeText(getContext(), "Please make sure all fields above the save button are filled.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private boolean checkInput() {
        boolean mainFields = (!isEditTextEmpty(edit_name) && temp_color != 0);
        return mainFields;
    }

    private boolean isEditTextEmpty(EditText et) {
        return (et.getText().toString().matches(""));
    }

    private void showColorPicker() {
        Fragment_ColorPicker color_picker = new Fragment_ColorPicker();
        color_picker.show(getFragmentManager(), "Color Picker");
        color_picker.DismissListener(color_picker_closeListener);
    }

    DialogFragmentListener color_picker_closeListener = new DialogFragmentListener() {
        @Override
        public void handleDialogClose(int color) {
            temp_color = color;
            color_button.setBackgroundColor(color);
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
    }

    public void DismissListener(DialogFragmentListener dialogFragmentListener) {
        this.dialogFragmentListener = dialogFragmentListener;
    }
}