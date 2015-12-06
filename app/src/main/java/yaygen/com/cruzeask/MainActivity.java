package yaygen.com.cruzeask;

import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends ActionBarActivity {

    private ProgressBar pbr;
    private WebView wv;
    private WebSettings ws;
    private String webUrl = "http://cruzeask.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        loadCruzeaskUrl();
    }

    private void loadCruzeaskUrl(){
        pbr = (ProgressBar)findViewById(R.id.progressbar);
        pbr.setProgress(0);
        pbr.setVisibility(View.VISIBLE);
        wv = (WebView) findViewById(R.id.webView);

        wv.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                // Show progressbar
                pbr.setVisibility(View.VISIBLE);
            }

            @Override
            public void onReceivedError( WebView view, int errorCode, String description, String failingUrl) {
                // Show error
                // Stop spinner or progressbar
                pbr.setVisibility(View.GONE);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                // Stop spinner or progressBar
                pbr.setVisibility(View.GONE);

            }
        });
        ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setDefaultTextEncodingName("UTF-8");
        wv.loadUrl(webUrl);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return false;
    }

    @Override
    public void onBackPressed() {
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return false;
    }
}
