package net.nicoledambra.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static final int limit = 100;
    static int randomNumber;


    public void generateRandomNumber(){
        Random rand = new Random();
        randomNumber = (rand.nextInt(limit)) + 1;
        Log.i("Guess", "The number to guess is - " + randomNumber);
    }
    public void guessNumber(View view) {
        EditText guessEditText = findViewById(R.id.numberEditText);

        int numberGuess = 0;
        try {
            numberGuess = Integer.parseInt(guessEditText.getText().toString());
            Log.i("Guess", "User guessed " + numberGuess);
        } catch(NumberFormatException nfe) {
            Log.e("Guess", "Could not parse "+nfe);
            Toast.makeText(MainActivity.this, "Invalid entry", Toast.LENGTH_SHORT).show();
        }

        String message;
        if(numberGuess > randomNumber) {
            message = "Lower!";
        } else if(numberGuess < randomNumber){
            message = "Higher!";
        }else {
            message = "You got it! Try again!";
            generateRandomNumber();
        }

        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateRandomNumber();

    }


}
