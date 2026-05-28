package com.example.practinepos;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.practinepos.data.AppDatabase;
import com.example.practinepos.data.ItemEntity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InsertKategoriFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InsertKategoriFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InsertKategoriFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InsertKategoriFragment newInstance(String param1, String param2) {
        InsertKategoriFragment fragment = new InsertKategoriFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public InsertKategoriFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert_kategori, container, false);
        MaterialButton btnBack = view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            ((HomeActivity) requireActivity()).replaceFragment(new ProductsFragment());
            ((HomeActivity) requireActivity()).showBottomNav(true);
        });
        TextInputEditText kategori = view.findViewById(R.id.etInputKategori);
        MaterialButton btnSimpan = view.findViewById(R.id.btnSimpanKategori);

        btnSimpan.setOnClickListener(v -> {
            String valueInputKategori = kategori.getText().toString();
            submitInsert(valueInputKategori);
            kategori.setText("");
        });

        return view;
    }

    protected void submitInsert(String nama){
        if (Objects.equals(nama, "")){
            Toast.makeText(requireContext(), "Isi input kategori", Toast.LENGTH_SHORT).show();
            return;
        }
        AppDatabase.getInstance(getContext()).itemDao().insert(new ItemEntity(nama));
        Toast.makeText(requireContext(), "Berhasil!", Toast.LENGTH_LONG).show();

    }
}