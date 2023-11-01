package edu.square.model;

import edu.square.model.component.MComponentModel;

import java.util.Arrays;
import java.util.List;

public class MModel {
    List<MComponentModel> mComponentModels;

    public MModel(MComponentModel... mComponentModels){
        mComponentModels = (MComponentModel[]) Arrays.stream(mComponentModels).toArray();
    }
}
