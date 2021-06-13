package com.park.Park.dao;

import com.park.Park.model.Codes;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

public interface CodeDao {

    int generateCode(UUID id, Codes code);
    default  int generateCode(UUID userId){
        Codes code= new Codes(null,userId,getAlphaNumericString(10));
        return generateCode(UUID.randomUUID(),code);
    }

    int deleteCode(UUID userId);
    Optional<Codes> getCodeByUserId(UUID userId);
    List<Codes> getCodes();

    static String getAlphaNumericString(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = "ABCD"
                + "0123456789";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString().toUpperCase(Locale.ROOT);
    }
}
