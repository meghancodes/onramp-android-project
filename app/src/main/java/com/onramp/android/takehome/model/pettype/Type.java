package com.onramp.android.takehome.model.pettype;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.onramp.android.takehome.model.pettype.Links;

public class Type {

@SerializedName("name")
@Expose
private String name;
@SerializedName("coats")
@Expose
private List<String> coats = null;
@SerializedName("colors")
@Expose
private List<String> colors = null;
@SerializedName("genders")
@Expose
private List<String> genders = null;
@SerializedName("_links")
@Expose
private Links links;

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public List<String> getCoats() {
return coats;
}

public void setCoats(List<String> coats) {
this.coats = coats;
}

public List<String> getColors() {
return colors;
}

public void setColors(List<String> colors) {
this.colors = colors;
}

public List<String> getGenders() {
return genders;
}

public void setGenders(List<String> genders) {
this.genders = genders;
}

public Links getLinks() {
return links;
}

public void setLinks(Links links) {
this.links = links;
}

}