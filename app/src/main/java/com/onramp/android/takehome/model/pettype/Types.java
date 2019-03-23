package com.onramp.android.takehome.model.pettype;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.onramp.android.takehome.model.pettype.Type;

public class Types {

@SerializedName("types")
@Expose
private List<Type> types = null;

public List<Type> getTypes() {
return types;
}

public void setTypes(List<Type> types) {
this.types = types;
}

}