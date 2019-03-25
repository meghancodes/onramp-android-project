package com.onramp.android.takehome.model.pets;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PetObjects {

@SerializedName("objects")
@Expose
public List<PetObject> objects = null;
@SerializedName("page")
@Expose
public Integer page;
@SerializedName("total_pages")
@Expose
public Integer totalPages;

}