package com.liferay.devcon.form.samples.function;

/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

import com.liferay.dynamic.data.mapping.expression.DDMExpressionFunction;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.osgi.service.component.annotations.Component;

/**
 * @author Marcellus Tavares
 */
@Component(
	immediate = true, property = "ddm.form.evaluator.function.name=parseDate",
	service = DDMExpressionFunction.class
)
public class ParseDateFunction implements DDMExpressionFunction {

	@Override
	public Object evaluate(Object... parameters) {
		if (parameters.length != 1) {
			throw new IllegalArgumentException("One parameters is expected");
		}

		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

		try {
			return dateFormat.parse(parameters[0].toString());
		}
		catch (ParseException pe) {
			return null;
		}
	}

}