package com.americanairlines.mysixthappmvp.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.widget.Toast;

import com.americanairlines.mysixthappmvp.R;
import com.americanairlines.mysixthappmvp.model.Shoe;
import com.americanairlines.mysixthappmvp.presenter.ShoePresenter;
import com.americanairlines.mysixthappmvp.presenter.ShoeShopPresenterContract.*;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ShoeShopView {

    private ShoeShopPresenter shoePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shoePresenter = new ShoePresenter(this);
        shoePresenter.getAllShoes();

//        shoePresenter.insertShoe(new Shoe(10, "Jordan 1 Retro", 110.99));
//        shoePresenter.insertShoe(new Shoe(10, "Clarks", 170.99));
//        shoePresenter.insertShoe(new Shoe(10, "Dalo 2 Classic", 89.99));
//        shoePresenter.insertShoe(new Shoe(10, "Nike AF 1 Low", 99.99));

        shoePresenter.getAllShoes();
    }



    @Override
    public void displayShoes(List<Shoe> allShoes) {
        Log.d("TAG_X", "All  Shoes: " + allShoes.size());
        //ListView....Display SHOES.....
    }

    @Override
    public void displayError(String errorMessage) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                new AlertDialog
                        .Builder(new ContextThemeWrapper(MainActivity.this, R.style.Theme_MySixthAppMVP))
                        .setTitle("Database Error")
                        .setMessage(errorMessage)
                        .setNegativeButton("Oh no!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).create()
                        .show();
            }
        });
    }

    @Override
    public void successMessage(String successMessage) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new AlertDialog
                        .Builder(new ContextThemeWrapper(MainActivity.this, R.style.Theme_MySixthAppMVP))
                        .setTitle("Database Success")
                        .setMessage(successMessage)
                        .setNegativeButton("Thanks!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).create()
                        .show();

            }
        });

    }

    @Override
    public Context getContext() {
        return this;
    }
}















