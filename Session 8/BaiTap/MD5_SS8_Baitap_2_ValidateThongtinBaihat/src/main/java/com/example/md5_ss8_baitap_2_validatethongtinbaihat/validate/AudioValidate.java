package com.example.md5_ss8_baitap_2_validatethongtinbaihat.validate;

import com.example.md5_ss8_baitap_2_validatethongtinbaihat.model.Audio;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

public class AudioValidate {
    public void checkValidate(Audio audio, Errors errors) {
        checkValidateName(audio,errors);
        checkValidateArtist(audio,errors);
        checkValidateCategory(audio,errors);

    }

    private void checkValidateName(Audio audio, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty");
        String name = audio.getName();
        if (name.length() > 800) {
            errors.rejectValue("name", "name.length");
        }
        if (name.matches("^[^@;\\.=+\\-,]+$")) {
            errors.rejectValue("name", "name.regex");
        }
    }

    private void checkValidateArtist(Audio audio, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "artist", "artist.empty");
        String artist = audio.getArtist();
        if (artist.length() > 300) {
            errors.rejectValue("artist", "artist.length");
        }
        if (artist.matches("^[^@;\\.=+\\-,]+$")) {
            errors.rejectValue("artist", "artist.regex");
        }
    }

    private void checkValidateCategory(Audio audio, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "category.empty");
        String category = audio.getCategory();
        if (category.length() > 1000) {
            errors.rejectValue("category", "category.length");
        }
        if (category.matches("^[^@;.=+-]*$")) {
            errors.rejectValue("category", "category.regex");
        }
    }
}
