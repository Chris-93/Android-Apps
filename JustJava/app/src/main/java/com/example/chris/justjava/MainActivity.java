    package com.example.chris.justjava;
    import android.content.Intent;
    import android.net.Uri;
    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.util.Log;
    import android.view.View;
    import android.widget.CheckBox;
    import android.widget.EditText;
    import android.widget.TextView;

    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.view.View;
    import android.widget.TextView;

    import java.text.NumberFormat;

    /**
     * This app displays an order form to order coffee.
     */
    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        /**
         * This method is called when the order button is clicked.
         */


        public void submitOrder(View view) {

            CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
            boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
            CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
            boolean hasChocolate = chocolateCheckBox.isChecked();
            EditText nameField = (EditText) findViewById(R.id.name_field);
            String name = nameField.getText().toString();
           // Log.v("MainActivity", "Has name ? " + name);

            int price = calculatePrice(hasWhippedCream, hasChocolate);
            String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, name);

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for" + name);
            intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }

        int quantity = 2;

        public void increment(View view) {
            quantity = quantity + 1;
            if(quantity >=100){
                display(quantity=100);
            }
            display(quantity);
        }

        public void decrement(View view) {
            quantity = quantity - 1;
            if(quantity<=0){
                display(quantity=0);
            }
            display(quantity);
        }

        /**
         * We calculate the price per cup of coffee
         * @param addChocolate is whether or not the user wants Choco topping
         * @param addWhippedCream is whether the user wants Whipped Cream topping
         * @return total price of coffees with or without the toppings
         */
        private int calculatePrice(boolean addWhippedCream, boolean addChocolate){
            //price per cup of coffee
            int basePrice = 5;
            if (addWhippedCream){
                //price of whipped cream topping
                basePrice = basePrice + 1;
            }
            if (addChocolate){
                //price of chocolate topping
                basePrice = basePrice + 2;
            }
            //total price of coffees with or without the toppings
            int price = quantity * basePrice ;
            return price;
        }

        /**
         * This method displays the given quantity value on the screen.
         */
        private void display(int number) {
            TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
            quantityTextView.setText("" + number);
        }

         /**
         * there are everything we need to show , more easy
         * @param price of the order
         * @param addWhippedCream is whether or not user wants a cream topping
         * @param name the user name
         */
        private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, String name){
            String msg = "Name: " + name;
            msg += "\n: " + getString(R.string.quantity1) + quantity;
            msg += "\n: " + getString(R.string.has_whipped_cream) + addWhippedCream;
            msg += "\n: " + getString(R.string.has_chocolate) + addChocolate;
            msg += "\n: " + getString(R.string.total) + "$" + price;
            msg += "\n" + getString(R.string.thank_you);

            return msg;

           }
    }
