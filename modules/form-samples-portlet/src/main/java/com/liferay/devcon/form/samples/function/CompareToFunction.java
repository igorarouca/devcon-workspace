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

package com.liferay.devcon.form.samples.function;

import com.liferay.dynamic.data.mapping.expression.DDMExpressionFunction;

import org.osgi.service.component.annotations.Component;

/**
 * @author Marcellus Tavares
 */
@Component(
	immediate = true, property = "ddm.form.evaluator.function.name=compareTo",
	service = DDMExpressionFunction.class
)
public class CompareToFunction implements DDMExpressionFunction {

	@Override
	public Object evaluate(Object... parameters) {
		if (parameters.length != 2) {
			throw new IllegalArgumentException("Two parameters are expected");
		}

		Comparable<? super Object> parameter1 =
			(Comparable<? super Object>)parameters[0];
		Comparable<? super Object> parameter2 =
			(Comparable<? super Object>)parameters[1];

		return parameter1.compareTo(parameter2);
	}

}