package com.anita.onlineFE.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.anita.onlineBE.model.dto.Item;

public class ItemValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Item.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Item item = (Item) target;
		if (item.getFile() == null || item.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "Please select a image file to upload!");
			return;
		}

		if (!(item.getFile().getContentType().equals("image/jpeg")
				|| item.getFile().getContentType().equals("image/png")
				|| item.getFile().getContentType().equals("image/gif"))) {
			errors.rejectValue("file", null, "Please use only image file for upload!");
			return;
		}
	}

}
