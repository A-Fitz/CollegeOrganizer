package app.collegeorganizer.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import app.collegeorganizer.DialogFragmentListener;
import app.collegeorganizer.R;
import app.collegeorganizer.activities.Activity_Main;
import app.collegeorganizer.data.ComparisonOperatorType;
import app.collegeorganizer.data.SleepDataCategory;
import app.collegeorganizer.data.Stat;
import app.collegeorganizer.stats_types.EvaluateStats;
import app.collegeorganizer.stats_types.PhysicalActivityStatTypes;
import app.collegeorganizer.stats_types.SleepStatTypes;
import app.collegeorganizer.stats_types.StatEnum;

@SuppressLint("NewApi")
public class Fragment_AddSleepDataStat extends DialogFragment {
    private DialogFragmentListener dialogFragmentListener;

    private SleepDataCategory sleepDataCategory;
    private int indexOfCategory;

    private StatEnum data1enum;
    private StatEnum data2enum;

    private SleepStatTypes data1type;
    private SleepStatTypes data2type;

    private float data1;
    private float data2;

    private ComparisonOperatorType comparisonOperatorType;

    private boolean onlyOneData = true;

    private Spinner edit_dropdown_data1_enum;
    private Spinner edit_data1type;

    private Spinner edit_dropdown_data2_enum;
    private Spinner edit_data2type;

    private Spinner edit_comparison_type;

    private LinearLayout vbox_data2type;
    private LinearLayout vbox_comparisontype;
    private CheckBox edit_checkbox_compareTwo;
    private TextView data_2_textview;

    private ImageButton cancel_button;
    private ImageButton save_button;

    public static Fragment_AddSleepDataStat newInstance() {
        return new Fragment_AddSleepDataStat();
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

    public void setSleepDataCategory(SleepDataCategory sleepDataCategory, int index) {
        this.sleepDataCategory = sleepDataCategory;
        this.indexOfCategory = index;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_edit_sleepdata_stat, container, false);

        edit_dropdown_data1_enum = v.findViewById(R.id.dropdown_data1_enum);
        edit_data1type = v.findViewById(R.id.dropdown_data1type);

        edit_dropdown_data2_enum = v.findViewById(R.id.dropdown_data2_enum);
        edit_data2type = v.findViewById(R.id.dropdown_data2type);

        edit_comparison_type = v.findViewById(R.id.dropdown_comparisonType);
        edit_checkbox_compareTwo = v.findViewById(R.id.checkbox_compareTwo);
        vbox_data2type = v.findViewById(R.id.vbox_data2type);
        vbox_comparisontype = v.findViewById(R.id.vbox_comparisontype);
        data_2_textview = v.findViewById(R.id.data_2_textview);

        cancel_button = v.findViewById(R.id.cancel_button);
        save_button = v.findViewById(R.id.save_button);

        ArrayAdapter<StatEnum> dropdown_data1_enum_adapter = new ArrayAdapter<StatEnum>(getContext(), android.R.layout.simple_spinner_item, StatEnum.values());
        dropdown_data1_enum_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        edit_dropdown_data1_enum.setAdapter(dropdown_data1_enum_adapter);

        ArrayAdapter<SleepStatTypes> data1type_adapter = new ArrayAdapter<SleepStatTypes>(getContext(), android.R.layout.simple_spinner_item, SleepStatTypes.values());
        data1type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        edit_data1type.setAdapter(data1type_adapter);

        ArrayAdapter<StatEnum> dropdown_data2_enum_adapter = new ArrayAdapter<StatEnum>(getContext(), android.R.layout.simple_spinner_item, StatEnum.values());
        dropdown_data2_enum_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        edit_dropdown_data2_enum.setAdapter(dropdown_data2_enum_adapter);

        ArrayAdapter<SleepStatTypes> data2type_adapter = new ArrayAdapter<SleepStatTypes>(getContext(), android.R.layout.simple_spinner_item, SleepStatTypes.values());
        data2type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        edit_data2type.setAdapter(data2type_adapter);

        ArrayAdapter<ComparisonOperatorType> comparison_adapter = new ArrayAdapter<ComparisonOperatorType>(getContext(), android.R.layout.simple_spinner_item, ComparisonOperatorType.values());
        comparison_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        edit_comparison_type.setAdapter(comparison_adapter);

        return v;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edit_checkbox_compareTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onlyOneData = !onlyOneData;
                changeData2Boxes();
            }
        });
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ask if sure TODO
                dismiss();
            }
        });
        edit_dropdown_data1_enum.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                StatEnum chosen = (StatEnum) edit_dropdown_data1_enum.getSelectedItem();

                ArrayAdapter data1type_adapter = null;

                switch (chosen) {

                    case SLEEP:
                        data1type_adapter = new ArrayAdapter<SleepStatTypes>(getContext(), android.R.layout.simple_spinner_item, SleepStatTypes.values());
                        break;
                    case PHYSICAL_ACTIVITY:
                        data1type_adapter = new ArrayAdapter<PhysicalActivityStatTypes>(getContext(), android.R.layout.simple_spinner_item, PhysicalActivityStatTypes.values());
                        break;
                    case SOCIAL_ACTIVITY:
                        //TODO
                        data1type_adapter = new ArrayAdapter<PhysicalActivityStatTypes>(getContext(), android.R.layout.simple_spinner_item, PhysicalActivityStatTypes.values());
                        break;
                    case DIET:
                        //TODO
                        data1type_adapter = new ArrayAdapter<PhysicalActivityStatTypes>(getContext(), android.R.layout.simple_spinner_item, PhysicalActivityStatTypes.values());
                        break;
                }


                data1type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                edit_data1type.setAdapter(data1type_adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        edit_dropdown_data2_enum.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                StatEnum chosen = (StatEnum) edit_dropdown_data2_enum.getSelectedItem();

                ArrayAdapter data2type_adapter = null;

                switch (chosen) {

                    case SLEEP:
                        data2type_adapter = new ArrayAdapter<SleepStatTypes>(getContext(), android.R.layout.simple_spinner_item, SleepStatTypes.values());
                        break;
                    case PHYSICAL_ACTIVITY:
                        data2type_adapter = new ArrayAdapter<PhysicalActivityStatTypes>(getContext(), android.R.layout.simple_spinner_item, PhysicalActivityStatTypes.values());
                        break;
                    case SOCIAL_ACTIVITY:
                        //TODO
                        data2type_adapter = new ArrayAdapter<PhysicalActivityStatTypes>(getContext(), android.R.layout.simple_spinner_item, PhysicalActivityStatTypes.values());
                        break;
                    case DIET:
                        //TODO
                        data2type_adapter = new ArrayAdapter<PhysicalActivityStatTypes>(getContext(), android.R.layout.simple_spinner_item, PhysicalActivityStatTypes.values());
                        break;
                }


                data2type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                edit_data2type.setAdapter(data2type_adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EvaluateStats evaluateStatType = new EvaluateStats();
                if (onlyOneData) {
                    data1enum = (StatEnum) edit_dropdown_data1_enum.getSelectedItem();
                    data1type = (SleepStatTypes) edit_data1type.getSelectedItem();
                    data1 = evaluateStatType.getData((StatEnum) edit_dropdown_data1_enum.getSelectedItem(), data1type);

                    List<Stat> statList = sleepDataCategory.getStatList();

                    statList.add(new Stat(data1type, data1));

                    sleepDataCategory.setStatList(statList);
                    Activity_Main.sleepDataCategoryList.set(indexOfCategory, sleepDataCategory);
                    dismiss();
                } else {
                    data1enum = (StatEnum) edit_dropdown_data1_enum.getSelectedItem();
                    data1type = (SleepStatTypes) edit_data1type.getSelectedItem();
                    data1 = evaluateStatType.getData(data1enum, data1type);

                    data2enum = (StatEnum) edit_dropdown_data2_enum.getSelectedItem();
                    data2type = (SleepStatTypes) edit_data2type.getSelectedItem();
                    data2 = evaluateStatType.getData(data2enum, data1type);

                    comparisonOperatorType = (ComparisonOperatorType) edit_comparison_type.getSelectedItem();

                    List<Stat> statList = sleepDataCategory.getStatList();

                    statList.add(new Stat(data1type, data1, data2type, data2, comparisonOperatorType));

                    sleepDataCategory.setStatList(statList);
                    Activity_Main.sleepDataCategoryList.set(indexOfCategory, sleepDataCategory);
                    dismiss();
                }
            }
        });
    }

    private void changeData2Boxes() {
        if (onlyOneData) {
            vbox_data2type.setVisibility(View.GONE);
            vbox_comparisontype.setVisibility(View.GONE);
            data_2_textview.setVisibility(View.GONE);
        } else {
            vbox_data2type.setVisibility(View.VISIBLE);
            vbox_comparisontype.setVisibility(View.VISIBLE);
            data_2_textview.setVisibility(View.VISIBLE);
        }
    }

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