package be.vdab.ondernemingsnummer.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OndernemingsNummerValidator implements ConstraintValidator<OndernemingsNummer, Long> {
    @Override
    public void initialize(OndernemingsNummer constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long aLong, ConstraintValidatorContext constraintValidatorContext) {
        if (aLong == null){
            return true;
        }
        var laatsteTweeCijfers = aLong.toString();
        var eersteCijfers = laatsteTweeCijfers.substring(0, laatsteTweeCijfers.length()-2);
        laatsteTweeCijfers = laatsteTweeCijfers.substring((laatsteTweeCijfers.length()-2));
        var rest = 97 - (Long.parseLong(eersteCijfers) % 97);
        var check = Long.valueOf(laatsteTweeCijfers);
        return check == rest;
    }
}
