package kabukeisan.kirin3.jp.optionmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    int checkedId;

    private String[] os = { "Windows", "Linux", "Mac" };
    private String[] office = { "Word", "PowerPoint", "Excel", "Outlook" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                //選択されたRadioButtonのIDを取得
                radioButton = (RadioButton) findViewById(checkedId);
                Toast.makeText(MainActivity.this,
                        radioButton.getText() + "を選択しました。", Toast.LENGTH_LONG)
                        .show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        checkedId = radioGroup.getCheckedRadioButtonId();

        //メニュー項目を作成
        //add()の第１引数でRadioButtonをGroup分け

        //１つ目のRadioButtonが選択されているときに表示させるオプションメニュー
        menu.add(0, 0, 0, os[0]);
        menu.add(0, 10, 1, os[1]);
        menu.add(0, 20, 2, os[2]);

        //２つ目のRadioButtonが選択されているときに表示させるオプションメニュー
        menu.add(1, 0, 0, office[0]);
        menu.add(1, 10, 1, office[1]);
        menu.add(1, 20, 2, office[2]);
        menu.add(1, 30, 3, office[3]);

        /*
        //main.xmlの内容を読み込むを読み込む場合はこちら
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        */


        return true;
    }


    // メニュキーを押したら毎回実行される
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        checkedId = radioGroup.getCheckedRadioButtonId();

        //setGroupVisible()の第１引数には、上で作成した項目のグループIDを指定
        //setGroupVisible()の第２引数には、そのグループの有効無効を指定

        if (checkedId == R.id.radioButton1) {
            menu.setGroupVisible(0, true);
            menu.setGroupVisible(1, false);
        } else {
            menu.setGroupVisible(0, false);
            menu.setGroupVisible(1, true);
        }

        return true;
    }

    // メニュー選択時の処理
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        checkedId = radioGroup.getCheckedRadioButtonId();

        //getTitle()を用いて、選択された項目（item）のタイトル（文字列）を取得

        if (checkedId == R.id.radioButton1) {
            if (item.getItemId() == 0) {
                Toast.makeText(this, item.getTitle() + "が選択されました。",
                        Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == 10) {
                Toast.makeText(this, item.getTitle() + "が選択されました。",
                        Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == 20) {
                Toast.makeText(this, item.getTitle() + "が選択されました。",
                        Toast.LENGTH_SHORT).show();
            }

        } else if (checkedId == R.id.radioButton2) {
            if (item.getItemId() == 0) {
                Toast.makeText(this, item.getTitle() + "が選択されました。",
                        Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == 10) {
                Toast.makeText(this, item.getTitle() + "が選択されました。",
                        Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == 20) {
                Toast.makeText(this, item.getTitle() + "が選択されました。",
                        Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == 30) {
                Toast.makeText(this, item.getTitle() + "が選択されました。",
                        Toast.LENGTH_SHORT).show();
            }
        }

        return true;
    }
}
