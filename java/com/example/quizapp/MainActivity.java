package com.example.quizapp;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {
    
    private Button falseButton;
    private Button trueButton;
    private ImageButton nextButton;
    private ImageButton prevButton;
    private ImageView Image;
    private TextView questionTextView;
    private int correct = 0;
    
    private int currentQuestionIndex = 0;

    private Question[] questionBank = new Question[] {
            
            
            // oikeat vastaukset
            new Question(R.string.a, true),
            new Question(R.string.b, false),
            new Question(R.string.c, true),
            new Question(R.string.d, true),
            new Question(R.string.e, true),
            new Question(R.string.f, false),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        nextButton = findViewById(R.id.next_button);
        prevButton = findViewById(R.id.prev_button);
        //events
        questionTextView
                = findViewById(R.id.answer_text_view);
        Image = findViewById(R.id.myimage);
        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v)
    {
        // tarkistaa mikä nappi on painettuna
        //tässä valittuna 'false' 
        switch (v.getId()) {
            case R.id.false_button:
                checkAnswer(false);
                break;

            case R.id.true_button:
                checkAnswer(true);
                break;

            case R.id.next_button:
                // seuraavaan kysymykseen
                
                if (currentQuestionIndex < 7) {
                    currentQuestionIndex
                            = currentQuestionIndex + 1;
                    
                    // nappulat pois näkyvistä
                    
                    if (currentQuestionIndex == 6) {
                        questionTextView.setText(getString(
                                R.string.correct, correct));
                        nextButton.setVisibility(
                                View.INVISIBLE);
                        prevButton.setVisibility(
                                View.INVISIBLE);
                        trueButton.setVisibility(
                                View.INVISIBLE);
                        falseButton.setVisibility(
                                View.INVISIBLE);
                        if (correct > 3)

                            questionTextView.setText(
                                    "CORRECTNESS IS " + correct
                                            + " "
                                            + "OUT OF 6");
                            // näytetään pisteet
                        else
                            Image.setImageResource(
                                    R.drawable.mainpicture);
                        // jos pisteet <3 näytetään peukku alas
                    }
                    else {
                        updateQuestion();
                    }
                }

                break;
            case R.id.prev_button:
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex
                            = (currentQuestionIndex - 1)
                            % questionBank.length;
                    updateQuestion();
                }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void updateQuestion()
    {
        Log.d("Current",
                "onClick: " + currentQuestionIndex);

        questionTextView.setText(
                questionBank[currentQuestionIndex]
                        .getAnswerResId());

        switch (currentQuestionIndex) {
            case 1:
                // kuvat kysymyksille
                //
                Image.setImageResource(R.drawable.baletti);
                break;
            case 2:
                Image.setImageResource(R.drawable.lemmikki);
                break;
            case 3:
                Image.setImageResource(R.drawable.italia);
                break;
            case 4:
                Image.setImageResource(R.drawable.kesa);
                break;
            case 5:
                Image.setImageResource(R.drawable.kissa);
                break;
            case 6:
                Image.setImageResource(R.drawable.mainpicture);
                break;
            case 7:
                Image.setImageResource(R.drawable.mainpicture);
                break;
        }
    }
    private void checkAnswer(boolean userChooseCorrect)
    {
        boolean answerIsTrue
                = questionBank[currentQuestionIndex]
                .isAnswerTrue();
        // hakee oikean vastauksen tietylle kysymykselle
        int toastMessageId;
        // jos vastaus vastaa painettua nappia

        if (userChooseCorrect == answerIsTrue) {
            toastMessageId = R.string.correct_answer;
            correct++;
        }
        else {
            
            toastMessageId = R.string.wrong_answer;
        }

        Toast
                .makeText(MainActivity.this, toastMessageId,
                        Toast.LENGTH_SHORT)
                .show();
    }
}
