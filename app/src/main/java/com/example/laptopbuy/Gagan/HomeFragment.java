package com.example.laptopbuy.Gagan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laptopbuy.Gagan.AdapterProducts;
import com.example.laptopbuy.Gagan.LoginActivity;
import com.example.laptopbuy.Gagan.ModelProducts;
import com.example.laptopbuy.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
/**
 * THis fragment is used to show products
 */

public class HomeFragment extends Fragment {

    List<ModelProducts> modelProducts= new ArrayList<>();
    NavController navController;

    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;

    RecyclerView recyclerView;
    AdapterProducts adapterProducts;



    public HomeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        ///NavHostFragment navHostFragment= (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.Fragment_container);
        //navController = navHostFragment.getNavController();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.ProductRecycler);

        ProductDataLoadingFunction();
    }
    /**
     * THis method is to get data from firestore
     */
    public void ProductDataLoadingFunction() {

        firebaseFirestore.collection("Products").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()){
                        String productName = (String) documentSnapshot.getData().get("productName");
                        String productDescription= (String) documentSnapshot.getData().get("productDescription");
                        String productPrice= (String) documentSnapshot.getData().get("productPrice");
                        String productImage= (String) documentSnapshot.getData().get("productImage");
                        String productManufacturer= (String) documentSnapshot.getData().get("productManufacturer");
                        String productMemory= (String) documentSnapshot.getData().get("productMemory");
                        String productStorage= (String) documentSnapshot.getData().get("productStorage");
                        String productCPU= (String) documentSnapshot.getData().get("productCPU");
                        String productGPU= (String) documentSnapshot.getData().get("productGPU");


                        modelProducts.add(new ModelProducts(productName,productDescription,productPrice,productManufacturer,productMemory, productStorage,productImage,  productCPU, productGPU));

                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), RecyclerView.VERTICAL, false);
                        recyclerView.setLayoutManager(layoutManager);
                        adapterProducts = new AdapterProducts(modelProducts, getActivity());
                        recyclerView.setAdapter(adapterProducts);


                    }
                }

            }
        });
    }


}

