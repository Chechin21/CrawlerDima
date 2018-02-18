package com.github.stagirs.crawler.downloader;

import com.github.stagirs.crawler.Downloader;
import com.github.stagirs.crawler.model.business.Author;
import com.github.stagirs.crawler.model.business.Record;
import com.github.stagirs.crawler.model.service.Session;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import com.github.stagirs.crawler.Downloader;
import com.github.stagirs.crawler.model.business.Author;
import com.github.stagirs.crawler.model.business.Record;
import com.github.stagirs.crawler.model.service.Session;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Vudm extends Downloader {

    @Override
    public String getName() {
        return "Вестник Удмуртского университета. Математика. Механика. Компьютерные науки";
    }

    @Override
    public String getUrl() {
        return "http://vst.ics.org.ru";
    }

    @Override
    public void process(Session session) throws IOException, InterruptedException {
        for (String release : getAvailableReleases()) {
            if(!isNewRelease(release)){
                continue;
            }
            for(Record record : releaseDownload(release)){
                save(session, record);
            }
            save(release);
        }
    }


    private List<String> getAvailableReleases() throws IOException {
        List<String> releases = new ArrayList<>();

        Document doc = Jsoup.connect("http://vst.ics.org.ru/journal/").get();
        for (Element el : doc.select(".years a")) {
            //System.out.println(el.attr("href").split("/")[2]);
            //System.out.println(el.attr("href"));
            //String href = el.attr("href");
            releases.add(el.attr("href"));
        }

        return releases;
    }

    private List<Record> releaseDownload(String releaseName) throws IOException, InterruptedException {
        List<Record> releases = new ArrayList<>();


            String href;
           // System.out.println(getUrl() +releaseName);

            Document doc1 = Jsoup.connect(getUrl() + releaseName).get();
            for (Element el1 : doc1.select(".publication_info a")) {
                href = el1.attr("href");
             //   System.out.println(href);
                releases.add(getRecord(href));
            }

        //}

        return releases;
    }

    protected Record getRecord(String url) throws IOException {
        Record record = new Record();
        record.setType(Record.Type.PAPER);
        List<Author>authorlist = new ArrayList<>();
        Document doc2 = Jsoup.connect(url).get();
        record.setUrl(getUrl() + doc2.select(".publication_frame").select(".publication_files").select("a[href]").attr("href"));

        record.setTitle(doc2.select(".publication_frame").select(".publication_title").text());
        for (Element el2 : doc2.select(".publication_frame").select(".publication_authors2")) {
            if (el2.text().isEmpty()){
                Author au = new Author("","");
                authorlist.add(au);
                continue;
            }
            String[] temp = el2.text().split(",");
            for (String y : temp){
                //System.out.println(y);
                String[] temp1 = y.trim().split(" ");
                Author au = new Author(temp1[0],temp1[1]);
                authorlist.add(au);
                //System.out.println(temp1[0] + '-' + temp1[1]);


            }
        }
        record.setAuthors(authorlist);
        return record;
    }
}