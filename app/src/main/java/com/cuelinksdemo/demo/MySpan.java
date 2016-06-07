package com.cuelinksdemo.demo;

import android.text.Html;
import android.widget.TextView;

import com.cuelinks.CuelinkSpan;

/**
 * Created by tasneem on 26/05/16.
 */
public class MySpan extends CuelinkSpan {
    public MySpan(String url) {
        super(url);
    }

    public static CharSequence affiliateHrefUrlsFromHtml(CharSequence html, TextView view) {

        return affiliateHrefUrls(Html.fromHtml(html.toString()), view);
    }
}
