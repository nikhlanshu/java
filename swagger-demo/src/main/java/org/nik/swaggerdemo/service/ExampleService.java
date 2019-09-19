package org.nik.swaggerdemo.service;

import org.nik.swaggerdemo.model.DummyResponse;
import org.nik.swaggerdemo.model.Included;
import org.nik.swaggerdemo.model.IncludedVariantOne;
import org.nik.swaggerdemo.model.IncludedVariantTwo;
import org.nik.swaggerdemo.model.VariantOne;
import org.nik.swaggerdemo.model.VariantTwo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExampleService {

    public DummyResponse getDummy(Integer dummyId){
        return populateResponse(dummyId);
    }

    private DummyResponse populateResponse(Integer dummyId){

        DummyResponse dummyResponse = new DummyResponse();
        Set<Included> includeds = new HashSet<Included>();
        dummyResponse.setId(dummyId.toString());
        IncludedVariantOne includedOne = new IncludedVariantOne();
        includedOne.setId("One Value");
        includedOne.setType(IncludedVariantOne.class.getName());
        includedOne.setVaryOne("VaryOne Value");
        VariantOne variantOne = new VariantOne();
        variantOne.setVaryOneProp1("VaryOneProp1 Value");
        variantOne.setVaryOneProp2("VaryOneProp2 Value");
        includedOne.setVariantOne(variantOne);
        includeds.add(includedOne);

        IncludedVariantTwo includedVariantTwo = new IncludedVariantTwo();
        includedVariantTwo.setVaryTwo("VaryTwo Value");
        includedVariantTwo.setId("Two Value");
        includedVariantTwo.setType(IncludedVariantTwo.class.getName());
        VariantTwo variantTwo = new VariantTwo();
        variantTwo.setVaryTwoProp1("VaryTwoProp1 Value");
        variantTwo.setVaryTwoProp2("VaryTwoProp2 Value");
        includedVariantTwo.setVariantTwo(variantTwo);
        includeds.add(includedVariantTwo);

        dummyResponse.setIncludeds(includeds);

        return dummyResponse;

    }
}
