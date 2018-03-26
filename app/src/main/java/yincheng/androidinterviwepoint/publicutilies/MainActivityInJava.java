package yincheng.androidinterviwepoint.publicutilies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import br.tiagohm.markdownview.MarkdownView;
import br.tiagohm.markdownview.css.InternalStyleSheet;
import br.tiagohm.markdownview.css.styles.Github;
import yincheng.androidinterviwepoint.R;

/**
 * Created by commi on 2018/3/23.
 */

public class MainActivityInJava extends AppCompatActivity {
    private MarkdownView markdownView;
    private InternalStyleSheet mStyle = new Github();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        markdownView = findViewById(R.id.mark_view);

        //Cria o bean.
        MyBean myBean = new MyBean();
        myBean.setHello("Olá");
        myBean.setDiasDaSemana(MyBean.DiasDaSemana.DOMINGO);

        markdownView = findViewById(R.id.mark_view);
        markdownView.addStyleSheet(mStyle);
        //http://stackoverflow.com/questions/6370690/media-queries-how-to-target-desktop-tablet-and-mobile
        mStyle.addMedia("screen and (min-width: 320px)");
        mStyle.addRule("h1", "color: green");
        mStyle.endMedia();
        mStyle.addMedia("screen and (min-width: 481px)");
        mStyle.addRule("h1", "color: red");
        mStyle.endMedia();
        mStyle.addMedia("screen and (min-width: 641px)");
        mStyle.addRule("h1", "color: blue");
        mStyle.endMedia();
        mStyle.addMedia("screen and (min-width: 961px)");
        mStyle.addRule("h1", "color: yellow");
        mStyle.endMedia();
        mStyle.addMedia("screen and (min-width: 1025px)");
        mStyle.addRule("h1", "color: gray");
        mStyle.endMedia();
        mStyle.addMedia("screen and (min-width: 1281px)");
        mStyle.addRule("h1", "color: orange");
        mStyle.endMedia();
        markdownView.setBean(myBean);

        markdownView.loadMarkdownFromAsset("Android多线程.md");
    }

    public static class MyBean {

        public enum DiasDaSemana {
            DOMINGO,
            SEGUNDA,
            TERCA,
            QUARTA,
            QUINTA,
            SEXTA,
            SABADO
        }

        private String hello;
        private DiasDaSemana diasDaSemana;

        public String getHello() {
            return hello;
        }

        public void setHello(String hello) {
            this.hello = hello;
        }

        public DiasDaSemana getDiasDaSemana() {
            return diasDaSemana;
        }

        public void setDiasDaSemana(DiasDaSemana diasDaSemana) {
            this.diasDaSemana = diasDaSemana;
        }
    }
}
