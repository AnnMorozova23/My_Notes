package com.example.my_notes.ui.list.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.my_notes.R;
import com.example.my_notes.ui.list.OnBackPressed;
import com.example.my_notes.ui.list.Router;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainFragment extends Fragment implements RouterHolder, OnBackPressed {

    @Override
    public Router getRouter() {
        return router;
    }

    public MainFragment() {
        super(R.layout.fragment_main);
    }

    private Router router;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        router = new Router(getChildFragmentManager());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState == null) {
         router.showNotesList();
        }

        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottom_nav_view);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.action_notes) {
                    router.showNotesList();
                    return true;
                }

                if (item.getItemId() == R.id.action_info) {
                    router.showInfo();

                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onBackPressed() {
        if(getChildFragmentManager().getBackStackEntryCount()>0){
            getChildFragmentManager().popBackStack();
            return true;
        }
        return false;
    }
}
