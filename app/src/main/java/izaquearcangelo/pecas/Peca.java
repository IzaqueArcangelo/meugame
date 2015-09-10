package izaquearcangelo.pecas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;


public class Peca extends View {

    private Point point;
    private Paint paint;

    public Peca(Context context) {
        super(context);
        paint = new Paint();
    }

    public Peca(Context contex, Point point){
        super(contex);
        this.point = point;
        paint = new Paint();
    }


    public void quadrado(Canvas canvas) {
        paint.setColor(Color.RED);
        Rect quadrado = new Rect();
        int largura = point.x;
        int altura = point.y;
        quadrado.set(largura/2-100, altura/2-100, (largura/2-100)+200, (altura/2-100)+200);
        canvas.drawRect(quadrado, paint);
    }
}
