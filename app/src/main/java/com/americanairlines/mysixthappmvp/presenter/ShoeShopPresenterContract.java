package com.americanairlines.mysixthappmvp.presenter;

import android.content.Context;

import com.americanairlines.mysixthappmvp.model.Shoe;

import java.util.List;

public interface ShoeShopPresenterContract {

    interface ShoeShopPresenter {
        void getAllShoes();
        void insertShoe(Shoe newShoe);
        void deleteShoe(Shoe deleteShoe);
    }

    interface ShoeShopView {
        void displayShoes(List<Shoe> allShoes);
        void displayError(String errorMessage);
        void successMessage(String successMessage);
        Context getContext();
    }

}
