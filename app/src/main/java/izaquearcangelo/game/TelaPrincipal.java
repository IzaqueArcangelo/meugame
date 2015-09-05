package izaquearcangelo.game;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import izaquearcangelo.engine.Game;

/**
 * @author  Izaque Arcangelo
 * @version 0.1
 * Classe principal do Jogo, irá ser responsável por exibir o jogo na tela.
 *
 */
public class TelaPrincipal extends Activity {

    private Game jogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        jogo = new Game(this); // Também poderia ser utilizado 'this'
        setContentView(jogo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        jogo.iniciarJogo(); // inicia o loop do jogo.
    }

    @Override
    protected void onPause() {
        super.onPause();
        jogo.pausarJogo();
    }
}
