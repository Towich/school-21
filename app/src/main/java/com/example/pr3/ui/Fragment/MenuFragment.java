package com.example.pr3.ui.Fragment;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.pr3.R;
import com.example.pr3.service.MyService;
import com.example.pr3.ui.Activity.MainActivity;

public class MenuFragment extends Fragment {

    private static final String CHANNEL = "CHANNEL";
    private static final int NOTIFICATION_ID = 101;

    public static final String KEY_TRANSFER_FROM_MENU = "KEY_TRANSFER_FROM_MENU";
    EditText menu_edit_text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Channel
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "21 channel";
            String description = "Канал для школы 21";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL, name, importance);

            channel.setDescription(description);
            NotificationManager notificationManager = requireContext().
                    getSystemService(NotificationManager.class);

            notificationManager.createNotificationChannel(channel);

            Intent notificationIntent = new Intent(getActivity(), MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(),
                    0, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        }

        // Button "Уведомление"
        Button button_notification = view.findViewById(R.id.button_notification);
        button_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Создание уведомления
                NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(),
                        CHANNEL)
                        .setSmallIcon(R.drawable.s21_vector_logo)
                        .setContentTitle("Школа 21")
                        .setContentText("Пора решать задачи!")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                // вызов уведомления
                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(requireContext());
                notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());
            }
        });

        menu_edit_text = view.findViewById(R.id.menu_edit_text);

        Button button_to_tasks = view.findViewById(R.id.button_to_tasks);
        button_to_tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tasksToShow = Integer.parseInt(menu_edit_text.getText().toString());

                Bundle bundle = new Bundle();
                bundle.putInt(KEY_TRANSFER_FROM_MENU, tasksToShow);
                Navigation.findNavController(view).navigate(R.id.action_menuFragment_to_tasksFragment, bundle);
            }
        });

        Button button_to_tests = view.findViewById(R.id.button_to_tests);
        button_to_tests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int testsToShow = Integer.parseInt(menu_edit_text.getText().toString());

                Bundle bundle = new Bundle();
                bundle.putInt(KEY_TRANSFER_FROM_MENU, testsToShow);
                Navigation.findNavController(view).navigate(R.id.action_menuFragment_to_testsFragment, bundle);
            }
        });

        // Сервис-кнопка
        Button button_service = view.findViewById(R.id.button_service);
        button_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), MyService.class);
                getActivity().startService(intent);
            }
        });

        // Кнопка перехода на Task 1
        Button button_task = view.findViewById(R.id.button_task);
        button_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_menuFragment_to_oneTaskFragment);
            }
        });

        // Кнопка перехода на Questions
        Button button_questions = view.findViewById(R.id.button_questions);
        button_questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_menuFragment_to_questionsFragment);
            }
        });

        // Кнопка перехода на Contacts
        Button button_contacts = view.findViewById(R.id.button_contacts);
        button_contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_menuFragment_to_contactsFragment);
            }
        });
    }
}