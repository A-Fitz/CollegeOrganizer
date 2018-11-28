package app.collegeorganizer.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import app.collegeorganizer.DialogFragmentListener;
import app.collegeorganizer.R;
import app.collegeorganizer.activities.Activity_Main;
import app.collegeorganizer.data.DietItem;
import app.collegeorganizer.data.MealCategory;

@SuppressLint("NewApi")
public class Fragment_EditDietRecord extends DialogFragment {

    private DietItem item;

    private String foodName;
    private String amount;
    private Calendar time = Calendar.getInstance();
    private MealCategory mealCategory;
    private int color;

    private int calories;
    private int total_fat;
    private int saturated_fat;
    private int trans_fat;
    private int cholesterol;
    private int sodium;
    private int total_carbohydrate;
    private int dietary_fiber;
    private int total_sugars;
    private int protein;
    private int calcium;
    private int iron;
    private int potassium;
    private int vitamin_a;
    private int vitamin_b12;
    private int vitamin_c;
    private int vitamin_d;
    private int vitamin_e;
    private int vitamin_k;


    private EditText edit_foodName;
    private EditText edit_amount;
    private EditText edit_time;
    private EditText edit_date;
    private Spinner edit_mealCategory;
    private EditText edit_calories;
    private EditText edit_total_fat;
    private EditText edit_saturated_fat;
    private EditText edit_trans_fat;
    private EditText edit_cholesterol;
    private EditText edit_sodium;
    private EditText edit_total_carbohydrate;
    private EditText edit_dietary_fiber;
    private EditText edit_total_sugars;
    private EditText edit_protein;
    private EditText edit_calcium;
    private EditText edit_iron;
    private EditText edit_potassium;
    private EditText edit_vitamin_a;
    private EditText edit_vitamin_b12;
    private EditText edit_vitamin_c;
    private EditText edit_vitamin_d;
    private EditText edit_vitamin_e;
    private EditText edit_vitamin_k;

    private Button color_button;

    private ImageButton delete_button;
    private ImageButton cancel_button;
    private ImageButton save_button;

    private Calendar temp_time = Calendar.getInstance();
    private int temp_color = 0;

    private SimpleDateFormat format_time = new SimpleDateFormat("hh:mm a");
    private SimpleDateFormat format_date = new SimpleDateFormat("MM/dd/yyy");

    String[] dropdown_intensity_items = {"Breakfast", "Lunch", "Dinner", "Snack", "Brunch"};

    public static Fragment_EditDietRecord newInstance() {
        return new Fragment_EditDietRecord();
    }

    private void getItemParts() {
        foodName = item.getFoodName();
        amount = item.getAmount();
        time = item.getTime();
        mealCategory = item.getMealCategory();
        color = item.getColor();

        calories = item.getCalories();
        total_fat = item.getTotal_fat();
        saturated_fat = item.getSaturated_fat();
        trans_fat = item.getTrans_fat();
        cholesterol = item.getCholesterol();
        sodium = item.getSodium();
        total_carbohydrate = item.getTotal_carbohydrate();
        dietary_fiber = item.getDietary_fiber();
        total_sugars = item.getTotal_sugars();
        protein = item.getProtein();
        calcium = item.getCalcium();
        iron = item.getIron();
        potassium = item.getPotassium();
        vitamin_a = item.getVitamin_a();
        vitamin_b12 = item.getVitamin_b12();
        vitamin_c = item.getVitamin_c();
        vitamin_d = item.getVitamin_d();
        vitamin_e = item.getVitamin_e();
        vitamin_k = item.getVitamin_k();
    }

    private void setInitialValues() {
        edit_foodName.setText(foodName);
        edit_amount.setText(amount);
        edit_time.setText(String.valueOf(format_time.format(time.getTime())));
        temp_time = time;
        edit_date.setText(String.valueOf(format_date.format(time.getTime())));
        edit_mealCategory.setSelection(getMealCategoryPosition());
        color_button.setBackgroundColor(color);
        temp_color = color;

        if (calories != 0)
            edit_calories.setText(String.valueOf(calories));
        if (total_fat != 0)
            edit_total_fat.setText(String.valueOf(total_fat));
        if (saturated_fat != 0)
            edit_saturated_fat.setText(String.valueOf(saturated_fat));
        if (trans_fat != 0)
            edit_trans_fat.setText(String.valueOf(trans_fat));
        if (cholesterol != 0)
            edit_cholesterol.setText(String.valueOf(cholesterol));
        if (sodium != 0)
            edit_sodium.setText(String.valueOf(sodium));
        if (total_carbohydrate != 0)
            edit_total_carbohydrate.setText(String.valueOf(total_carbohydrate));
        if (dietary_fiber != 0)
            edit_dietary_fiber.setText(String.valueOf(dietary_fiber));
        if (total_sugars != 0)
            edit_total_sugars.setText(String.valueOf(total_sugars));
        if (protein != 0)
            edit_protein.setText(String.valueOf(protein));
        if (calcium != 0)
            edit_calcium.setText(String.valueOf(calcium));
        if (iron != 0)
            edit_iron.setText(String.valueOf(iron));
        if (potassium != 0)
            edit_potassium.setText(String.valueOf(potassium));
        if (vitamin_a != 0)
            edit_vitamin_a.setText(String.valueOf(vitamin_a));
        if (vitamin_b12 != 0)
            edit_vitamin_a.setText(String.valueOf(vitamin_b12));
        if (vitamin_c != 0)
            edit_vitamin_a.setText(String.valueOf(vitamin_c));
        if (vitamin_d != 0)
            edit_vitamin_a.setText(String.valueOf(vitamin_d));
        if (vitamin_e != 0)
            edit_vitamin_a.setText(String.valueOf(vitamin_e));
        if (vitamin_k != 0)
            edit_vitamin_a.setText(String.valueOf(vitamin_k));
    }

    public void setItem(DietItem item) {
        this.item = item;
    }

    private int getMealCategoryPosition() {
        switch (mealCategory) {
            case BREAKFAST:
                return 0;
            case LUNCH:
                return 1;
            case DINNER:
                return 2;
            case SNACK:
                return 3;
            case BRUNCH:
                return 4;
            default:
                return -1;
        }
    }

    @Override
    public void onDismiss(final DialogInterface dialog) {
        super.onDismiss(dialog);
        final Activity activity = getActivity();
        if (activity instanceof DialogInterface.OnDismissListener) {
            ((DialogInterface.OnDismissListener) activity).onDismiss(dialog);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_edit_diet_record, container, false);

        edit_foodName = v.findViewById(R.id.textinput_food_name);
        edit_amount = v.findViewById(R.id.textinput_amount);
        edit_time = v.findViewById(R.id.textinput_time);
        edit_date = v.findViewById(R.id.textinput_date);
        edit_mealCategory = v.findViewById(R.id.meal_category_dropdown);
        edit_calories = v.findViewById(R.id.calories);
        edit_total_fat = v.findViewById(R.id.total_fat);
        edit_saturated_fat = v.findViewById(R.id.saturated_fat);
        edit_trans_fat = v.findViewById(R.id.trans_fat);
        edit_cholesterol = v.findViewById(R.id.cholesterol);
        edit_sodium = v.findViewById(R.id.sodium);
        edit_total_carbohydrate = v.findViewById(R.id.total_carbohydrate);
        edit_dietary_fiber = v.findViewById(R.id.dietary_fiber);
        edit_total_sugars = v.findViewById(R.id.total_sugars);
        edit_protein = v.findViewById(R.id.protein);
        edit_calcium = v.findViewById(R.id.calcium);
        edit_iron = v.findViewById(R.id.iron);
        edit_potassium = v.findViewById(R.id.potassium);
        edit_vitamin_a = v.findViewById(R.id.vitamin_a);
        edit_vitamin_b12 = v.findViewById(R.id.vitamin_b12);
        edit_vitamin_c = v.findViewById(R.id.vitamin_c);
        edit_vitamin_d = v.findViewById(R.id.vitamin_d);
        edit_vitamin_e = v.findViewById(R.id.vitamin_e);
        edit_vitamin_k = v.findViewById(R.id.vitamin_k);

        color_button = v.findViewById(R.id.color_button);

        delete_button = v.findViewById(R.id.delete_button);
        cancel_button = v.findViewById(R.id.cancel_button);
        save_button = v.findViewById(R.id.save_button);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, dropdown_intensity_items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        edit_mealCategory.setAdapter(adapter);

        delete_button.setVisibility(View.VISIBLE);

        getItemParts();
        setInitialValues();

        return v;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edit_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });
        color_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showColorPicker();
            }
        });
        edit_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker();
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ask if sure TODO
                Activity_Main.dietItemList.remove(item);
                dismiss();
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
                    foodName = edit_foodName.getText().toString();
                    amount = edit_amount.getText().toString();
                    time = temp_time;
                    switch (edit_mealCategory.getSelectedItem().toString()) {
                        case "Breakfast":
                            mealCategory = MealCategory.BREAKFAST;
                            break;
                        case "Lunch":
                            mealCategory = MealCategory.LUNCH;
                            break;
                        case "Dinner":
                            mealCategory = MealCategory.DINNER;
                            break;
                        case "Snack":
                            mealCategory = MealCategory.SNACK;
                            break;
                        case "Brunch":
                            mealCategory = MealCategory.BRUNCH;
                            break;
                    }
                    color = temp_color;
                    DietItem di = new DietItem(foodName, mealCategory, time, amount, color);

                    if (!edit_calories.getText().toString().matches("")) {
                        calories = Integer.parseInt(edit_calories.getText().toString());
                        di.setCalories(calories);
                    }
                    if (!edit_total_fat.getText().toString().matches("")) {
                        total_fat = Integer.parseInt(edit_total_fat.getText().toString());
                        di.setTotal_fat(total_fat);
                    }
                    if (!edit_saturated_fat.getText().toString().matches("")) {
                        saturated_fat = Integer.parseInt(edit_saturated_fat.getText().toString());
                        di.setSaturated_fat(saturated_fat);
                    }
                    if (!edit_trans_fat.getText().toString().matches("")) {
                        trans_fat = Integer.parseInt(edit_trans_fat.getText().toString());
                        di.setTrans_fat(trans_fat);
                    }
                    if (!edit_cholesterol.getText().toString().matches("")) {
                        cholesterol = Integer.parseInt(edit_cholesterol.getText().toString());
                        di.setCholesterol(cholesterol);
                    }
                    if (!edit_sodium.getText().toString().matches("")) {
                        sodium = Integer.parseInt(edit_sodium.getText().toString());
                        di.setSodium(sodium);
                    }
                    if (!edit_total_carbohydrate.getText().toString().matches("")) {
                        total_carbohydrate = Integer.parseInt(edit_total_carbohydrate.getText().toString());
                        di.setTotal_carbohydrate(total_carbohydrate);
                    }
                    if (!edit_dietary_fiber.getText().toString().matches("")) {
                        dietary_fiber = Integer.parseInt(edit_dietary_fiber.getText().toString());
                        di.setDietary_fiber(dietary_fiber);
                    }
                    if (!edit_total_sugars.getText().toString().matches("")) {
                        total_sugars = Integer.parseInt(edit_total_sugars.getText().toString());
                        di.setTotal_sugars(total_sugars);
                    }
                    if (!edit_protein.getText().toString().matches("")) {
                        protein = Integer.parseInt(edit_protein.getText().toString());
                        di.setProtein(protein);
                    }
                    if (!edit_calcium.getText().toString().matches("")) {
                        calcium = Integer.parseInt(edit_calcium.getText().toString());
                        di.setCalcium(calcium);
                    }
                    if (!edit_iron.getText().toString().matches("")) {
                        iron = Integer.parseInt(edit_iron.getText().toString());
                        di.setIron(iron);
                    }
                    if (!edit_potassium.getText().toString().matches("")) {
                        potassium = Integer.parseInt(edit_potassium.getText().toString());
                        di.setPotassium(potassium);
                    }
                    if (!edit_vitamin_a.getText().toString().matches("")) {
                        vitamin_a = Integer.parseInt(edit_vitamin_a.getText().toString());
                        di.setVitamin_a(vitamin_a);
                    }
                    if (!edit_vitamin_b12.getText().toString().matches("")) {
                        vitamin_b12 = Integer.parseInt(edit_vitamin_b12.getText().toString());
                        di.setVitamin_b12(vitamin_b12);
                    }
                    if (!edit_vitamin_c.getText().toString().matches("")) {
                        vitamin_c = Integer.parseInt(edit_vitamin_c.getText().toString());
                        di.setVitamin_c(vitamin_c);
                    }
                    if (!edit_vitamin_d.getText().toString().matches("")) {
                        vitamin_d = Integer.parseInt(edit_vitamin_d.getText().toString());
                        di.setVitamin_d(vitamin_d);
                    }
                    if (!edit_vitamin_e.getText().toString().matches("")) {
                        vitamin_e = Integer.parseInt(edit_vitamin_e.getText().toString());
                        di.setVitamin_e(vitamin_e);
                    }
                    if (!edit_vitamin_k.getText().toString().matches("")) {
                        vitamin_k = Integer.parseInt(edit_vitamin_k.getText().toString());
                        di.setVitamin_k(vitamin_k);
                    }

                    int index = Activity_Main.dietItemList.indexOf(item);

                    Activity_Main.dietItemList.set(index, di);

                    dismiss();
                } else {
                    Toast.makeText(getContext(), "Please make sure all fields above the save button are filled.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private boolean checkInput() {
        boolean mainFields = (!isEditTextEmpty(edit_foodName) && !isEditTextEmpty(edit_amount) && !isEditTextEmpty(edit_date) && !isEditTextEmpty(edit_time) && temp_color != 0);
        return mainFields;
    }

    private boolean isEditTextEmpty(EditText et) {
        return (et.getText().toString().matches(""));
    }

    private void showDatePicker() {
        Fragment_DatePicker date = new Fragment_DatePicker();
        /**
         * Set Up Current Date Into dialog
         */
        Calendar calender = Calendar.getInstance();
        Bundle args = new Bundle();
        args.putInt("year", calender.get(Calendar.YEAR));
        args.putInt("month", calender.get(Calendar.MONTH));
        args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));
        date.setArguments(args);
        /**
         * Set Call back to capture selected date
         */
        date.setCallBack(date_listener);
        date.show(getFragmentManager(), "Date Picker");
    }

    private void showColorPicker() {
        Fragment_ColorPicker color_picker = new Fragment_ColorPicker();
        color_picker.show(getFragmentManager(), "Color Picker");
        color_picker.DismissListener(color_picker_closeListener);
    }

    private void showTimePicker() {
        Fragment_TimePicker time = new Fragment_TimePicker();
        /**
         * Set Up Current Date Into dialog
         */
        Calendar calender = Calendar.getInstance();
        Bundle args = new Bundle();
        args.putInt("hour", calender.get(Calendar.HOUR_OF_DAY));
        args.putInt("minute", calender.get(Calendar.MINUTE));
        time.setArguments(args);
        /**
         * Set Call back to capture selected date
         */
        time.setCallBack(ontime);
        time.show(getFragmentManager(), "Time Picker");
    }

    DatePickerDialog.OnDateSetListener date_listener = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            temp_time.set(Calendar.YEAR, year);
            temp_time.set(Calendar.MONTH, monthOfYear);
            temp_time.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            edit_date.setText(format_date.format(temp_time.getTime()));
        }
    };

    DialogFragmentListener color_picker_closeListener = new DialogFragmentListener() {
        @Override
        public void handleDialogClose(int color) {
            temp_color = color;
            color_button.setBackgroundColor(color);
        }
    };


    TimePickerDialog.OnTimeSetListener ontime = new TimePickerDialog.OnTimeSetListener() {

        public void onTimeSet(TimePicker view, int hour, int minute) {
            temp_time.set(Calendar.HOUR_OF_DAY, hour);
            temp_time.set(Calendar.MINUTE, minute);

            edit_time.setText(String.valueOf(format_time.format(temp_time.getTime())));
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
}