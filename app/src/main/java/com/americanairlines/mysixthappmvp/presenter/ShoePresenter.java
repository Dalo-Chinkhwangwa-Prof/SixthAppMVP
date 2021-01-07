package com.americanairlines.mysixthappmvp.presenter;

import com.americanairlines.mysixthappmvp.model.Shoe;

import java.util.ArrayList;

import com.americanairlines.mysixthappmvp.model.db.ShoeDatabaseHelper;
import com.americanairlines.mysixthappmvp.presenter.ShoeShopPresenterContract.*;
import com.americanairlines.mysixthappmvp.view.MainActivity;

public class ShoePresenter implements ShoeShopPresenter {

    private ShoeShopView shoeShopView;
    private ShoeDatabaseHelper shoeDatabaseHelper;

    public ShoePresenter(ShoeShopView shoeShopView) {
        this.shoeShopView = shoeShopView;
        shoeDatabaseHelper = new ShoeDatabaseHelper(shoeShopView.getContext());
    }

    @Override
    public void getAllShoes() {

        //Starting a new Thread
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    shoeShopView.displayShoes(shoeDatabaseHelper.getAllShoesFromDatabase());
                } catch (Exception e) {
                    e.printStackTrace();
                    shoeShopView.displayError(e.getMessage());
                }
            }
        }.start();

    }

    @Override
    public void insertShoe(Shoe newShoe) {
    //Starting a new Thread
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    shoeDatabaseHelper.insertNewShoeIntoDatabase(newShoe);
                    shoeShopView.successMessage(newShoe.getShoeModel() + " Inserted!!");
                } catch (Exception e) {
                    e.printStackTrace();
                    shoeShopView.displayError(e.getMessage());
                }
            }
        }.start();
    }

    @Override
    public void deleteShoe(Shoe deleteShoe) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    shoeDatabaseHelper.deleteShoeFromDatabase(deleteShoe);
                    shoeShopView.successMessage(deleteShoe.getShoeModel()+ " DELETED!!");
                } catch (Exception e) {
                    e.printStackTrace();
                    shoeShopView.displayError(e.getMessage());
                }
            }
        }.start();
    }
}









