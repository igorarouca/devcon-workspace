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

package com.liferay.devcon.form.samples.definitions;

import com.liferay.dynamic.data.mapping.annotations.DDMForm;
import com.liferay.dynamic.data.mapping.annotations.DDMFormField;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayout;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutColumn;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutPage;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutRow;
import com.liferay.dynamic.data.mapping.annotations.DDMFormRule;

/**
 * @author Marcellus Tavares
 */
@DDMForm(
	rules = {
		@DDMFormRule(
			actions = {
				"setInvalid('dateTo', 'dateTo cant be greater than dateFrom')"
			},
			condition = "compareTo(parseDate(getValue('dateFrom')), parseDate(getValue('dateTo'))) >= 1"
		)
	}
)
@DDMFormLayout(
	paginationMode = com.liferay.dynamic.data.mapping.model.DDMFormLayout.SINGLE_PAGE_MODE,
	value = {
		@DDMFormLayoutPage(
			value = {
				@DDMFormLayoutRow(
					{
						@DDMFormLayoutColumn(
							size = 12, value = {"dateFrom", "dateTo", "help"}
						)
					}
				)
			}
		)
	}
)
public interface DateValidation {

	@DDMFormField(type = "date")
	public String dateFrom();

	@DDMFormField(type = "date")
	public String dateTo();

}