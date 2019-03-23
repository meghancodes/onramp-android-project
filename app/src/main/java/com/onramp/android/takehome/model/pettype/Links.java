package com.onramp.android.takehome.model.pettype;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links {

@SerializedName("self")
@Expose
private Self self;
@SerializedName("breeds")
@Expose
private Breeds breeds;

public Self getSelf() {
return self;
}

public void setSelf(Self self) {
this.self = self;
}

public Breeds getBreeds() {
return breeds;
}

public void setBreeds(Breeds breeds) {
this.breeds = breeds;
}

}