package vk.autotest.project;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private NotesViewModel viewModel;
    private NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(NotesViewModel.class);
        RecyclerView recyclerView = findViewById(R.id.notesRecyclerView);
        adapter = new NotesAdapter(viewModel);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.addNoteFab);
        fab.setOnClickListener(v -> new AddNoteDialog().show(getSupportFragmentManager(), "AddNoteDialog"));

        viewModel.getNotes().observe(this, adapter::submitList);
    }
}
