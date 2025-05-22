package vk.autotest.project;

import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.annotation.*;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

public class AddNoteDialog extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_add_note, container, false);
        EditText titleInput = view.findViewById(R.id.editTextTitle);
        EditText contentInput = view.findViewById(R.id.editTextContent);
        Button saveButton = view.findViewById(R.id.saveButton);

        NotesViewModel viewModel = new ViewModelProvider(requireActivity()).get(NotesViewModel.class);

        saveButton.setOnClickListener(v -> {
            String title = titleInput.getText().toString();
            String content = contentInput.getText().toString();
            if (!title.isEmpty()) {
                viewModel.addNote(title, content);
                dismiss();
            }
        });

        return view;
    }
}
