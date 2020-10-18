
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class spider {


    public static void main(String[] args) throws Exception {
        Document doc= Jsoup.parse(new URL("https://tv.cctv.com/lm/xwlb/day/20201018.shtml"),5000);
        System.out.println(doc);
        Elements e = doc.select("li");
        Element link = null;
        String v;
        Map<String,Object> map = new HashMap<String,Object>();

        List vs = new ArrayList<>();
        if (e.size() > 0) {
            for (int i = 0; i < e.size(); i++) {
                map = new HashMap<String,Object>();

                link = e.get(i).select("div.title").first();
                map.put("title",link.text());

                link = e.get(i).select("a[href]").first();
                map.put("href",link.attr("href"));

                link = e.get(i).select("img[src]").first();
                map.put("img","https:"+link.attr("src"));

                vs.add(map);
            }
        }
        System.out.println(vs);
    }



}
