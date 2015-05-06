package com.cinemattson.festical;

import android.app.Application;
import android.content.Context;

import com.cinemattson.festical.model.FestivalInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Halyson on 20/01/15.
 */
public class MaterialDesignApplication extends Application {
    private static MaterialDesignApplication mMaterialDesignApplication;
    private List<FestivalInfo> listFestivals;
    private static final String MOCK_URL = "http://lorempixel.com/800/400/people/";

    @Override
    public void onCreate() {
        super.onCreate();
        loadFestivals();
        mMaterialDesignApplication = this;
    }


    public static MaterialDesignApplication getApplication() {
        return mMaterialDesignApplication;
    }

    public static Context getApplicationCtx() {
        return mMaterialDesignApplication.getApplicationContext();
    }

    public List<FestivalInfo> getListFestivals() {
        return listFestivals;
    }

    private void loadFestivals() {
        final List<FestivalInfo> listOfFestivals = new ArrayList<FestivalInfo>();
        Random r = new Random();
        int i1 = r.nextInt(11 - 1);

        listOfFestivals.add(new FestivalInfo("Vancouver International Film Festival", "1982", "26/06/2015", "www.viff.org", "Founded in 1982, The Greater Vancouver International Film Festival Society is a not-for-profit cultural organization that operates the internationally acclaimed Vancouver International Film Festival (VIFF), the annual VIFF Industry Conference and the year-round programming of the Vancity Theatre at the Vancouver International Film Centre.", "4", MOCK_URL + i1));

        i1 = r.nextInt(11 - 1);
        listOfFestivals.add(new FestivalInfo("Festival de Cannes", "1950", "26/01/2015", "www.festival-cannes.fr", "The Festival de Cannes is a celebration of cinematographic art. We exist to showcase the new writing, new genres and new visual innovations of our time. Every year in May, Cannes gives a sort of snapshot - both ephemeral and lasting, when one adds up the years - of what constitutes the art of cinema.", "5", MOCK_URL + i1));

        i1 = r.nextInt(11 - 1);
        listOfFestivals.add(new FestivalInfo("Sundance Film Festival", "1985", "25/11/2015", "www.sundance.org", "The Sundance Film Festival brings the most original storytellers together with the most adventurous audiences for its annual program of dramatic and documentary films, genre_shorts, New Frontier films, installations, performances, panel discussions, and dynamic music events. Since 1985, hundreds of films launched at the Festival have gained critical recognition, received commercial distribution, and reached worldwide audiences eager for fresh perspectives and new voices. Year after year, the Festival pursues new ways to introduce more people to the most original and authentic storytelling.", "5", MOCK_URL + i1));

        i1 = r.nextInt(11 - 1);
        listOfFestivals.add(new FestivalInfo("Whistler Film Festival", "2000", "30/06/2015", "www.whistlerfilmfestival.com", "Based in North America's premier mountain resort just two hours north of Vancouver, British Columbia, the Whistler Film Festival Society (WFFS) is a charitable cultural organization dedicated to furthering the art of film by providing programs that focus on the discovery, development and promotion of new talent culminating with a must attend festival for artists, the industry and audiences in Whistler.", "3.5", MOCK_URL + i1));

        i1 = r.nextInt(11 - 1);
        listOfFestivals.add(new FestivalInfo("Toronto International Film Festival", "", "", "www.tiff.net/", "TIFF is dedicated to presenting the best of international and Canadian cinema to film lovers. Our vision is to lead the world in creative and cultural discovery through the moving image. What began as a ten-day film festival has grown to embrace programming 365 days a year. TIFF offers screenings, lectures, discussions, festivals, workshops, industry support and the chance to meet filmmakers from Canada and around the world.", "", MOCK_URL + i1));

        i1 = r.nextInt(11 - 1);
        listOfFestivals.add(new FestivalInfo("Seattle International Film Festival", "1976", "30/06/2015", "www.siff.net/", "Founded in 1976, SIFF is Seattle's leading year-round film organization that brings the best in international and independent film to the Seattle area with the Seattle International Film Festival, SIFF Cinema, and SIFF Education.", "3.5", MOCK_URL + i1));

        i1 = r.nextInt(11 - 1);
        listOfFestivals.add(new FestivalInfo("Hot Docs", "1993", "30/06/2015", "www.hotdocs.ca", "Hot Docs Canadian International Documentary Festival is North America's largest documentary festival, conference and market, and takes place in Toronto, Canada. Each year, the Festival presents a selection of more than 180 cutting-edge documentaries from Canada and around the globe. Through its industry programs, Hot Docs also provides a full range of professional development, market and networking opportunities for documentary professionals.", "3", MOCK_URL + i1));

        i1 = r.nextInt(11 - 1);
        listOfFestivals.add(new FestivalInfo("NFFTY", "1993", "26/01/2015", "www.nffty.org", "NFFTY is the world's largest film festival for emerging directors. In 2014, we screened 214 amazing films from the best filmmakers 24 and younger representing 30 states and 15 countries, with over 12,000 in attendance. NFFTY 2015 will be April 23-26 in Seattle, WA.", "4", MOCK_URL + i1));

        i1 = r.nextInt(11 - 1);
        listOfFestivals.add(new FestivalInfo("DOXA Documentary Film Festival", "1998", "26/01/2015", "www.doxafestival.ca", "DOXA is presented by The Documentary Media Society, a Vancouver based non-profit, charitable society (incorporated in 1998) devoted to presenting independent and innovative documentaries to Vancouver audiences.\n" +
                "\n" +
                "The society exists to educate the public about documentary film as an art form through DOXA Documentary Film Festival, a curated and juried festival comprised of public screenings, panel discussions, public forums and educational programs.", "4", MOCK_URL + i1));

        this.listFestivals = listOfFestivals;
    }


}
