package com.alomateam.gainapp.ParsingTest;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.alomateam.gainapp.MainActivity;
import com.alomateam.gainapp.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class CardParsingActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    HashMap<String, String> cardListData = new HashMap<String, String>();
    CardListParsing cardListParsing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_parsing_list);

        recyclerView = (RecyclerView) findViewById(R.id.parsing_recyclerView);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        cardListParsing = new CardListParsing();

        try {
            cardListData = cardListParsing.execute().get();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        if (cardListData == null) {
            finish();
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }

        ArrayList<CardParsingInfo> cardParsingInfoArrayList = new ArrayList<>();
        // cardParsingInfoArrayList.add(new CardParsingInfo(R.drawable.a1, "Test Card"));

        for (String key : cardListData.keySet()) {
            cardParsingInfoArrayList.add(new CardParsingInfo(R.drawable.a1, key));
        }

        CardParsingAdapter mycardadapter = new CardParsingAdapter(cardParsingInfoArrayList);
        recyclerView.setAdapter(mycardadapter);

    }

    public class CardListParsing extends AsyncTask<Integer, Integer, HashMap<String, String>> {

        private ProgressDialog progressDialog;
        HashMap<String, String> cardParsingList = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(CardParsingActivity.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("잠시 기다려주세요 :)");
            progressDialog.show();
        }
        @Override
        protected HashMap<String, String> doInBackground(Integer... integers) {
            cardParsingList = new HashMap<String, String>();

            try {
                Document doc = Jsoup.connect("https://card.kbcard.com/CXPRICAC0056.cms").get();

                Elements cardList01s = doc.getElementsByClass("cardList01"); // ul
                Element cardList01 = cardList01s.get(0);

                Elements cardListInfo = cardList01.getElementsByClass("infoCard_wr ");

                for (int i=0; i < cardListInfo.size(); i++) {
                    Element oneLi = cardListInfo.get(i);
                    Element img = oneLi.getElementsByTag("a").get(0).getElementsByTag("img").get(0);
                    String img_str = img.attr("alt");
                    String url_str = img.attr("src");
                    cardParsingList.put(img_str, url_str);
                }
                /*
                Elements mElementDataSize = doc.select("ul[class=lst_detail_t1]").select("li"); //필요한 녀석만 꼬집어서 지정
                int mElementSize = mElementDataSize.size(); //목록이 몇개인지 알아낸다. 그만큼 루프를 돌려야 하나깐.

                for(Element elem : mElementDataSize){ //이렇게 요긴한 기능이
                    //영화목록 <li> 에서 다시 원하는 데이터를 추출해 낸다.
                    String my_title = elem.select("li dt[class=tit] a").text();
                    String my_link = elem.select("li div[class=thumb] a").attr("href");
                    String my_imgUrl = elem.select("li div[class=thumb] a img").attr("src");
                    //특정하기 힘들다... 저 앞에 있는집의 오른쪽으로 두번째집의 건너집이 바로 우리집이야 하는 식이다.
                    Element rElem = elem.select("dl[class=info_txt1] dt").next().first();
                    String my_release = rElem.select("dd").text();
                    Element dElem = elem.select("dt[class=tit_t2]").next().first();
                    String my_director = "감독: " + dElem.select("a").text();
                    //Log.d("test", "test" + mTitle);
                    //ArrayList에 계속 추가한다.
                    list.add(new ItemObject(my_title, my_imgUrl, my_link, my_release, my_director));
                }

                //추출한 전체 <li> 출력해 보자.
                Log.d("debug :", "List " + mElementDataSize);
                */
            } catch (IOException e) {
                e.printStackTrace();
            }
            return cardParsingList;
        }
        @Override
        protected void onProgressUpdate(Integer... params) {

        }
        @Override
        protected void onPostExecute(HashMap<String, String> result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        cardListParsing.cancel(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cardListParsing.cancel(true);
    }

}
