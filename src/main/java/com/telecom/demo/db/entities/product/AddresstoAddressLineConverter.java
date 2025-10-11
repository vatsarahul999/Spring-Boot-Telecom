package com.telecom.demo.db.entities.product;

import jakarta.persistence.AttributeConverter;

import java.util.ArrayList;
import java.util.List;

public class AddresstoAddressLineConverter  implements AttributeConverter<String, List<String>> {
    @Override
    public List<String> convertToDatabaseColumn(String attribute) {
        List<String> result = new ArrayList<>();
        result.add(attribute.substring(0,100));
        result.add(attribute.substring(100,200));
        result.add(attribute.substring(200,300));
        return result;
    }

    @Override
    public String convertToEntityAttribute(List<String> dbData) {
        StringBuilder res = new StringBuilder();
        for(String str: dbData){
            res.append(str).append(" ");
        }
        return res.toString().trim();
    }
}
