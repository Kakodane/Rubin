package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("slika")
public class Slika {
    private String link;

    public Slika() {}

    public Slika(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}