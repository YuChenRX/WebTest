package com.web.web2022.validation.validator;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotEmptyValidatorForMultipartFile implements ConstraintValidator<FileNotEmpty, MultipartFile> {
    @Override
    public boolean isValid(
        MultipartFile multipartFile, ConstraintValidatorContext constraintValidatorContext
    ) {
        return multipartFile != null && !multipartFile.isEmpty();
    }
}
