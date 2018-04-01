package yincheng.androidinterviwepoint.primary.asynctask;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import yincheng.androidinterviwepoint.R;

/**
 * Created by commi on 2018/3/24.
 */

public class ActivityAsyncTask extends AppCompatActivity {

    TextView textView = null;
    Button btnDownload_singlethread = null;
    Button btnDownload_multithread = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask_test);
        textView =  findViewById(R.id.tv_show);
        btnDownload_singlethread =  findViewById(R.id.btn_download_singlethread);
        btnDownload_singlethread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //要下载的文件地址
                String[] urls = {
                        "http://blog.csdn.net/iispring/article/details/47115879",
                        "http://blog.csdn.net/iispring/article/details/47180325",
                        "http://blog.csdn.net/iispring/article/details/47300819",
                        "http://blog.csdn.net/iispring/article/details/47320407",
                        "http://blog.csdn.net/iispring/article/details/47622705"
                };

                DownloadTask downloadTask = new DownloadTask();
                downloadTask.execute(urls);
            }
        });
        btnDownload_multithread = (Button) findViewById(R.id.btn_download_multithread);
        btnDownload_multithread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= 11){
                    String[] urls = {
                            "http://blog.csdn.net/iispring/article/details/47115879",
                            "http://blog.csdn.net/iispring/article/details/47180325",
                            "http://blog.csdn.net/iispring/article/details/47300819",
                            "http://blog.csdn.net/iispring/article/details/47320407",
                            "http://blog.csdn.net/iispring/article/details/47622705"
                    };

                    DownloadTask downloadTask1 = new DownloadTask();
                    downloadTask1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, urls);

                    DownloadTask downloadTask2 = new DownloadTask();
                    downloadTask2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, urls);
                }
            }
        });
    }


    //public abstract class AsyncTask<Params, Progress, Result>
    //在此例中，Params泛型是String类型，Progress泛型是Object类型，Result泛型是Long类型
    private class DownloadTask extends AsyncTask<String, Object, Long> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView.setText("开始下载...");
        }

        @Override
        protected Long doInBackground(String... params) {
            //totalByte表示所有下载的文件的总字节数
            long totalByte = 0;
            //params是一个String数组
            for (String url : params) {
                //遍历Url数组，依次下载对应的文件
                Object[] result = downloadSingleFile(url);
                int byteCount = (int) result[0];
                totalByte += byteCount;
                //在下载完一个文件之后，我们就把阶段性的处理结果发布出去
                publishProgress(result);
                //如果AsyncTask被调用了cancel()方法，那么任务取消，跳出for循环
                if (isCancelled()) {
                    break;
                }
            }
            //将总共下载的字节数作为结果返回
            return totalByte;
        }

        //下载文件后返回一个Object数组：下载文件的字节数以及下载的博客的名字
        private Object[] downloadSingleFile(String str) {
            Object[] result = new Object[2];
            int byteCount = 0;
            String blogName = "";
            HttpURLConnection conn = null;
            try {
                URL url = new URL(str);
                conn = (HttpURLConnection) url.openConnection();
                InputStream is = conn.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int length = -1;
                while ((length = is.read(buf)) != -1) {
                    baos.write(buf, 0, length);
                    byteCount += length;
                }
                String respone = new String(baos.toByteArray(), "utf-8");
                int startIndex = respone.indexOf("<title>");
                if (startIndex > 0) {
                    startIndex += 7;
                    int endIndex = respone.indexOf("</title>");
                    if (endIndex > startIndex) {
                        //解析出博客中的标题
                        blogName = respone.substring(startIndex, endIndex);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    conn.disconnect();
                }
            }
            result[0] = byteCount;
            result[1] = blogName;
            return result;
        }

        @Override
        protected void onProgressUpdate(Object... values) {
            super.onProgressUpdate(values);
            int byteCount = (int) values[0];
            String blogName = (String) values[1];
            String text = textView.getText().toString();
            text += "\n博客《" + blogName + "》下载完成，共" + byteCount + "字节";
            textView.setText(text);
        }

        @Override
        protected void onPostExecute(Long aLong) {
            super.onPostExecute(aLong);
            String text = textView.getText().toString();
            text += "\n全部下载完成，总共下载了" + aLong + "个字节";
            textView.setText(text);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            textView.setText("取消下载");
        }
    }
}