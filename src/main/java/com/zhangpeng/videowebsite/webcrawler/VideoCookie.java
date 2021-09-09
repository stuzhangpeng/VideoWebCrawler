package com.zhangpeng.videowebsite.webcrawler;
import java.util.HashMap;
import java.util.Map;
/**
 * @ClassName VideoCookie
 * @Description 爬取网站使用的cookie
 * @Author zhangpeng
 * @Date 2020/11/3 18:44
 * @Version 1.0
 */
public class VideoCookie {
    private static Map<String,String> cookie;
    static {
        cookie=new HashMap<String, String>();
        cookie.put("PHPSESSID", "teb9d7smjrck311atast0dspj2");
        cookie.put("__cfduid", "d6ca8601d123790c31bae56bdabd1deeb1604399601");
        cookie.put("TSCvalue", "gb");
        cookie.put("UM_distinctid", "1758dab412a3c3-09963c6df4ae5e-4c3f2678-1fa400-1758dab412b154");
        cookie.put("CNZZDATA1273435591", "2109780754-1604395171-https%253A%252F%252Faa1805.com%252F%7C1604395171");
        cookie.put("CNZZDATA1273380027", "613075071-1604397306-https%253A%252F%252Faa1805.com%252F%7C1604397306");
        cookie.put("javascript_cookie_Eighteenth", "I_am_over_18_years_old");

    }
    public static Map getCookie() {
        return cookie;
    }


}
