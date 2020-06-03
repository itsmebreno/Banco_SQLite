package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            SQLiteDatabase bancoSqlite = openOrCreateDatabase(name:"projeto",MODE_PRIVATE, factory:null);
            //CREATING TABLE:
            bancoSqlite.execSQL("CREATE TABLE IF NOT EXISTS pessoas(nome VARCHAR, idade INT(3))");

            //INSERT INTO PESSOAS
            bancoSqlite.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Breno', 21)");
            bancoSqlite.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Fiama', 22)");
            bancoSqlite.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Lucas', 24)");
            bancoSqlite.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Caio', 23)");

            //REGISTER RECOVERY
            String consulta =
                    "SELECT nome, idade" +
                    "FROM pessoas";

            Cursor cursor = bancoSqlite.rawQuery(consulta, selectionArgs:null);

            int indiceId = cursor.getColumnIndex(columnIndex:"id");
            int indiceIdade=cursor.getColumnIndex(columnIndex:"idade");
            int indiceNome = cursor.getColumnIndex(columnIndex:"nome");

            While( cursor !=null){

                String Id = cursor.getString(indiceId);
                String nome =cursor.getString(indiceNome);
                String idade =cursor.getString(indiceIdade);

                Log.i(tag:"Retorno - Nome:", msg:nome + ". Idade:"+ idade);
                cursor.moveToNext();

                String consulta2 =
                        "SELECT nome, idade" +
                                "FROM pessoas WHERE nome = 'Breno' AND idade =21 ";

                Cursor cursor2 = bancoSqlite.rawQuery(consulta, selectionArgs:null);

                String consulta3 =
                        "SELECT nome, idade" +
                                "FROM pessoas" +
                                "WHERE idade > 20  ";

                Cursor cursor3 = bancoSqlite.rawQuery(consulta, selectionArgs:null);

                String consulta4 =
                        "SELECT nome, idade" +
                                "FROM pessoas" +
                                "WHERE idade > 20 OR idade = 24 ";

                Cursor cursor4 = bancoSqlite.rawQuery(consulta, selectionArgs:null);

                String consulta5 =
                        "SELECT nome, idade" +
                                "FROM pessoas" +
                                "WHERE idade IN (20, 30)";

                Cursor cursor5 = bancoSqlite.rawQuery(consulta, selectionArgs:null);

                String consulta6 =
                        "SELECT nome, idade" +
                                "FROM pessoas" +
                                "WHERE nome IN ('Breno', 'Fiama' )";

                Cursor cursor6 = bancoSqlite.rawQuery(consulta, selectionArgs:null);

                String consulta7 =
                        "SELECT nome, idade" +
                                "FROM pessoas" +
                                "WHERE idade BETWEEN 20 AND 30 ";

                Cursor cursor7 = bancoSqlite.rawQuery(consulta, selectionArgs:null);

                String consulta8 =
                        "SELECT nome, idade" +
                                "FROM pessoas" +
                                "WHERE nome LIKE 'Breno ' ";

                Cursor cursor8 = bancoSqlite.rawQuery(consulta, selectionArgs:null);

                String consulta9 =
                        "SELECT nome, idade" +
                                "FROM pessoas" +
                                "WHERE nome LIKE 'Ca%' ";

                Cursor cursor9 = bancoSqlite.rawQuery(consulta, selectionArgs:null);

                String consulta10 =
                        "SELECT nome, idade" +
                                "FROM pessoas" +
                                "WHERE nome LIKE '%ia%' ";

                Cursor cursor10 = bancoSqlite.rawQuery(consulta, selectionArgs:null);
                String busca = "re";
                String consulta11 =
                        "SELECT nome, idade" +
                                "FROM pessoas" +
                                "WHERE nome LIKE '%"+busca +"%'";

                Cursor cursor11 = bancoSqlite.rawQuery(consulta, selectionArgs:null);
                String busca2 = "re";
                String consulta12 =
                        "SELECT nome, idade" +
                                "FROM pessoas" +
                                "WHERE 2=2 ORDER BY idade ASC;

                Cursor cursor12 = bancoSqlite.rawQuery(consulta, selectionArgs:null);

                String busca3 = "re";
                String consulta13 =
                        "SELECT nome, idade" +
                                "FROM pessoas" +
                                "WHERE 2=2 ORDER BY idade DESC;

                Cursor cursor13 = bancoSqlite.rawQuery(consulta, selectionArgs:null);

                String busca4 = "re";
                String consulta14 =
                        "SELECT nome, idade" +
                                "FROM pessoas" +
                                "WHERE 2=2 ORDER BY idade DESC LIMIT 3;

                Cursor cursor14 = bancoSqlite.rawQuery(consulta, selectionArgs:null);

                String busca5 = "re";
                String consulta15 =
                        "SELECT nome, idade" +
                                "FROM pessoas" +
                                "WHERE 2=2 ORDER BY idade ASC LIMIT 3;

                Cursor cursor15 = bancoSqlite.rawQuery(consulta, selectionArgs:null);

                // DATA UPDATE
                bancoSqlite.execSQL("UPDATE pessoas"+
                        "SET idade =25"+
                        "WHERE nome = 'Lucas'");

                // DATABASE DELETE
                bancoSqlite.execSQL("DELETE FROM "+"pessoas");
                //This operation will delete the table pessoas,
                // if you want delete all database you'll need use the DROP command

            }
        }catch(Exception e){
            e.printStackTrace();

        }
    }
}