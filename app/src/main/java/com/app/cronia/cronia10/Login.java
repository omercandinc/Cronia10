package com.app.cronia.cronia10;

        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v7.app.AppCompatActivity;
        import android.view.Display;
        import android.view.View;
        import android.widget.Button;

public class Login extends AppCompatActivity {
    //Butonumuz için değişken oluşturuyoruz.
    Button LoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        LoginButton = (Button)findViewById(R.id.button_login);
        LoginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Ardından Intent methodunu kullanarak nereden nereye gideceğini söylüyoruz.
                Intent go_to_main = new Intent(Login.this, MainActivity.class);
                startActivity(go_to_main);
            }
            // Deniz Alkan tarafından değpiştirildi ve ömer can
        });
         //deneme
    }
}

// ömer can burayı görmen lazım