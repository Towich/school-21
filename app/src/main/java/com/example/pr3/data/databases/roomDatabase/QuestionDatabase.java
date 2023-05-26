package com.example.pr3.data.databases.roomDatabase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.pr3.data.databases.dao.QuestionDao;
import com.example.pr3.data.databases.entity.QuestionEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {QuestionEntity.class}, version = 1, exportSchema = false)
public abstract class QuestionDatabase extends RoomDatabase {
    public abstract QuestionDao questionDao();

    private static volatile QuestionDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static QuestionDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (QuestionDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            QuestionDatabase.class, "questions_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                QuestionDao dao = INSTANCE.questionDao();
                dao.deleteAll();
                dao.insert(new QuestionEntity("Какую роль играет элемент Dao в библиотеке Room?"));
                dao.insert(new QuestionEntity("Фамилия имя отчество преподавателя?"));
            });
        }
    };
}
