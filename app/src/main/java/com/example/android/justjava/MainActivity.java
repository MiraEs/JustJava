package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to oder coffee
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 0;
    int price = 0;

    /**
     * * This method is called when the order button is clicked
     */
    public void submitOrder(View view) {
        createOrderSummary();
    }

    private int calculatePrice() {
         return quantity * 5;
    }


    private void createOrderSummary() {
        price = calculatePrice();

        String name = "Name: Kaptain Kunal";
        String priceMessage = "\nQuantity: " + quantity + "\nTotal: $" + price;
        displayMessage(name + priceMessage + "\nThank you!");
    }

    /**
     * This method is called to increment quantity value.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * This method is called to decrement quantity value when '+' button is tapped.
     */
    public void decrement(View view) {
        if (quantity < 1) {
            quantity = 0;
        } else {
            quantity = quantity - 1;
        }
        display(quantity);
    }

    /**
     * This method displays the given quantity value when '-' button is tapped.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}
