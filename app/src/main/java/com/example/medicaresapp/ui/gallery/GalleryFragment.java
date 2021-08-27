package com.example.medicaresapp.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.medicaresapp.AddMedicalActivity;
import com.example.medicaresapp.HealthActivity;
import com.example.medicaresapp.KnowMedicineActivity;
import com.example.medicaresapp.MapsActivity;
import com.example.medicaresapp.R;
import com.example.medicaresapp.SearchMedicalActivity;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

     Button btn_health,btn_addMedical,btn_reminder,btn_searchMedical,btn_knowMedicine,btn_searchHospital;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        ImageSlider imageSlider=root.findViewById(R.id.slider);
        btn_health=root.findViewById(R.id.healthButton);
        btn_addMedical=root.findViewById(R.id.medicalButton);
        btn_reminder=root.findViewById(R.id.reminderButton);
        btn_searchMedical=root.findViewById(R.id.searchButton);
        btn_knowMedicine=root.findViewById(R.id.knowButton);
        btn_searchHospital=root.findViewById(R.id.search_hospitalButton);
        btn_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(), HealthActivity.class);
                startActivity(intent);

            }
        });
        btn_addMedical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), AddMedicalActivity.class);
                startActivity(intent);
            }
        });
        btn_reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"medicine reminder click",Toast.LENGTH_SHORT).show();
            }
        });
        btn_searchMedical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), SearchMedicalActivity.class);
                startActivity(intent);
            }
        });
        btn_knowMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKnow=new Intent(getActivity(), KnowMedicineActivity.class);
                startActivity(intentKnow);

            }
        });
        btn_searchHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);
            }
        });
        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1471864190281-a93a3070b6de?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=600&q=60","stay home"));
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1582719471425-ab68645ba31d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80","stay home"));
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1576089388754-68c54a863b60?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=600&q=60","take care"));
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1576765974102-b756026ecee3?ixlib=rb-1.2.1&auto=format&fit=crop&w=1057&q=80",""));
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1558379466-bed9e35ee7cb?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1121&q=80","stay home"));
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1532187863486-abf9dbad1b69?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80","stay home"));
        slideModels.add(new SlideModel("https://media.parentcircle.com/DATA/postdata/CI-GDCtp1ibS0GeytYHKjrSUg.jpg"));
         imageSlider.setImageList(slideModels,true);

        return root;
    }
}