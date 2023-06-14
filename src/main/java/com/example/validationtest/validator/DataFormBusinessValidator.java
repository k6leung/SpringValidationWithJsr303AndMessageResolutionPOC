package com.example.validationtest.validator;

import com.example.validationtest.model.DataForm;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class DataFormBusinessValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return DataForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        DataForm form = (DataForm) target;
        Integer intVal = form.getIntVal();

        if((intVal != null) && (intVal < 1)) {
            errors.rejectValue("intVal", "intVal.not.less.than.one");
        }
    }
}
