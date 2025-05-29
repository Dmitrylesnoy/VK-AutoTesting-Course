package vk.autotest.project;

import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.annotation.*;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import vk.autotest.project.noteView.NotesViewModel;

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
            if (title.isEmpty()) {
                Toast.makeText(getContext(), "Заголовок не может быть пустым", Toast.LENGTH_SHORT).show();
            } else if (title.length() > 50) {
                Toast.makeText(getContext(), "Заголовок слишком длинный", Toast.LENGTH_SHORT).show();
            } else {
                viewModel.addNote(title, content);
                dismiss();
            }
        });
        return view;
    }
}
