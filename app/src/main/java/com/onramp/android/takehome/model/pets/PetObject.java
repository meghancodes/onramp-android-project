package com.onramp.android.takehome.model.pets;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PetObject {

@SerializedName("age")
@Expose
public String age;
@SerializedName("all_images")
@Expose
public String allImages;
@SerializedName("animal")
@Expose
public String animal;
@SerializedName("breed")
@Expose
public String breed;
@SerializedName("description")
@Expose
public String description;
@SerializedName("id")
@Expose
public String id;
@SerializedName("image_url")
@Expose
public String imageUrl;
@SerializedName("name")
@Expose
public String name;
@SerializedName("sex")
@Expose
public String sex;
@SerializedName("shelter")
@Expose
public String shelter;
@SerializedName("size")
@Expose
public String size;
@SerializedName("vet")
@Expose
public String vet;

}