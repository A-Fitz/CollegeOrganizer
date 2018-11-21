package app.collegeorganizer.data;

import java.util.Calendar;
import java.util.Objects;

public class DietItem {

    private MealCategory mealCategory;
    private String foodName;
    private String amount;
    private Calendar time;
    private int color;

    //temporary units TODO
    private int calories;
    private int total_fat; //g
    private int saturated_fat; //g
    private int trans_fat; //g
    private int cholesterol; //mg
    private int sodium; //mg
    private int total_carbohydrate; //g
    private int dietary_fiber; //g
    private int total_sugars; //g
    private int protein; //g
    private int calcium; //mg
    private int iron; //mg
    private int potassium; //mg

    private int vitamin_a; //mcg
    private int vitamin_b12; //mcg
    private int vitamin_c; //mcg
    private int vitamin_d; //mcg
    private int vitamin_e; //mcg
    private int vitamin_k; //mcg

    public DietItem(String foodName, MealCategory mealCategory, Calendar time, String amount, int color) {
        this.foodName = foodName;
        this.mealCategory = mealCategory;
        this.time = time;
        this.amount = amount;
        this.color = color;
    }

    public MealCategory getMealCategory() {
        return mealCategory;
    }

    public void setMealCategory(MealCategory mealCategory) {
        this.mealCategory = mealCategory;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getTotal_fat() {
        return total_fat;
    }

    public void setTotal_fat(int total_fat) {
        this.total_fat = total_fat;
    }

    public int getSaturated_fat() {
        return saturated_fat;
    }

    public void setSaturated_fat(int saturated_fat) {
        this.saturated_fat = saturated_fat;
    }

    public int getTrans_fat() {
        return trans_fat;
    }

    public void setTrans_fat(int trans_fat) {
        this.trans_fat = trans_fat;
    }

    public int getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(int cholesterol) {
        this.cholesterol = cholesterol;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getTotal_carbohydrate() {
        return total_carbohydrate;
    }

    public void setTotal_carbohydrate(int total_carbohydrate) {
        this.total_carbohydrate = total_carbohydrate;
    }

    public int getDietary_fiber() {
        return dietary_fiber;
    }

    public void setDietary_fiber(int dietary_fiber) {
        this.dietary_fiber = dietary_fiber;
    }

    public int getTotal_sugars() {
        return total_sugars;
    }

    public void setTotal_sugars(int total_sugars) {
        this.total_sugars = total_sugars;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getVitamin_a() {
        return vitamin_a;
    }

    public void setVitamin_a(int vitamin_a) {
        this.vitamin_a = vitamin_a;
    }

    public int getVitamin_b12() {
        return vitamin_b12;
    }

    public void setVitamin_b12(int vitamin_b12) {
        this.vitamin_b12 = vitamin_b12;
    }

    public int getVitamin_c() {
        return vitamin_c;
    }

    public void setVitamin_c(int vitamin_c) {
        this.vitamin_c = vitamin_c;
    }

    public int getVitamin_d() {
        return vitamin_d;
    }

    public void setVitamin_d(int vitamin_d) {
        this.vitamin_d = vitamin_d;
    }

    public int getVitamin_e() {
        return vitamin_e;
    }

    public void setVitamin_e(int vitamin_e) {
        this.vitamin_e = vitamin_e;
    }

    public int getVitamin_k() {
        return vitamin_k;
    }

    public void setVitamin_k(int vitamin_k) {
        this.vitamin_k = vitamin_k;
    }

    public int getCalcium() {
        return calcium;
    }

    public void setCalcium(int calcium) {
        this.calcium = calcium;
    }

    public int getIron() {
        return iron;
    }

    public void setIron(int iron) {
        this.iron = iron;
    }

    public int getPotassium() {
        return potassium;
    }

    public void setPotassium(int potassium) {
        this.potassium = potassium;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }


    public int getMinute() {
        return time.get(Calendar.MINUTE);
    }

    public int getHour() {
        return time.get(Calendar.HOUR);
    }

    public int getDay() {
        return time.get(Calendar.DAY_OF_MONTH);
    }

    public int getMonth() {
        return time.get(Calendar.MONTH);
    }

    public int getYear() {
        return time.get(Calendar.YEAR);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DietItem dietItem = (DietItem) o;
        return color == dietItem.color &&
                calories == dietItem.calories &&
                total_fat == dietItem.total_fat &&
                saturated_fat == dietItem.saturated_fat &&
                trans_fat == dietItem.trans_fat &&
                cholesterol == dietItem.cholesterol &&
                sodium == dietItem.sodium &&
                total_carbohydrate == dietItem.total_carbohydrate &&
                dietary_fiber == dietItem.dietary_fiber &&
                total_sugars == dietItem.total_sugars &&
                protein == dietItem.protein &&
                calcium == dietItem.calcium &&
                iron == dietItem.iron &&
                potassium == dietItem.potassium &&
                vitamin_a == dietItem.vitamin_a &&
                vitamin_b12 == dietItem.vitamin_b12 &&
                vitamin_c == dietItem.vitamin_c &&
                vitamin_d == dietItem.vitamin_d &&
                vitamin_e == dietItem.vitamin_e &&
                vitamin_k == dietItem.vitamin_k &&
                mealCategory == dietItem.mealCategory &&
                Objects.equals(foodName, dietItem.foodName) &&
                Objects.equals(amount, dietItem.amount) &&
                Objects.equals(time, dietItem.time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mealCategory, foodName, amount, time, color, calories, total_fat, saturated_fat, trans_fat, cholesterol, sodium, total_carbohydrate, dietary_fiber, total_sugars, protein, calcium, iron, potassium, vitamin_a, vitamin_b12, vitamin_c, vitamin_d, vitamin_e, vitamin_k);
    }
}
